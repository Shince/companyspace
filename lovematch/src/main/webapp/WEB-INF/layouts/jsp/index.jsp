<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/layouts/jsp/common/_html_head.jsp"></jsp:include>
</head>
<style>
	.btm-line{border-bottom: 1px dotted #ccc; height: 1px; margin: 8px 0px;}
	.bg_black{background-color: #000;}
	.bg_white{	background-color: #fff;}
	.round{border-radius:5px;}
	ul{list-style-type: none;}
	.max-width{width: 1024px;margin: 0 auto;}
	.navbg{
	 	background-position: left top; background-repeat: repeat-x;margin: 0 auto;
	}
	.footer{background-color:  #fff;}
	.top-navbar{background-color: #f1f1f1;height: 95px;}
</style>
<body>
	<div class="row-fluid top-navbar">
		<tiles:insertAttribute name="top_navibar" />	
	</div>
	<div class="row-fluid bg_black" >
		<div  class="navbg">
			<tiles:insertAttribute name="navibar" />
		</div>
	</div>

	<div class="row-fluid" >
		<tiles:insertAttribute name="solide" />
	</div>
	
	<div class="row-fluid " >
		<div  class="max-width">
			<div class=" span9" style="width: 70%; float: left;">
				<tiles:insertAttribute name="left" />
			</div>
			
			<div  class="span3" style="width: 25%;float: right;">
				<tiles:insertAttribute name="right" />
			</div>
		</div>
	</div>
	<footer class="row-fluid footer">
	 <div  class="max-width">
		<tiles:insertAttribute name="footer" />
	 </div>
	</footer>
</body>
</html>
