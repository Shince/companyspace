<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/views/_shared/common/_html_head.jsp"></jsp:include>
</head>
<body>
	<tiles:insertAttribute name="top-navbar" />
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<tiles:insertAttribute name="index-body-left" />
			</div>
			<div class="col-md-6">
				<tiles:insertAttribute name="index-body-right" />
			</div>
		</div>
	</div>

</body>
</html>
