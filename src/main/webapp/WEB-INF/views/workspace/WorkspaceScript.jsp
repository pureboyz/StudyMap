<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
$(document).ready(function(){
	// Add 버튼
	$(".btnAdd").click(function(){
		$(this).parent("li").prepend("<li><input type='text' class='input_title' /><button>Add</button></li>");
	});
});
</script>