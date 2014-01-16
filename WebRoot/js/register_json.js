$(document).ready(function() {
	$("#chkEmail").click(function(){
		$.ajax({
			url:"json_register.action",
			type:"post",
			data: {
				value:$("#memberEmail").val()
			},
			dataType:"json",
			error:function() {
				alert("error!");
			},
			success:function(data){
				alert();
			}
		});
	});
});