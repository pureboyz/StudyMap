<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="BaseTag" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<BaseTag:layout>

<div class="main_container">

	<%@ include file="Aside.jsp" %>
	
	<section>
		<div class="container">
			<form action="/Workspace/InsertPosting" name="formRegist" method="POST">
				<input type="hidden" name="seqworkspace" value="${aside.workspaceMap.seqworkspace}" />
				<input type="text" class="inputTitle" name="postingTitle" placeholder="Title.." autocomplete="off" maxlength="100" />
				<textarea name="postingContent"></textarea>
			</form>
		</div>
		<div class="buttonBox">
			<button type="button" class="btn-default" id="btnRegist">등록</button>
			<button type="button" class="btn-default" id="btnCancel">취소</button>
		</div>
	</section>

</div>

</BaseTag:layout>
<%@ include file="RegistPostingScript.jsp" %>