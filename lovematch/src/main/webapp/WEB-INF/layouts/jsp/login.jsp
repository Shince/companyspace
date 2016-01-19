<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/layouts/jsp/common/_html_head.jsp"></jsp:include>
</head>
<style>



</style>
<body >
	<div >
		<div >
			<tiles:insertAttribute name="body" />
		</div>
		<footer>
			<tiles:insertAttribute name="footer" />
		</footer>
	</div>
</body>
</html>
