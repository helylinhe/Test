$(function() {
	
	/****
	 * 获取菜单项
	 */
	$("#menuroles").tree({
		 url:path+'/roleaction!menuRoles.action',
		 method:'get'
	});
	
	/***
	 * 获取角色
	 */
	$('#rolelist').tree({
	    url:path+'/roleaction!findRoleList.action',
		method:'get',
		onSelect: function(node){
				$.post(path+'/sysmenudefiaction!menuList.action',{"map.code":node.roleCode},function (data){
					
					$.each($("#menuroles  li span"),function (j,n){
						$(this).prev().removeClass("tree-checkbox1");
				     })
					if(data!=null && data.length>0){
						for(var i=0; i<data.length;i++){  
						     var arr=$("#menuroles  li span");
						     $.each(arr,function (j,n){
						    	 if($(this).html()==data[i].menuName){
						    		 $(this).prev().addClass("tree-checkbox1");
						    	 }
						     })
						  }
					}
				},'json');
		}

	});
	

	/***
	 * 获取父菜单
	 */
	$.post(path+'/sysmenudefiaction!parentMenuItem.action',function(data){
		var html="";
		if(data!=null && data != []){
			for(var i=0;i<data.length;i++){
				html+="<option value='"+data[i].menuCode+"'>" ;
				html+=data[i].menuName
				html+="</option>";
			}
		}
		$("#parentMenu").html(html);
	},'json');
	
	
	
});
// 随访编辑
function add_role_winopen() {
	$("#add_role").window("open");
}
function add_role_winclose() {
	$("#add_role").window("close");
}


function saveRole(){
	var param={"map.roleName":$("#roleName").val(),"map.memo":$("#memo").val()};
	$.post(path+'/roleaction!addRole.action',param,function (data){
		if(data=='success'){
			$.messager.alert('消息','添加成功','info');
			window.location.href=path+'/jsp/system/rolePerm.jsp';
		}else{
			$.messager.alert('消息','添加失败','error');
			window.location.href=path+'/jsp/system/rolePerm.jsp';
		}
	},'text');
}

/****
 * 添加角色
 * @return
 */
function saveRolePriv(){
	var roleNodes = $('#rolelist').tree('getSelected');
	var menuNode=$("#menuroles").tree('getChecked');
	var arrPrivs="";
	if(menuNode.length>0){
		for(var i=0;i<menuNode.length;i++){
			if(menuNode[i].menuLevel!=null){
				arrPrivs+=menuNode[i].menuCode+",";
			}
		}
		var param={"map.roleCode":roleNodes.roleCode,"map.privsId":arrPrivs};
		$.post(path+'/roleprivsaction!addRolePrivs.action',param,function (data){
			if(data==1){
				$.messager.alert('提示','添加成功','info');
				
			}
		},'json');
	}
}

/**
 * 添加子菜单
 * @return
 */
function saveMenuItemName(){
	var menuHigherNo=$("#parentMenu option:selected").val();
	var menuName=$("#menuName").val();
	var urlAddress=$("#urlAddress").val();
	var param={'map.menuHigherNo':menuHigherNo,'map.menuName':menuName,'map.urlAddress':urlAddress};
	$.post(path+'/sysmenudefiaction!addMenuItem.action',param,function (data){
		if(data=='success'){
			$.messager.alert('消息','添加成功','info');
			 window.location.href=path+'/jsp/system/rolePerm.jsp';
		}else{
			$.messager.alert('消息','添加失败','error');
		}
	});
}

function menuItemOpen(){
	$("#addMenuItem").window("open");
}


function closeMenuWindow(){
	$("#addMenuItem").window("close");
}
