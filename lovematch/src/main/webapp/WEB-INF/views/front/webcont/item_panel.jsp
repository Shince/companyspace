<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<style>



</style>

<div class="left_menu_container">
	<div class="nav-title">
		<span class="">科研项目</span>
	</div>
	<ul  class="nav  nav-stacked" >
		<li><a href="<c:url value='/cont/gjxm/list'></c:url>" >国家项目</a></li>
		<li><a href="<c:url value='/cont/sjxm/list'></c:url>" >省级项目</a></li>
		<li><a href="<c:url value='/cont//shijxm'></c:url>" >市级项目</a></li>
		<li><a href="<c:url value='/cont/zlsq/list'></c:url>" >委托项目</a></li>
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