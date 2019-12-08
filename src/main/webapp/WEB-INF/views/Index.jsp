<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="BaseTag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>What is this?</title>

<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

<style>
	body { width:100%;height:100vh; }
	.loginBox { width:20vw;height:200px;margin:25vh 40vw;border:1px solid #ddd;background-color:#ddd;padding-top:30px; }
	input[type=text], input[type=password] { width:80%;height:50px;margin:0 10%;font-size:20px; }
	input[type=text], input[type=password]::placeholder { font-size:20px; }
	button { width:80%;height:50px;margin:0 10%;margin-top:20px; }
	.buttonBox:after { content:"";display:block;clear:both; }
</style>

</head>
<body>
	<div class="loginBox">
		<input type="text" name="id" maxlength="12" placeholder="ID" autocomplete="off" />
		<input type="password" name="password" maxlength="12" placeholder="PASSWORD" autocomplete="off" />
		<button type="button" id="btnLogin">로그인</button>
	</div>
</body>

<script type="text/javascript">
$(document).ready(function(){
	$("input").on("keyup", function(event){
		if(event.keyCode == 13)
		{
			$("#btnLogin").click();
		}
	});
	
	// 로그인 버튼
	$("#btnLogin").click(function(){
		$.ajax({
			 url : "/login"
			,data : {
				 id 		: $("[name=id]").val()
				,password 	: $("[name=password]").val()
			}
			,success : function(data){
				console.log(data);
				if(data == "Success!")
				{
					location.href="/Workspace";
				}
				else
				{
					alert("가입된 정보가 없습니다.");
				}
			}
		});
	});
});
</script>
</html>