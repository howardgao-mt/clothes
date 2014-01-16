$(document).ready(function(){
	var page = 1;
	var cruuPage, offset, totalPage, allRow;
	$("#search").click(function(){
		$.ajax({
			url:'jsonProduct_search.action',
			type:'post',
			data: {
				page : page
			},
			dataType:'json',
			error: errorMsg,
			success: function(data){
				$.each(data.list, function(i, value) {
					$("#prod"+i).html(
							value.productId + "<br>"
							+ value.productName);
				});
			}
		});
	});
	function errorMsg() {
		alert("Error!");
	};
	function countTotalPage(allRow, pageSize) {
		
	}
});