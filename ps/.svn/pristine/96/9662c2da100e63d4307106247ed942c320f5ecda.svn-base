$(function(){
	
	
	/*****
	 * 文本框获得焦点
	 */
	$("#txtJobnumber").focus();
	
	
	$("#txtJobnumber").keydown(function(event){
		if(event.keyCode==13){
			$("#txtPassword").focus();
		}
	});
	
	$("#txtPassword").keydown(function(event){
		if(event.keyCode==13){
			$("#btnLogin").trigger("click");
		}
	});
	
	$("#btnLogin").click(function () {
        var jobNumber = $('#txtJobnumber').val();
        var password = $('#txtPassword').val();
        if (jobNumber == "") {
            $.messager.alert('提示', "工号不能为空!", 'warning');
            $('#txtJobnumber').focus();
            return false;
        }
        if (password == "") {
            $.messager.alert('提示', "密码不能为空!", 'warning');
            $("#txtPassword").focus();
            return false;
        }
        $.ajax({
            type: "POST",
            loading: '正在登陆中...',
            url: path+"/employeeAction!login.action",
            data: $('#login-form').serializeArray(),
            dataType: "json",
            complete: function () {
                
            },
            success: function (result) {
                if (result.success) {
                    window.location.href = result.url;
                } else {
                    //HideWaitMessageDialog(jWaitDialog);
                    $.messager.alert('提示', result.msg, 'warning');
                    $('#txtJobnumber').focus();
                    return;
                }
            },
            error: function () {
                //HideWaitMessageDialog(jWaitDialog);
                $.messager.alert('提示', '发送系统错误,请与系统管理员联系!', 'error');
            }
        });
        return false;
    });
})