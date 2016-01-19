<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style>
.product{
	width: 150px; height: 150px; margin: 10px; float: left;
	text-align: center;
}
</style>
<script>

</script>
<div class="row-fluid custom round">
	<div  class="row">
		<h4>竞赛列表>>竞赛详情</h4>
	</div>
	<div class="content">
		<h4>${competition.title }</h4>
		发布时间：${competition.postDate}
		<hr>
		<center><img src="<c:url value='${competition.picPath}'></c:url>" ></center>
		${competition.description}
		<br>
		官方网址：<a href="${competition.officialWebsite }" target="_blank">${competition.officialWebsite }</a><br>
		报名链接：<a href="${competition.enrollLinke }" target="_blank">${competition.enrollLinke }</a>
		<h5>相关产品</h5>
		<a class="btn btn-info" href="<c:url value='/admin/product/add'></c:url>">添加</a>
		<c:forEach items="${products}" var="product">
			<div class="product">
				<img src="<c:url value='${product.photo_url}'></c:url>" ><br>
				${product.title }<br>
				<a href="<c:url value='/admin/product/edit/${product.id}'></c:url>">修改</a> | 
				<a href="<c:url value='/admin/competition/${competition.id }/product/destory/${product.id }'></c:url>">删除</a>
			</div>
		</c:forEach>
	</div>
	
</div>
