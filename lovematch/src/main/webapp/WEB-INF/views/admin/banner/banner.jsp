<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
	<script type="text/javascript"  src="<c:url value="/resources/js/date/WdatePicker.js" />" ></script>
 	 <script type="text/javascript" src="<c:url value='/resources/js/loginCheck.js'></c:url>"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/emptyCheck-ajax.js'></c:url>"></script>
    <script type="text/javascript" charset="utf-8" src="<c:url value="/resources/kindeditor-4.1.3/kindeditor.js" />"></script>
	<script type="text/javascript" charset="utf-8" src="<c:url value="/resources/kindeditor-4.1.3/lang/zh_CN.js" />"></script>
<style>
.row-fluid.custom {
	margin-bottom: 20px;
	padding: 0px 0px 10px;
	
}
.row-fluid .custom .row {
	margin: 10px 40px;
	color: #0c53af;
	border-bottom: solid #cccccc 1.5px;
}
.row-fluid.custom .content {
	margin: 20px 40px;
}
.admin_banner{
	background-image: url("<c:url value='/resources/img/admin/admin_topbg.jpg'></c:url>");
	background-repeat: repeat-x; background-position: left top;height: 70px;
	
}
</style>


<div class="admin_banner">
<img alt="" src="<c:url value='/resources/img/admin/header_left.jpg'></c:url>" style="float: left;">
<img alt="" src="<c:url value='/resources/img/admin/header_right.jpg'></c:url>" style="float: right;">
</div>

