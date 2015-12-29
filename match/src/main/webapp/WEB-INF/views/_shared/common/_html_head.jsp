<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
	<meta name="description" content="" />
	<meta name="author" content="" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title><tiles:getAsString name="title" /></title>
	<tiles:useAttribute name="css" id="css"/>
	<style type="text/css" media="screen">
		@import url("<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>");
		@import url("<c:url value="${css}"/>");
	</style>
	<script type="text/javascript" src="<c:url value="/resources/jquery/jquery-1.11.3.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/jquery/jquery-migrate-1.2.1.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/bootstrap/js/bootstrap3-typeahead.js" />"></script>