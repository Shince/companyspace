<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<style>
a[class='date-filter']:hover{color:#ff6920;border-bottom: 2px solid #ccc;padding-bottom: 5px;}
.product-div{float: left; padding: 10px; width: 150px; text-align: center; margin-right: 20px; margin-bottom: 20px; border: 1px dotted #ccc;}
</style>

<div class="row-fluid   container_div">
	<div class="row-fluid date-div"> <a class="date-filter date-active" href="#">竞赛详情</a></div>
	<div class="row-fluid">
		<h4 style="text-align:center;">${competition.title }</h4>
		<span class="content-date">发布时间:${competition.postDate}</span>
		<hr>
		<div style="text-align:center;"><img src="<c:url value='${competition.picPath }'></c:url>" ></div>
		<br>
		${competition.description }
		<br><br>
		比赛时间：<b><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${competition.competitionStartDate}"></fmt:formatDate></b><br>
		报名时间：<b><fmt:formatDate pattern="yyyy-MM-dd" value="${competition.startDate}"></fmt:formatDate> 至 <fmt:formatDate pattern="yyyy-MM-dd" value="${competition.endDate}"></fmt:formatDate></b><br><br>
		官方网址：<a href="<c:url value='${competition.officialWebsite }'></c:url>"><b>点击进入</b></a><br>
		报名地址：<a href="<c:url value='${competition.enrollLinke }'></c:url>"><b>点击进入</b></a><br>
	</div>
	<hr>
	<div class="row-fluid">
		<h5>相关产品</h5>
		<c:forEach items="${products}" var="product">
			<div class="product-div">
				<a href="<c:url value='/product/view/${product.id }'></c:url>"><img src="<c:url value='${product.photo_url }'></c:url>" style="width:95%;"></a><br>
				<a href="<c:url value='/product/view/${product.id }'></c:url>"><b>${product.name }</b></a>
			</div>
		</c:forEach>
	</div>
</div>


