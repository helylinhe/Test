﻿DATA={
	menu:[{//一级菜单
		menuid:'1',
		name:'主页',
		code:'m001',
		icon:'icon/home.png'
	},{//一级菜单
		menuid:'2',
		name:'其他',
		code:'m002',
		icon:'icon/history.png'
	}],
	app:{//桌面1
		'yuanhou':{
			appid:'1',
			icon: '1.png',
			name:'院后随访系统',
			url: 'index.jsp',
			sonMenu: "[]",
			asc :1
		},
		'pingtai':{
			appid:'2',
			icon: '2.png',
			name:'平台管理系统',
			url: 'jsp/platformManager/supervision.jsp',
			sonMenu:"[]",
			asc :2
		},
		'kefu':{
			appid:'3',
			icon: '3.png',
			name:'客户关系管理',
			url: 'jsp/custormRelationManager/crmmain.jsp',
			sonMenu:"[]",
			asc :3
		},'jiankang':{
			appid:'4',
			icon: '4.png',
			name:'健康评估系统',
			url: 'index.jsp',
			sonMenu:"[]",
			asc :4
		},'yiliao':{
			appid:'5',
			icon: '5.png',
			name:'疗效分析系统',
			url: 'index.jsp',
			sonMenu:"[]",
			asc :5
		},'manbing':{
			appid:'6',
			icon: '6.png',
			name:'慢病跟踪随访',
			url: 'index.jsp',
			sonMenu:"[]",
			asc :6
		},'fenzhen':{
			appid:'7',
			icon: '7.png',
			name:'分诊转诊管理',
			url: 'index.jsp',
			sonMenu:"[]",
			asc :1
		},'yuyue':{
			appid:'8',
			icon: '8.png',
			name:'预约检查',
			url: 'index.jsp',
			sonMenu:"[]",
			asc :2
		},'jiating':{
			appid:'9',
			icon: '9.png',
			name:'家庭病床',
			url: 'index.jsp',
			sonMenu:"[]",
			asc :3
		},'yilian':{
			appid:'10',
			icon: '10.png',
			name:'医联卡管理',
			url: 'index.jsp',
			sonMenu:"[]",
			asc :4
		},'dangan':{
			appid:'11',
			icon: '11.png',
			name:'健康档案',
			url: 'index.jsp',
			sonMenu:"[]",
			asc :5
		},'weixin':{
			appid:'12',
			icon: '12.png',
			name:'微信后台管理',
			url: 'index.jsp',
			sonMenu:"[]",
			asc :6
		}
	},
	sApp:{//侧边栏应用
		'appmarket':{
			appid:'1',
			icon:'1.png',
			name:'dsafsa',
			url:'http://www.jq-school.com/',
			sonMenu:"[]",
			asc :1
		}
	
	}
};
ops = {//向桌面添加应用
	Icon1:['yuanhou','pingtai','kefu','jiankang','yiliao','manbing'],
	Icon2:['fenzhen','yuyue','jiating','yilian','dangan','weixin']
}
//初始化左边快捷菜单
var leftMenu = new Array(['appmarket']);
