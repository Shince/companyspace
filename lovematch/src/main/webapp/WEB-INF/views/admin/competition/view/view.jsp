<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
.product {
	width: 150px;
	height: 150px;
	margin: 10px;
	float: left;
	text-align: center;
	border: 1px dotted #ccc;
	margin-left: 0px;
}
</style>
<script>
	
</script>
<div class="row-fluid custom round">
	<div class="row">
		<h4>竞赛列表>>竞赛详情</h4>
	</div>
	<div class="content">
		<h4 style="text-align: center;">${competition.title }</h4>
		<span class="content-date">发布时间:${competition.postDate}</span>
		<hr>
		<div style="text-align: center;">
			<img src="<c:url value='${competition.contextPicPath }'></c:url>">
		</div>
		<br> ${competition.description } <br> <br> 比赛时间：<b><fmt:formatDate
				pattern="yyyy-MM-dd HH:mm"
				value="${competition.competitionStartDate}"></fmt:formatDate></b><br>
		报名时间：<b><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
				value="${competition.startDate}"></fmt:formatDate> 至 <fmt:formatDate
				pattern="yyyy-MM-dd HH:mm" value="${competition.endDate}"></fmt:formatDate></b><br>
		<br> 比赛距离：<b><c:if
				test="${raceDistance.wholeMarathon eq 'wholeMarathon' }">全程马拉松&nbsp;&nbsp;&nbsp;</c:if>
			<c:if test="${raceDistance.halfMarathon eq 'halfMarathon' }">半程马拉松&nbsp;&nbsp;&nbsp;</c:if>
			<c:if test="${raceDistance.otherDistance eq 'otherDistance' }">
				<c:forEach items="${otherDistance }" var="otherDistance">
				${otherDistance}&nbsp;&nbsp;&nbsp;
			</c:forEach>
			</c:if></b> <br> 关门时间：<b><c:forEach items="${doorCloseList }"
				var="doorClose">
				${doorClose}&nbsp;&nbsp;&nbsp;
			</c:forEach></b> <br> <br> 官方网址：<a
			href="<c:url value='${competition.officialWebsite }'></c:url>"><b>点击进入</b></a><br>
		报名地址：<a href="<c:url value='${competition.enrollLinke }'></c:url>"><b>点击进入</b></a><br>
		<div class="row-fluid">
			<h5>相关产品</h5>
			<a class="btn btn-success pull-left"
				href="<c:url value='/admin/competition/${competition.id}/product/new'></c:url>">添加</a>

		</div>
		<div class="row-fluid">
			<c:forEach items="${products}" var="product">
				<div class="product">
					<img src="<c:url value='${product.photo_url}'></c:url>"
						style="height: 90px;"><br> ${product.name }<br> <a
						class="btn btn-info"
						href="<c:url value='/admin/competition/${competition.id }/product/edit/${product.id}'></c:url>">修改</a>
					<a class="btn btn-info"
						href="<c:url value='/admin/competition/${competition.id }/product/destory/${product.id }'></c:url>">删除</a>
				</div>
			</c:forEach>
		</div>
	</div>

</div>