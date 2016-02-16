<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
a[class='date-filter']:hover {
	color: #ff6920;
	border-bottom: 2px solid #ccc;
	padding-bottom: 5px;
}
</style>

<div class="row-fluid container_div">
	<div class="row-fluid date-div">
		<a class="date-filter date-active" href="#">近期活动</a>
		&nbsp;&nbsp;&nbsp;&nbsp;<a class="date-filter" href="<c:url value='?order=asc'></c:url>">日期升序</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="date-filter" href="<c:url value='?order=desc'></c:url>">日期降序</a>
	</div>
	<div class="row-fluid">
		<c:forEach items="${page.content }" var="page">
			<div class="competition-div">
				<table style="width: 100%;">
					<tr>
						<td width="20%" align="left" valign="top"><a
							href="<c:url value='/competitions/view/${page.id }'></c:url>"><img
								class="img-polaroid " style="height: 60px;"
								src="<c:url value='${page.picPath }'></c:url>"></a></td>
						<td width="60%" align="left" valign="top"><a
							href="<c:url value='/competitions/view/${page.id }'></c:url>"><b>${page.name}</b></a><br>
							<a target="_blank" href="${page.enrollLinke}">点击报名</a></td>
						<td width="20%" align="left" valign="top">${page.postDate }</td>
					</tr>
				</table>
			</div>
			<div class="row-fluid btm-line"></div>
		</c:forEach>
		<jsp:include page="/WEB-INF/views/_shared/pagination.jsp"></jsp:include>
	</div>
</div>


