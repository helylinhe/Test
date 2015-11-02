$.extend($.fn.validatebox.defaults, {
	missingMessage : '不能为空！'
});
var rules = {
	min_len : {// 自定义：验证最小字符数
		validator : function(value, param) {
			var len = $.trim(value).replace(/[^\x00-\xff]/g, "rr").length;// 一个中文字符转为2个英文字符来计算总长度
		return len >= param[0];
	},
	message : '输入有误，最少{0}个字符。'
	},
	max_len : {// 自定义：验证最大字符数
		validator : function(value, param) {
			var len = $.trim(value).replace(/[^\x00-\xff]/g, "rr").length;// 一个中文字符转为2个英文字符来计算总长度
		return len <= param[0];
	},
	message : '输入有误，最多{0}个字符。'
	},
	between_len : {// 自定义：字符范围的验证规则。
		validator : function(value, param) {
			var len = $.trim(value).replace(/{([^}]*)}/g, '$1').replace(
					/[^\x00-\xff]/g, "rr").length;// 一个中文字符转为2个英文字符来计算总长度
			return len >= param[0] && len <= param[1];
		},
		message : '输入有误，最少{0}个字符，最多{1}个字符。'
	},
	min_val : {// 自定义：验证最小值
		validator : function(value, param) {
			return $.trim(value) >= param[0];
		},
		message : '输入有误，不能小于{0}。'
	},
	max_val : {// 自定义：验证最大值
		validator : function(value, param) {
			return $.trim(value) <= param[0];
		},
		message : '输入有误，不能大于{0}。'
	},
	between_val : {// 自定义：验证值区间
		validator : function(value, param) {
			return $.trim(value) >= param[0] && $.trim(value) <= param[1];
		},
		message : '输入有误，必须大于等于{0}且小于等于{1}。'
	},
	isUnsignedNumeric : {// 是否为正数
		validator : function(value, param) {
			var p = /^\d+(.\d+)?$/;
			return p.test(value);
		},
		message : '输入有误，请输入正数。'
	},
	zip : {// 验证邮政编码
		validator : function(value, param) {
			var p = /^\d{6}$/;
			return p.test(value);
		},
		message : '请输入正确的邮政编码。'
	},
	tel : {// 验证电话号码或传真号
		validator : function(value, param) {
			var p = /^(([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/;
			return p.test(value);
		},
		message : '请输入正确的号码:号码格式为国家代码(2到3位)-区号(2到3位)-电话号码(7到8位)-分机号(3位)。'
	},
	phone : {
		validator : function(value, param) {
			var p = /^1\d{10}$/;
			return p.test(value);
		},
		message : '请输入正确的手机号码。'
	},
	autoAddHttpUrl : {
		validator : function(value, param) {
			if (value.indexOf('http://') == -1
					&& value.indexOf('https://') == -1)
				value = 'http://' + value;
			return $.fn.validatebox.defaults.rules.url.validator(value);
		},
		message : $.fn.validatebox.defaults.rules.url.message
	},
	card : {
		validator : function(value, param) {
			var p = /^[1-9]{1}[0-9]{14}$|^[1-9]{1}[0-9]{16}([0-9]|[xX])$/;
			return p.test(value);
		},
		message : '请输入正确的身份证号码！'
	},
	checkJobnum : {
		validator : function(value, param) {
			value = $.trim(value);
			/*
			 * this.message = '您的输入有误，请重新输入...'; var p = /^\d{10}$/; if
			 * (!p.test(value)) return false;
			 */
			this.message = '工号重复，请重新输入。';
			var flag = $.ajax( {
				url : path + '/employeeAction!checkJobnum.action',
				data : {
					'jobnum' : value
				},
				async : false,
				cache : false,
				type : "post"
			}).responseText;
			return flag == 'false';
		}
	},
	checkPati : {
		validator : function(value, param) {
			value = $.trim(value);
			this.message = '所输入住院号,病人编号,医保编号不能已有的重复！';
			var flag = $.ajax( {
				url : path + '/patiAction!checkPati.action',
				data : {
				'pati.patiSerial' : $('#pati_serial').val(),
				'pati.inpatiNumber' : $('#inpati_number').val()
				},
				async : false,
				cache : false,
				type : "post"
			}).responseText;
			return flag == 'false';
		}
	}
};
$.extend($.fn.validatebox.defaults.rules, rules);