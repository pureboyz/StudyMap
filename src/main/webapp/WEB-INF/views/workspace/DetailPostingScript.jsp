<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
// ckeditor textarea의 name을 editor로 지정.
CKEDITOR.replace('postingContent', {
	 extraPlugins: 'codesnippet'
	,height: 500
});

$(document).ready(function(){
	// 수정 버튼
	$("#btnModify").click(function(){
		$("[name=formModifyPosting]").submit();
	});
	
	// 목록 버튼
	$("#btnList").click(function(){
		$("[name=formPostingList]").submit();
	});
});
</script>