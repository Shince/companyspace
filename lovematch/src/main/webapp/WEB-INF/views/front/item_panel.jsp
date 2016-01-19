<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<style>



</style>
<div class="left_menu_container round">
	<div>
	 <img src="<c:url value='/resources/img/item_top.png'></c:url>" />
	</div>
	<ul  class="nav  nav-stacked" >
		<li><a href="<c:url value='/'></c:url>" >网站首页</a></li>
		<li><a href="<c:url value='/about'></c:url>"  >关于我们</a></li>
		<li><a href="<c:url value='/biz/news'></c:url>">新闻中心</a></li>
		<li><a href="<c:url value='/biz/jwpx'></c:url>" >境外培训</a></li>
		<li><a href="<c:url value='/biz/zlyj'></c:url>" >智力引进</a></li>
		<li><a href="<c:url value='/biz/hzxm'></c:url>"  >合作项目</a></li>
		<li><a href="<c:url value='/biz/jsyj'></c:url>"  >技术引进</a></li>
		<li><a href="<c:url value='/biz/jszy'></c:url>"  >技术转移</a></li>
		<li><a href="<c:url value='/biz/jrfw'></c:url>" >金融服务</a></li>
		<li><a href="<c:url value='/biz/lyqz'></c:url>" >签证业务</a></li>
		<li><a href="<c:url value='/biz/scenic'></c:url>" >旅游景点</a></li>
		<li><a href="<c:url value='/contact'></c:url>"  >联系我们</a></li>	
	</ul>
	<div>
	 <img src="<c:url value='/resources/img/item_btm.png'></c:url>" />
	</div>
</div>
<script type="text/javascript">
$(document).ready(function() {
	$('ul > li > a').each(function(index){
		if ($(this).attr('href') == (window.location.pathname+window.location.search) ||$(this).attr('href') == (window.location.pathname) ) {
			$(this).parent().addClass('active');
		}
	});
});
</script>