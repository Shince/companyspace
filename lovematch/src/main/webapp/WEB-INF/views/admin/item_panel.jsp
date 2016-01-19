<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style>
.nav{
	padding: 5px 0px;
	background-color: #f1f4fb;
}
.nav > li>a:hover {
	background-image: url("");
}
</style>
	
	<ul class="admin nav-stackeds nav  round border-green-all">
		<li><a href='<c:url value="/admin/news/all/list"></c:url>' >网站新闻</a></li>
		<li><a href='<c:url value="/admin/competition/list"></c:url>' >竞赛列表</a></li>
		<li><a href='<c:url value="/admin/sharinginfo/list"></c:url>' >信息分享</a></li>
	</ul>
	<hr>
	<ul class="admin nav-stackeds nav  round border-green-all">	
		
		<li><a href='<c:url value="/admin/webinfo/contact/add"></c:url>' >联系我们</a></li>
	</ul>
	<hr>
	<ul class="admin nav-stackeds nav  round border-green-all">
		<li><a href='<c:url value="/admin/changepsw"></c:url>'   >修改密码</a></li>
		<li><a href='<c:url value="/"></c:url>'   target="_blank">网站前台</a></li>
		<li><a href='<c:url value="/signout"></c:url>'   >退出系统</a></li>
	</ul>
<script type="text/javascript">
$(document).ready(function() {
	$('ul > li > a').each(function(index){
		if ($(this).attr('href') == (window.location.pathname+window.location.search) ||$(this).attr('href') == (window.location.pathname) ) {
			$(this).parent().addClass('active');
		}
	});
});
</script>
