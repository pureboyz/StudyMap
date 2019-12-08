<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
// Workspace 추가.
function fn_AddWorkspace()
{
	var title = $("[name=title]").val();
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
	// Add 버튼 (+)
	$(".btnAdd").click(function(){
		if($("#btnAdd").length < 1)
		{
			var template  = "";
				template += "<li>";
				template += "<input type='text' class='input_title' name='title' autocomplete='off' />";
				template += "<button type='button' id='btnAdd' onclick='javascript:fn_AddWorkspace();'>Add</button>";
				template += "</li>";
			$(this).parent("li").prepend(template);
		}
		else
		{
			return false;
		}
	});
	
});
</script>