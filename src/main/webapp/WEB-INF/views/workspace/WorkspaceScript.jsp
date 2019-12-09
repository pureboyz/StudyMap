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
	var title = $(".input_title").val();
	$.ajax({
		 url : "/Workspace/InsertWorkspace"
		,data : {
			title : title
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

// Workspace 이동.
function fn_ChangeWorkspace(seqworkspace)
{
	location.href="/Workspace?seqworkspace="+seqworkspace;
}
$(document).ready(function(){
	// ckeditor textarea의 name을 editor로 지정.
// 	CKEDITOR.replace('editor', {
// 		extraPlugins: 'codesnippet'
// 	});
	
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
	
});
</script>