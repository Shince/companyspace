<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/layouts/jsp/common/_html_head.jsp"></jsp:include>
	<style type="text/css" media="screen">
		@import url("<c:url value="/resources/css/admin-layout.css"/>");
		.bg_white{
			background-color: #ffffff;
			
		}
		.border-green-all{
			border: 1px solid #ccc;
		}
		.border-green-right{
			 border-right:1px solid #9db84d;
		}
	</style>
</head>
<body class="admin">
	<tiles:insertAttribute name="top-navbar" />
	<!-- /top-navbar -->
	<div class="container-fluid ">
		<div class="container-fluid">
		<div class="row-fluid  bg_white" >
			<div class="row-fluid">
				<tiles:insertAttribute name="banner" />
			</div>
			<!--/row-->
			<tiles:insertAttribute name="breadcrumbs" />
			<div style="padding: 0px 10px;">
			<div class="row-fluid content-panel ">
				<div class="span2 round" >
					<div class="left-panel">
						<tiles:insertAttribute name="left" />
					</div>
				</div>
				<!--/span-->
				<div class="span10 border-green-all round"  >
					<div class="right-panel">
						<tiles:insertAttribute name="flash" />
						<tiles:insertAttribute name="right" />
					</div>
				</div>

			</div>
			</div>
			<br>
			<footer><tiles:insertAttribute name="footer" /></footer>
		</div>
		
		</div>
	
	</div>
</body>
</html>
