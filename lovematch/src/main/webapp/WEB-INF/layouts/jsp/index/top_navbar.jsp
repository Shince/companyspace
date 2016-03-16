<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row-fluid max-width">
	<img class="pull-left"
		src="<c:url value='/resources/img/match/logo.jpg'></c:url>">
	<!--  
	<div class="pull-right">
		<br>
		<span style="display: inline-block;margin-top: 15%;"><a
			href="<c:url value='/loginpage'></c:url>">登录</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a
			href="#">联系我们</a></span>
	</div>
	-->
	<div class="pull-right col-lg-6">
		<form action="<c:url value='/competitions/search'></c:url>"
			enctype="multipart/form-data" method="post">
			<div class="input-group" style="margin-top: 10%;">
				<input type="text" name="searchFor" class="form-control"
					placeholder="赛事搜索..."> <span class="input-group-btn">
					<button class="btn btn-default" type="submit"
						style="margin-top: -10px;">站内搜索</button>
				</span>
			</div>
		</form>
	</div>
</div>


