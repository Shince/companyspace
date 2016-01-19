<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.navbars {
	margin: 0 auto;
	height: 50px;line-height: 50px;
}


.navbars_right {
	 color:#fff;text-align:left;
	font-size: 15px;text-align: center;
}

.navbars_right a {
	text-decoration: none;color:#fff;
	padding: 14px 30px;
}

.navbars_right a:hover {
	background-color:#ff6920;
	padding: 14px 30px;
}

.nav_active {
background-color:#ff6920;
	padding: 18px 30px;
}
</style>
<div class="row-fluid">

</div>
<div class="row-fluid navbars max-width">
	<div class="navbars_right pull-left">
		<a class="nav_active"  href="<c:url value='/competitions/asc/list'></c:url>">网站首页</a> 
		<a href="<c:url value='/competitions/asc/list'></c:url>">公路竞赛</a>
		<a href="<c:url value='#'></c:url>">自行车竞赛</a>
		<a href="<c:url value='#'></c:url>">其他竞赛</a>    
		<a href="<c:url value='/sharinginfo/list'></c:url>">信息分享</a> 
		
	</div>
</div>
<script type="text/javascript">
$(document).ready(function() {
	$('.navbars_right > a').each(function(index){
		if ($(this).attr('href') == (window.location.pathname+window.location.search) ||$(this).attr('href') == (window.location.pathname) ) {
			$(this).parent().addClass('active');
		}
	});
});
</script>