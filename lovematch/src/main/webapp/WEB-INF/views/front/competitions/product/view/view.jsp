<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<style>
a[class='date-filter']:hover{color:#ff6920;border-bottom: 2px solid #ccc;padding-bottom: 5px;}
</style>

<div class="row-fluid   container_div">
	<div class="row-fluid date-div"> <a class="date-filter date-active" href="#">产品详情</a></div>
	<div class="row-fluid">
		<center><h4>${product.name }</h4></center>
		<hr>
		<center><img src="<c:url value='${product.photo_url }'></c:url>" ></center>
		<br>
		${product.description }
		<br>
	</div>
</div>


