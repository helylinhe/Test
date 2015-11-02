package com.linkonworks.df.busi.comment;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Properties;
import java.sql.Connection;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.builder.xml.dynamic.ForEachSqlNode;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.executor.parameter.DefaultParameterHandler;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;

@Intercepts(value = { @Signature(method="prepare",type=StatementHandler.class,args=Connection.class) })
public class PageInterceptor implements Interceptor{

	private String databaseType;//数据库类型，不同的数据库有不同的分页方法
	
	
	public Object intercept(Invocation invocation) throws Throwable {
		//是通过Interceptor的plugin方法进行包裹的，所以我们这里拦截到的目标对象肯定是RoutingStatementHandler对象。 
		RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
		//通过反射获取到当前RoutingStatementHandler对象的delegate属性  
		 StatementHandler delegate = (StatementHandler)ReflectUtil.getFieldValue(handler, "delegate"); 
		 //获取到当前StatementHandler的 boundSql
		 BoundSql boundSql=delegate.getBoundSql();
		//拿到当前绑定Sql的参数对象，就是我们在调用对应的Mapper映射语句时所传入的参数对象 
		 Object obj=boundSql.getParameterObject();
		 if(obj instanceof Page<?>){
			 Page<?> page = (Page<?>) obj;  
			 MappedStatement mappedStatement = (MappedStatement)ReflectUtil.getFieldValue(delegate, "mappedStatement"); 
			//拦截到的prepare方法参数是一个Connection对象  
	           Connection connection = (Connection)invocation.getArgs()[0]; 
	           String sql=boundSql.getSql();
	         //给当前的page参数对象设置总记录数  
	           this.setTotalRecord(page,mappedStatement, connection);  
	           //获取分页Sql语句  
	           String pageSql = this.getPageSql(page, sql);  
	           //利用反射设置当前BoundSql对应的sql属性为我们建立好的分页Sql语句  
	           ReflectUtil.setFieldValue(boundSql, "sql", pageSql);  
		 }
		return invocation.proceed();
	}

	
	public Object plugin(Object target) {
		// TODO Auto-generated method stub
		return Plugin.wrap(target, this);
	}

	
	public void setProperties(Properties properties) {
		this.databaseType = properties.getProperty("databaseType");
		
	}
	
	
	private String getPageSql(Page<?> page, String sql) {  
	       StringBuffer sqlBuffer = new StringBuffer(sql);  
	       if ("mysql".equalsIgnoreCase(databaseType)) {  
	           return getMysqlPageSql(page, sqlBuffer);  
	       } else if ("oracle".equalsIgnoreCase(databaseType)) {  
	           return getOraclePageSql(page, sqlBuffer);  
	       }  
	       return sqlBuffer.toString();  
	    }  
	
	/** 
     * 获取Mysql数据库的分页查询语句 
     * @param page 分页对象 
     * @param sqlBuffer 包含原sql语句的StringBuffer对象 
     * @return Mysql数据库分页语句 
     */  
    private String getMysqlPageSql(Page<?> page, StringBuffer sqlBuffer) {  
       //计算第一条记录的位置，Mysql中记录的位置是从0开始的。  
       int offset = (page.getPageNo() - 1) * page.getPageSize();  
       sqlBuffer.append(" limit ").append(offset).append(",").append(page.getPageSize());  
       return sqlBuffer.toString();  
    }  
     
    /** 
     * 获取Oracle数据库的分页查询语句 
     * @param page 分页对象 
     * @param sqlBuffer 包含原sql语句的StringBuffer对象 
     * @return Oracle数据库的分页查询语句 
     */  
    private String getOraclePageSql(Page<?> page, StringBuffer sqlBuffer) {  
       //计算第一条记录的位置，Oracle分页是通过rownum进行的，而rownum是从1开始的  
       int offset = (page.getPageNo() - 1) * page.getPageSize() + 1;  
       sqlBuffer.insert(0, "select u.*, rownum r from (").append(") u where rownum < ").append(offset + page.getPageSize());  
       sqlBuffer.insert(0, "select * from (").append(") where r >= ").append(offset);  
       //上面的Sql语句拼接之后大概是这个样子：  
       //select * from (select u.*, rownum r from (select * from t_user) u where rownum < 31) where r >= 16  
       return sqlBuffer.toString();  
    }  
	
	
	private void setTotalRecord(Page<?> page,MappedStatement mappedStatement,Connection connection) {
		BoundSql boundSql=mappedStatement.getBoundSql(page);
		
		String sql=boundSql.getSql();
		String countSql=this.getCountSql(sql);
		//通过BoundSql获取对应的参数映射  
	       List<ParameterMapping> parameterMappings = boundSql.getParameterMappings(); 
	       
	       //利用Configuration、查询记录数的Sql语句countSql、参数映射关系 parameterMappings和参数对象page建立查询记录数对应的BoundSql对象。
	       BoundSql  countBoundSql=new BoundSql(mappedStatement.getConfiguration(), countSql, parameterMappings, page);
	       
	       for(ParameterMapping pm:parameterMappings){
	    	   String propertyName=pm.getProperty();
	    	   if(propertyName.startsWith(ForEachSqlNode.ITEM_PREFIX)){
		    	   countBoundSql.setAdditionalParameter(propertyName, boundSql.getAdditionalParameter(propertyName));
	    	   }
	       }
	     //通过mappedStatement、参数对象page和BoundSql对象countBoundSql建立一个用于设定参数的ParameterHandler对象  
	       ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, page, countBoundSql); 
	     
