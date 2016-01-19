<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style>

</style>

<div class="row-fluid span12 boxshadow " style="margin: 30px 0px;">
	<div class="row-fluid span12 lefttop-div">
		<img style="width: 80%; margin-bottom: 20px;" src="<c:url value='/resources/img/match/111.jpg'></c:url>">
		<a href="#" class="round lefttop-btn">我要认领</a>
	</div>
	
	<div class="row-fluid ">
		<div class="row-fluid" >&nbsp;&nbsp;<span style="color:#ff6920; ">信息分享</span></div>
		<c:forEach items="${sharingInfo}" var="sharingInfo">
			<div class="row-fluid " style=" text-align: center; margin: 10px 0px; ">
			<img style="width: 90%; border: 1px dotted #ccc;" src="<c:url value='${sharingInfo.picPath}'></c:url>"><br>
			${sharingInfo.title}
			</div>
		</c:forEach>
		
	</div>
</div>


