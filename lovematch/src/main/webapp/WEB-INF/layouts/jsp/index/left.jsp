<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript"src="<c:url value="/resources/js/date/WdatePicker.js" />"></script>
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
		&nbsp;&nbsp;&nbsp;&nbsp;
		<a class="date-filter" href="<c:url value='?order=asc'></c:url>">日期升序</a>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<a class="date-filter" href="<c:url value='?order=desc'></c:url>">日期降序</a>
	</div>
	<div class="row-fluid">
		<form class="pull-right"  action="<c:url value='/competitions/all/timefilter'></c:url>" method="get">
			<input placeholder="开始时间" value="${firstDate }" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate input-small" required="required" type="text" name="firstDate" > 
			 至  
			<input placeholder="结束时间" value="${lastDate }" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate input-small" required="required"   type="text" name="lastDate" >
			<button type="submit" class="btn" style="margin-bottom: 13px;">搜索</button>
		</form>
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
						<td width="50%" align="left" valign="top">
						<p><a
							href="<c:url value='/competitions/view/${page.id }'></c:url>"><b>${page.name}</b></a></p>
							<p><a
							href="<c:url value='${page.officialWebsite }'></c:url>">官方网址</a></p>
							<p><a target="_blank" href="${page.enrollLinke}">点击报名</a></p></td>
						<td width="30%" align="left" valign="top">
						<br>
						<p>比赛时间：<fmt:formatDate
								pattern="yyyy-MM-dd HH:mm" value="${page.competitionStartDate}"></fmt:formatDate></p>
							<p>报名时间：<fmt:formatDate pattern="yyyy-MM-dd HH:mm"
								value="${page.startDate}"></fmt:formatDate><br><span style="margin-left:20%;">至：<fmt:formatDate
								pattern="yyyy-MM-dd HH:mm" value="${page.endDate}"></fmt:formatDate></span></p>
						</td>
					</tr>
				</table>
			</div>
			<div class="row-fluid btm-line"></div>
		</c:forEach>
		<jsp:include page="/WEB-INF/views/_shared/pagination.jsp"></jsp:include>
	</div>
</div>
