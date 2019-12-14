<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/x-handlebars-template" id="listTemplate">
<li>
	<input type='text' class='input_title' autocomplete='off' />
	<button type='button' id='btnAdd' onclick='javascript:fn_AddWorkspace();'>Add</button>
</li>
</script>
<script type="text/javascript">
// Workspace 추가.
function fn_AddWorkspace()
{
	var workspaceTitle = $(".input_title").val();
	$.ajax({
		 url : "/Workspace/InsertWorkspace"
		,data : {
			workspaceTitle : workspaceTitle
		}
		,success : function(data){
			if(data.code == "200")
			{
				$("#btnAdd").parent("li").remove();
				location.reload();
			}
			else
			{
				alert(data.result);
			}
		}
	});
}

$(document).ready(function(){
	// Add 버튼 (+)
	$(".btnAdd").click(function(){
		if($("#btnAdd").length < 1)
		{
			var source 		= $("#listTemplate").html();
			var template 	= Handlebars.compile(source);
			var html 		= template();
			$(this).parent("li").prepend(template);
			$(".input_title").focus();
		}
		else
		{
			return false;
		}
	});
	
	// 전체선택
	$("#checkAll").click(function(){
		var checkbox = $("input[type=checkbox]");
		for(var i=0; i<checkbox.length; i++)
		{
			checkbox.eq(i).prop("checked", $(this).prop("checked"));
		}
	});
	
	// 등록 버튼
	$("#btnRegist").click(function(){
		$("[name=formRegist]").submit();
	});
	
	// 삭제 버튼
	$("#btnDelete").click(function(){
		var selectedSeqArr = new Array();
		var checkbox = $("tbody input[type=checkbox]");
		for(var i=0; i<checkbox.length; i++)
		{
			if(checkbox.eq(i).prop("checked"))
			{
				selectedSeqArr.push(checkbox.eq(i).val());
			}
		}
		
		console.log(selectedSeqArr.toString());
		
		$.ajax({
			 url : "/Workspace/DeletePosting"
			,data : {
				seqpostinglist : selectedSeqArr.toString()
			}
			,success : function(){
				location.reload();
			}
		});
	});
	
});
</script>