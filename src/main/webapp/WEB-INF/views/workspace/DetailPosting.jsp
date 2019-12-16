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
			<form action="/Workspace/ModifyPosting" name="formModifyPosting" method="POST">
				<input type="hidden" name="seqworkspace" value="${aside.workspaceMap.seqworkspace}" />
				<input type="hidden" name="seqpostinglist" value="${postingMap.seqpostinglist}" />
				<input type="text" class="inputTitle" name="postingTitle" value="${postingMap.postingTitle}" autocomplete="off" maxlength="100" />
				<textarea name="postingContent">${postingMap.postingContents}</textarea>
			</form>
		</div>
		<div class="buttonBox">
			<button type="button" class="btn-default" id="btnModify">수정</button>
			<button type="button" class="btn-default" id="btnList">목록</button>
		</div>
	</section>
	
	<!-- 목록 버튼 form -->
	<form action="/Workspace" name="formPostingList" method="POST">
		<input type="hidden" name="seqworkspace" value="${aside.workspaceMap.seqworkspace}" />
	</form>
	<!-- //목록 버튼 form -->

</div>

</BaseTag:layout>
<%@ include file="DetailPostingScript.jsp" %>