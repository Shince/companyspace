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
		<center><h4>${competition.title }</h4></center>
		<span class="content-date">发布时间:${competition.postDate}</span>
		<hr>
		<center><img src="<c:url value='${competition.picPath }'></c:url>" ></center>
		<br>
		${competition.description }
		<br>
		官方网址：<a href="<c:url value='${competition.officialWebsite }'></c:url>"><b>点击进入</b></a><br>
		报名地址：<a href="<c:url value='${competition.enrollLinke }'></c:url>"><b>点击进入</b></a><br>
	</div>
	<hr>
	<div class="row-fluid">
		<h5>相关产品</h5>
		<c:forEach items="${products}" var="product">
			<div class="product-div">
				<a href="<c:url value='/product/view/${product.id }'></c:url>"><img src="<c:url value='${product.photo_url }'></c:url>" style="width:95%;"></a><br>
				${product.name }
			</div>
		</c:forEach>
	</div>
</div>


