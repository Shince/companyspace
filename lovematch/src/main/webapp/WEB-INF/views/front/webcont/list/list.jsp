<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>


	
.mytab{
	border: 1px solid #ccc; 
	margin:10px 0px 10px 0px;
}


</style>
<div class="row-fluid " >
	<div  class="bg_white boxshadow sec_container" style="">
		<div class="sec_titles">
			<div class="sec_titles_sub ">
				${webInfoType }
			</div>
		</div>
		<div class="sec_cont ">
			<c:forEach items="${page.content }" var="page">
				<table width="100%" class="mytab table" cellspacing="0" cellpadding="5">
					<tbody>
					  <tr>
					    <td  class="news_title">
					   			<div class="news_title_limit wordbreak"><a style="color: #2a60a0;"  href="<c:url value="/cont/${type }/view/${page.id }"></c:url>"><b>${page.title }</b></a></div>  时间: <fmt:formatDate value="${page.date}" pattern="yyyy-MM-dd"/>
					    </td>
					  </tr>
					  <tr>
						<td valign="top" align="left"><div class="news_limit wordbreak simpleConts">${page.content}</div></td>
					  </tr>
					</tbody>
				</table>
			</c:forEach>
			<jsp:include page="/WEB-INF/views/_shared/pagination.jsp"></jsp:include>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		$(".simpleConts").each(function(i){
			var str = $(this).html();
			 str = str.replace(/<\/?[^>]*>/g,''); //去除HTML tag
	         str = str.replace(/[ | ]*\n/g,'\n'); //去除行尾空白
	         str = str.replace(/\n[\s| | ]*\r/g,'\n'); //去除多余空行
	         str=str.replace(/&nbsp;/ig,'');//去掉&nbsp;
	         $(this).html(str);
	          
		});
	});
</script>