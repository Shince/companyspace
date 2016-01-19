<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<div class="left_menu_container">
	<div class="nav-title">
		<span >新闻中心</span>
	</div>
	<ul  class="nav  nav-stacked" >
		<li><a href="<c:url value='/news/zhxw/list'></c:url>" >综合新闻</a></li>
		<li><a href="<c:url value='/news/hyzx/list'></c:url>" >行业资讯</a></li>
		<li><a href="<c:url value='/news/yjdt/list'></c:url>" >科研动态</a></li>
		<li><a href="<c:url value='/news/advice/list'></c:url>" >通知公告</a></li>
		<!-- <li><a href="<c:url value='/biz/list'></c:url>" >学术活动</a></li> -->
	</ul>

</div>
<script type="text/javascript">
/*
$(document).ready(function() {
	$('ul > li > a').each(function(index){
		if ($(this).attr('href') == (window.location.pathname+window.location.search) ||$(this).attr('href') == (window.location.pathname) ) {
			$(this).parent().addClass('active');
		}
	});
});*/
var type ='${webInfoType}';
$(document).ready(function() {
	$('ul > li > a').each(function(index){
		/*if ($(this).attr('href') == (window.location.pathname+window.location.search) ||$(this).attr('href') == (window.location.pathname) ) {
			$(this).parent().addClass('menu_active');
		}*/
		var text = $(this).text();
		if(text == type){
			$(this).parent().addClass('menu_active');
		}
	});
});
</script>