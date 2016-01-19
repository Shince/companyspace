<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<style>
a[class='date-filter']:hover{color:#ff6920;border-bottom: 2px solid #ccc;padding-bottom: 5px;}
</style>

<div class="row-fluid   container_div">
	<div class="row-fluid date-div"> <a class="date-filter date-active" href="#">信息分享</a></div>
	<div class="row-fluid">
		<c:forEach items="${page.content}" var="page">
			<div class="competition-div">
				 <table style="width: 100%;">
				 	<tr>
				 	<td width="20%" align="left" valign="top"><a href="<c:url value='/sharinginfo/view/${page.id }'></c:url>"><img class="img-polaroid " style="height: 60px;" src="<c:url value='${page.picPath }'></c:url>" ></a></td>
				 	<td  width="25%" align="left" valign="top"><b>${page.title}</b></td>
				 	<td  width="25%" align="left" valign="top"> ${page.postDate }</td>
				 	<td  width="30%" align="left" valign="top"><a href="<c:url value='/sharinginfo/view/${page.id }'></c:url>">点击查看详情</a></td>
				 	</tr>
				 </table>
			</div>
			<div class="row-fluid btm-line"></div>
		</c:forEach>
		<jsp:include page="/WEB-INF/views/_shared/pagination.jsp"></jsp:include>
	</div>
</div>