	     //通过connection建立一个countSql对应的PreparedStatement对象。  
	       PreparedStatement pstmt = null;  
	       ResultSet rs = null;  
	       try {
			pstmt=connection.prepareStatement(countSql);
			//this.setParameters(pstmt, mappedStatement, countBoundSql, page);
			parameterHandler.setParameters(pstmt);
			rs=pstmt.executeQuery();
			if (rs.next()) {  
	              int totalRecord = rs.getInt(1);  
	              //给当前的参数page对象设置总记录数  
	              page.setTotalRecord(totalRecord);  
	           }  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {  
	              if (rs != null)  
	                  rs.close();  
	               if (pstmt != null)  
	                  pstmt.close();  
	           } catch (SQLException e) {  
	              e.printStackTrace();  
	           }  
		}
	}  
	
	private String getCountSql(String sql){
		int index=sql.indexOf("from");
		return "select count(*) " + sql.substring(index);
	}
	
	
	private static class ReflectUtil {  
	       /** 
	        * 利用反射获取指定对象的指定属性 
	        * @param obj 目标对象 
	        * @param fieldName 目标属性 
	        * @return 目标属性的值 
	        */  
	       public static Object getFieldValue(Object obj, String fieldName) {  
	           Object result = null;  
	           Field field = ReflectUtil.getField(obj, fieldName);  
	           if (field != null) {  
	              field.setAccessible(true);  
	              try {  
	                  result = field.get(obj);  
	              } catch (IllegalArgumentException e) {  
	                  // TODO Auto-generated catch block  
	                  e.printStackTrace();  
	              } catch (IllegalAccessException e) {  
	                  // TODO Auto-generated catch block  
	                  e.printStackTrace();  
	              }  
	           }  
	           return result;  
	       }  
	        
	       /** 
	        * 利用反射获取指定对象里面的指定属性 
	        * @param obj 目标对象 
	        * @param fieldName 目标属性 
	        * @return 目标字段 
	        */  
	       private static Field getField(Object obj, String fieldName) {  
	           Field field = null;  
	          for (Class<?> clazz=obj.getClass(); clazz != Object.class; clazz=clazz.getSuperclass()) {  
	              try {  
	                  field = clazz.getDeclaredField(fieldName);  
	                  break;  
	              } catch (NoSuchFieldException e) {  
	                  //这里不用做处理，子类没有该字段可能对应的父类有，都没有就返回null。  
	              }  
	           }  
	           return field;  
	       }  
	   
	       /** 
	        * 利用反射设置指定对象的指定属性为指定的值 
	        * @param obj 目标对象 
	        * @param fieldName 目标属性 
	         * @param fieldValue 目标值 
	        */  
	       public static void setFieldValue(Object obj, String fieldName,  
	              String fieldValue) {  
	           Field field = ReflectUtil.getField(obj, fieldName);  
	           if (field != null) {  
	              try {  
	                  field.setAccessible(true);  
	                  field.set(obj, fieldValue);  
	              } catch (IllegalArgumentException e) {  
	                  // TODO Auto-generated catch block  
	                  e.printStackTrace();  
	              } catch (IllegalAccessException e) {  
	                  // TODO Auto-generated catch block  
	                  e.printStackTrace();  
	              }  
	           }  
	        } 
	}  
	
	
	 private void setParameters(PreparedStatement ps,MappedStatement mappedStatement,BoundSql boundSql,Object parameterObject) throws SQLException { 
	        ErrorContext.instance().activity("setting parameters").object(mappedStatement.getParameterMap().getId()); 
	        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings(); 
	        if (parameterMappings != null) { 
	            Configuration configuration = mappedStatement.getConfiguration(); 
	            TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry(); 
	            MetaObject metaObject = parameterObject == null ? null: configuration.newMetaObject(parameterObject); 
	            for (int i = 0; i < parameterMappings.size(); i++) { 
	                ParameterMapping parameterMapping = parameterMappings.get(i); 
	                if (parameterMapping.getMode() != ParameterMode.OUT) { 
	                    Object value; 
	                    String propertyName = parameterMapping.getProperty(); 
	                    PropertyTokenizer prop = new PropertyTokenizer(propertyName); 
	                    if (parameterObject == null) { 
	                        value = null; 
	                    } else if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) { 
	                        value = parameterObject; 
	                    } else if (boundSql.hasAdditionalParameter(propertyName)) { 
	                        value = boundSql.getAdditionalParameter(propertyName); 
	                    } else if (propertyName.startsWith(ForEachSqlNode.ITEM_PREFIX)&& boundSql.hasAdditionalParameter(prop.getName())) { 
	                        value = boundSql.getAdditionalParameter(propertyName); 
	                        if (value != null) { 
	                            value = configuration.newMetaObject(value).getValue(propertyName.substring(prop.getName().length())); 
	                        } 
	                    } else { 
	                        value = metaObject == null ? null : metaObject.getValue(propertyName); 
	                    } 
	                    TypeHandler typeHandler = parameterMapping.getTypeHandler(); 
	                    if (typeHandler == null) { 
	                        throw new ExecutorException("There was no TypeHandler found for parameter "+ propertyName + " of statement "+ mappedStatement.getId()); 
	                    } 
	                    typeHandler.setParameter(ps, i + 1, value, parameterMapping.getJdbcType()); 
	                } 
	            } 
	        } 
	    } 
}
