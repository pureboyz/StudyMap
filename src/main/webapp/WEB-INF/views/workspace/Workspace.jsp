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
			<c:choose>
				<c:when test="${fn:length(aside.workspaceList) > 0}">
					<div class="postingList">
						<div class="tableBox">
							<table>
								<colgroup>
									<col width="10%" />
									<col width="10%" />
									<col width="40%" />
									<col width="20%" />
									<col width="20%" />
								</colgroup>
								<thead>
									<tr>
										<th><input type="checkbox" id="checkAll" /></th>
										<th><span>No</span></th>
										<th><span>제목</span></th>
										<th><span>작성일</span></th>
										<th><span>작성자</span></th>
									</tr>
								</thead>
								<tbody>
									<c:choose>
										<c:when test="${fn:length(aside.postingList) > 0}">
											<c:forEach items="${aside.postingList}" var="posting">
												<tr>
													<td><span><input type="checkbox" value="${posting.seqpostinglist}" /></span></td>
													<td><span>${posting.rowNum}</span></td>
													<td><span class="pointer">${posting.postingTitle}</span></td>
													<td><span>${posting.createdate}</span></td>
													<td><span>${posting.postingWriter}</span></td>
												</tr>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<tr>
												<td colspan="5">Add a posting..</td>
											</tr>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
						</div>
						<div class="pagination">
							<span><img alt="left" src="/images/arrow-left-s-line.png"/></span>
							<c:forEach var="i" begin="1" end="10" step="1">
								<c:choose>
									<c:when test="${i eq 4}">
										<span class="on">${i}</span>
									</c:when>
									<c:otherwise>
										<span>${i}</span>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<span><img alt="rightt" src="/images/arrow-right-s-line.png"/></span>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="emptyWorkspace">
						<span>Add a workspace..</span>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
		<form action="/Workspace/RegistPosting" name="formRegist" method="POST">
			<div class="buttonBox">
				<input type="hidden" name="seqworkspace" value="${aside.workspaceMap.seqworkspace}" />
				<button type="button" class="btn-default" id="btnRegist">등록</button>
				<button type="button" class="btn-default" id="btnDelete">삭제</button>
			</div>
		</form>
	</section>
</div>

</BaseTag:layout>
<%@ include file="WorkspaceScript.jsp" %>