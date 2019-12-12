<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="BaseTag" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<aside>
	<form name="changeWorkspace" action="/Workspace" method="POST">
		<input type="hidden" name="seqworkspace" value="" />
	</form>
	<div class="container">
		<h1>Workspace</h1>
		<ul>
			<c:forEach items="${workspaceList}" var="workspace">
				<li onclick="javascript:fn_ChangeWorkspace('${workspace.seqworkspace}');">
					<span>
						<img alt="list" src="/images/file-list-2-line.png"/>
						<span>&nbsp;&nbsp;${workspace.workspaceTitle}</span>
						<c:if test="${workspaceMap.seqworkspace eq workspace.seqworkspace}">&nbsp;<img class="selected" alt="select" src="/images/heart-fill.png"/></c:if>
					</span>
				</li>
			</c:forEach>
			<li><span class="btnAdd"><img alt="add" src="/images/add-line.png"/>Add..</span></li>
		</ul>
	</div>
</aside>