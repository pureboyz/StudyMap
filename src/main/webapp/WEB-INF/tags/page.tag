<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<form action="/Workspace" name="formPage" method="POST">
	<input type="hidden" name="seqworkspace" value="${aside.workspaceMap.seqworkspace}" />
	<input type="hidden" name="page" value="" />
	<div class="pagination">
		<c:if test="${aside.postingPagination.prev}">
			<span onclick="javascript:fn_goPrevPage()"><img alt="left" src="/images/arrow-left-s-line.png"/></span>
		</c:if>
		<c:forEach var="i" begin="${aside.postingPagination.startPage}" end="${aside.postingPagination.endPage}">
			<c:choose>
				<c:when test="${i eq aside.postingPagination.currentPage}">
					<span class="on" onclick="javascript:fn_goPage('${i}')">${i}</span>
				</c:when>
				<c:otherwise>
					<span onclick="javascript:fn_goPage('${i}')">${i}</span> 
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${aside.postingPagination.next}">
			<span onclick="javascript:fn_goNextPage()"><img alt="rightt" src="/images/arrow-right-s-line.png"/></span>
		</c:if>
	</div>
</form>

<script type="text/javascript">
function fn_goPage(page)
{
	$("[name=page]").val(page);
	$("[name=formPage]").submit();
}

function fn_goPrevPage()
{
	$("[name=page]").val(Number($("span.on").html()) - 1);
	$("[name=formPage]").submit();
}

function fn_goNextPage()
{
	$("[name=page]").val(Number($("span.on").html()) + 1);
	$("[name=formPage]").submit();
}
</script>