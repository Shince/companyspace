<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>

<div style="margin-top: 30%;">
	<button type="button" class="btn btn-lg btn-primary"
		style="padding: 60px 100px;"><c:if test="${empty user}">Word!</c:if>${user.name}!</button>
</div>


