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
				<c:forEach items="${list}" var="data">
					<li onclick="javascript:fn_ChangeWorkspace('${data.SEQWORKSPACE}');">
						<span>
							<img alt="list" src="/images/file-list-2-line.png"/>
							<span>&nbsp;&nbsp;${data.TITLE}</span>
							<c:if test="${workspaceMap.SEQWORKSPACE eq data.SEQWORKSPACE}">&nbsp;<img class="selected" alt="select" src="/images/heart-fill.png"/></c:if>
						</span>
					</li>
				</c:forEach>
				<li><span class="btnAdd"><img alt="add" src="/images/add-line.png"/>Add..</span></li>
			</ul>
		</div>
	</aside>
	
	<section>
		<div class="container">
			<c:choose>
				<c:when test="${fn:length(list) > 0}">
					<div class="postingList">
						<table>
							<colgroup>
								<col width="10%" />
								<col width="10%" />
								<col width="" />
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
								<tr>
									<td><span><input type="checkbox" /></span></td>
									<td><span>1</span></td>
									<td><span class="pointer">첫번재 게시글입니다.</span></td>
									<td><span>2019-12-09 21:18:43</span></td>
									<td><span>pureboyz</span></td>
								</tr>
								<tr>
									<td><span><input type="checkbox" /></span></td>
									<td><span>2</span></td>
									<td><span class="pointer">두번재 게시글입니다.</span></td>
									<td><span>2019-12-09 21:18:43</span></td>
									<td><span>pureboyz</span></td>
								</tr>
								<tr>
									<td><span><input type="checkbox" /></span></td>
									<td><span>3</span></td>
									<td><span class="pointer">세번재 게시글입니다.</span></td>
									<td><span>2019-12-09 21:18:43</span></td>
									<td><span>pureboyz</span></td>
								</tr>
								<tr>
									<td><span><input type="checkbox" /></span></td>
									<td><span>4</span></td>
									<td><span class="pointer">네번재 게시글입니다.</span></td>
									<td><span>2019-12-09 21:18:43</span></td>
									<td><span>pureboyz</span></td>
								</tr>
								<tr>
									<td><span><input type="checkbox" /></span></td>
									<td><span>5</span></td>
									<td><span class="pointer">다섯번재 게시글입니다.</span></td>
									<td><span>2019-12-09 21:18:43</span></td>
									<td><span>pureboyz</span></td>
								</tr>
								<tr>
									<td><span><input type="checkbox" /></span></td>
									<td><span>1</span></td>
									<td><span class="pointer">첫번재 게시글입니다.</span></td>
									<td><span>2019-12-09 21:18:43</span></td>
									<td><span>pureboyz</span></td>
								</tr>
								<tr>
									<td><span><input type="checkbox" /></span></td>
									<td><span>2</span></td>
									<td><span class="pointer">두번재 게시글입니다.</span></td>
									<td><span>2019-12-09 21:18:43</span></td>
									<td><span>pureboyz</span></td>
								</tr>
								<tr>
									<td><span><input type="checkbox" /></span></td>
									<td><span>3</span></td>
									<td><span class="pointer">세번재 게시글입니다.</span></td>
									<td><span>2019-12-09 21:18:43</span></td>
									<td><span>pureboyz</span></td>
								</tr>
								<tr>
									<td><span><input type="checkbox" /></span></td>
									<td><span>4</span></td>
									<td><span class="pointer">네번재 게시글입니다.</span></td>
									<td><span>2019-12-09 21:18:43</span></td>
									<td><span>pureboyz</span></td>
								</tr>
								<tr>
									<td><span><input type="checkbox" /></span></td>
									<td><span>5</span></td>
									<td><span class="pointer">다섯번재 게시글입니다.</span></td>
									<td><span>2019-12-09 21:18:43</span></td>
									<td><span>pureboyz</span></td>
								</tr>
								<tr>
									<td><span><input type="checkbox" /></span></td>
									<td><span>1</span></td>
									<td><span class="pointer">첫번재 게시글입니다.</span></td>
									<td><span>2019-12-09 21:18:43</span></td>
									<td><span>pureboyz</span></td>
								</tr>
								<tr>
									<td><span><input type="checkbox" /></span></td>
									<td><span>2</span></td>
									<td><span class="pointer">두번재 게시글입니다.</span></td>
									<td><span>2019-12-09 21:18:43</span></td>
									<td><span>pureboyz</span></td>
								</tr>
								<tr>
									<td><span><input type="checkbox" /></span></td>
									<td><span>3</span></td>
									<td><span class="pointer">세번재 게시글입니다.</span></td>
									<td><span>2019-12-09 21:18:43</span></td>
									<td><span>pureboyz</span></td>
								</tr>
								<tr>
									<td><span><input type="checkbox" /></span></td>
									<td><span>4</span></td>
									<td><span class="pointer">네번재 게시글입니다.</span></td>
									<td><span>2019-12-09 21:18:43</span></td>
									<td><span>pureboyz</span></td>
								</tr>
								<tr>
									<td><span><input type="checkbox" /></span></td>
									<td><span>5</span></td>
									<td><span class="pointer">다섯번재 게시글입니다.</span></td>
									<td><span>2019-12-09 21:18:43</span></td>
									<td><span>pureboyz</span></td>
								</tr>
							</tbody>
						</table>
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
	</section>
</div>

</BaseTag:layout>
<%@ include file="WorkspaceScript.jsp" %>