<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="BaseTag" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<BaseTag:layout>

<div class="main_container">
	<aside>
		<div class="container">
			<h1>Workspace</h1>
			<ul>
				<c:forEach items="${list}" var="list">
					<li><span>${list.title}</span></li>
				</c:forEach>
				<li><span class="btnAdd"><img class="add_line" alt="add" src="/images/add-line.png"/>Add..</span></li>
			</ul>
		</div>
	</aside>
	
	<section>
		<div class="container">
			<c:choose>
				<c:when test="${fn:length(list) > 0}">
					<h1>Hello!</h1>
				</c:when>
				<c:otherwise>
					<div class="emptyWorkspace">
						<span>Add a workspace..</span>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</section>
</div>

</BaseTag:layout>
<%@ include file="WorkspaceScript.jsp" %>