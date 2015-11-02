function submit(){
	if($("#pwdNow").validatebox("isValid")&&$("#password").validatebox("isValid")
			&&$("#repassword").validatebox("isValid")){
	$.ajax({
        type: "post",
        url: path+'/employeeAction!updatePwd.action',
        dataType : "json",
        data:{"employee.passwd":$("#pwdNow").val(),
        	  "employee.newPwd1":$("#password").val(),
        	  "employee.newPwd2":$("#repassword").val()},
        success: function(data){
        		  $("#pwdNow").val("");
              	$("#password").val("");
              	$("#repassword").val("");
              	
              	$.messager.confirm('提示',data[0].message,function(r){    
              	    if (r){    
              	    	window.top.location.href = data[0].url;
              	    }else{
              	    	window.top.location.href = data[0].url;
              	    }    
              	}); 

      }
	});
  }
}