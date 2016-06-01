<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript">
	!function($) {
		$(function() {
			// carousel demo
			$('#myCarousel').carousel();
			// $('#myUniversity').carousel();
			// $('#myTeacher').carousel();
		});
	}(window.jQuery);
</script>
<style>
</style>

	<div id="myCarousel" class="carousel slide" style="z-index: 100;">
		  <div class="carousel-inner"  >
		    <div class="item active" style="" >
		    	<div style="width: 1120px; margin: 0 auto;">
		    		<img src="<c:url value='/resources/img/match/banner1.jpg'></c:url>">
		    	</div>
		    </div>
		    <div class="item " style="" >
		    	<div style="width: 1000px; margin: 0 auto;">
		    		<img src="<c:url value='/resources/img/match/banner2.jpg'></c:url>">
		    	</div>
		    </div>
		     <div class="item " style="" >
		    	<div style="width: 950px; margin: 0 auto;">
		    		<img src="<c:url value='/resources/img/match/banner3.jpg'></c:url>">
		    	</div>
		    </div>
		 
	  </div>
	</div> 
<!--	
<div class="row-fluid" style="margin: 0 auto; text-align: center;">
	<img src="<c:url value='/resources/img/match/banner.jpg'></c:url>">
</div>-->