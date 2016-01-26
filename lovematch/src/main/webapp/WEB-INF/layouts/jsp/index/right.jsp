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
		<div class="row-fluid span12 bg_white" style="padding: 5px 10px ;">
		<c:forEach items="${unstartCompetitions}" var="unstartMatch">
			<div class="row-fluid " style=" text-align: left;margin: 5px 0px;margin-bottom: 15px;border-bottom: 1px dotted #ccc; ">
			<a href="<c:url value='/competitions/view/${usstartMatch.id }'></c:url>">${unstartMatch.title}</a>
			</div>
		</c:forEach>
		
		<a href="#" class="round lefttop-btn">正在报名</a>
		</div>
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


