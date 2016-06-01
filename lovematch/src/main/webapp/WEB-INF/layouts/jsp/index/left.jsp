<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript"
	src="<c:url value="/resources/js/date/WdatePicker.js" />"></script>
<style>
a[class='date-filter']:hover {
	color: #ff6920;
	border-bottom: 2px solid #ccc;
	padding-bottom: 5px;
}
</style>

<script>
	function getUrlParam(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null)
			return unescape(r[2]);
		return null;
	}

	var status = getUrlParam('status');
	var order = getUrlParam('order');
	var urlString = window.location.href;
	var urlSerach = window.location.search;
</script>

<div class="row-fluid container_div">
	<div class="row-fluid date-div">
		<a class="date-filter date-active" style="border-bottom: #ff6920;"
			href="?status=active">近期活动</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
			class="date-filter date-active" style="border-bottom: #ff6920;"
			href="?status=inactive">往期活动</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
			id="orderAsc" class="date-filter" style="font-size: 10px;" href="#">日期升序</a>
		&nbsp;&nbsp;&nbsp;&nbsp; <a id="orderDesc" class="date-filter"
			style="font-size: 10px;" href="#">日期降序</a>
	</div>
	<script>
		if (urlString.indexOf("timefilter") >= 0) {
			$("#orderAsc").prop("href", urlSerach + "&order=asc");
			$("#orderDesc").prop("href", urlSerach + "&order=desc");
		} else if (status == "null") {
			$("#orderAsc").prop("href", "?status=active&order=asc");
			$("#orderDesc").prop("href", "?status=active&order=desc");
		} else {
			$("#orderAsc").prop("href", "?status=" + status + "&order=asc");
			$("#orderDesc").prop("href", "?status=" + status + "&order=desc");
		}
	</script>
	<div class="row-fluid">
		<form class="pull-right"
			action="<c:url value='/competitions/all/timefilter'></c:url>"
			method="get">
			<input placeholder="开始时间" value="${firstDate }"
				onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
				class="Wdate input-small" type="text" name="firstDate"> 至 <input
				placeholder="结束时间" value="${lastDate }"
				onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
				class="Wdate input-small" type="text" name="lastDate">
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
							<p>
								<a href="<c:url value='/competitions/view/${page.id }'></c:url>"><b>${page.name}</b></a>
							</p>
							<p>
								<a href="<c:url value='${page.officialWebsite }'></c:url>">官方网址</a>
							</p>
							<p>
								<a target="_blank" href="${page.enrollLinke}">点击报名</a>
							</p>
						</td>
						<td width="30%" align="left" valign="top"><br>
							<p>
								比赛时间：
								<c:if test="${empty page.competitionStartDate}">未定</c:if>
								<fmt:formatDate pattern="yyyy-MM-dd HH:mm"
									value="${page.competitionStartDate}"></fmt:formatDate>
							</p>
							<p>
								报名时间：
								<c:if test="${empty page.startDate}">未定</c:if>
								<fmt:formatDate pattern="yyyy-MM-dd HH:mm"
									value="${page.startDate}"></fmt:formatDate>
								<br> <span style="margin-left: 20%;">至：
								<c:if test="${empty page.endDate}">未定</c:if>
								<fmt:formatDate
										pattern="yyyy-MM-dd HH:mm" value="${page.endDate}"></fmt:formatDate></span>
							</p></td>
					</tr>
				</table>
			</div>
			<div class="row-fluid btm-line"></div>
		</c:forEach>
		<jsp:include page="/WEB-INF/views/_shared/pagination.jsp"></jsp:include>
	</div>
</div>