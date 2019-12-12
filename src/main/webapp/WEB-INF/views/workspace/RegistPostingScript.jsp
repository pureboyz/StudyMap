<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
// ckeditor textarea의 name을 editor로 지정.
CKEDITOR.replace('editor', {
	 extraPlugins: 'codesnippet'
	,height: 500
});

$(document).ready(function(){
	// 등록 버튼
	$("#btnRegist").click(function(){
		
	});
	
	// 취소 버튼
	$("#btnCancel").click(function(){
		location.href="/Workspace";
	});
});
</script>