<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/layouts/jsp/common/_html_head.jsp"></jsp:include>
</head>
<style>
	.bg_white{	background-color: #fff;}
	.round{border-radius:8px;}
	ul{list-style-type: none;}
	.max-width{width: 1200px;margin: 0 auto;}
	.navbg{
		background-image: url("<c:url value='/resources/img/nmg/headerbg.jpg'></c:url>");
	 	background-position: left top; background-repeat: repeat-x;
	}
	.footer{background-color:  #0f3c63;color: #fff;}
	.banner-top-line{
		background-image: url("<c:url value='/resources/img/nmg/banner_top_linebg.png'></c:url>");
	 	background-position: left top; background-repeat: repeat-x;height: 15px;}
	.banner-btm-line{
		background-image: url("<c:url value='/resources/img/nmg/banner_btm_linebg.png'></c:url>");
	 	background-position: left top; background-repeat: repeat-x;height: 15px;}
	.bg-f8{
		background-color: #f8f8f8;
	}
</style>
<body >
	<div >
		<div class="row-fluid ">
			<div >
			<tiles:insertAttribute name="top_navibar" />
			</div>
		</div>
		<div class="row-fluid " >
			<div  class="navbg">
				<tiles:insertAttribute name="navibar" />
			</div>
		</div>
		<div class="row-fluid banner-top-line"></div>
		<div class="row-fluid" >
			<div style=" margin: 0 auto;">
				<tiles:insertAttribute name="solide" />
			</div>
		</div>
		<div class="row-fluid banner-btm-line"></div>
			
		<div class=" max-width row-fluid" >
			<div  style="float: left;width: 20%; ">
				<tiles:insertAttribute name="left" />
			</div>
			
			<div    style="float: left;width: 80%;">
				<tiles:insertAttribute name="right" />
			</div>
		</div>
		
		<footer class="row-fluid footer">
		 <div  class="max-width">
			<tiles:insertAttribute name="footer" />
		 </div>
		</footer>
	</div>
</body>
</html>
