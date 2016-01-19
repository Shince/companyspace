<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row-fluid max-width">
	<img class="pull-left" src="<c:url value='/resources/img/match/logo.jpg'></c:url>" >
	<div class="pull-right">
	<br>
	<div class="input-append" style="margin-top: 4px;">
	  <input class="span8" id="appendedInputButton" type="text">
	  <button class="btn" type="button">Go!</button>
	</div>
	<span  style="display: inline-block; "><a href="<c:url value='/loginpage'></c:url>">登录</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href>注册</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href>联系我们</a></span>
	</div>
</div>


			