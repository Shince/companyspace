<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="<c:url value="/resources/jquery/emptyCheck-ajax.js" />"></script>
<script type="text/javascript">
$(document).ready(function() {	
	$('.deleteSupportPostBtn').on('click', function() {
		var activity_id = $(this).next().val();
		$('#deleteSupportPostModal #support_id').val(activity_id);	
	});
});

</script>
<style>

</style>


<div class="row-fluid custom round">
	<div  class="row" >
		<h4>支持单位</h4>
	</div>
	<div class="content">
		<div style="text-align: right;">
			<a href='<c:url value="/admin/support/create"></c:url>' style="margin-bottom: 10px; font-size: 14px;"class="btn">
				添加</a><br>
			<table  width=100%  >
				<tbody>
					<tr>
					<td style="text-align: center;">
						<c:forEach  items="${page.content}" var="page">
							<div style="float: left; margin: 10px 10px; padding:2px; border: 1px solid #ccc;">
								<img src="<c:url value='${page.logoPath}'></c:url>" style="width: 100px; ">
								<br>${page.name}<br>
								<a class="deleteSupportPostBtn" href="#deleteSupportPostModal" role="button" data-toggle="modal" data-target="#deleteSupportPostModal">删除</a><input type="hidden" value="${page.id} ">  | 
								<a href='<c:url value="/admin/support/edit/${page.id}"></c:url>'>修改</a>	
							</div>
						</c:forEach>
					</td>
					</tr>
				</tbody>
			</table>
			
		</div>
		<jsp:include page="/WEB-INF/views/_shared/pagination.jsp"></jsp:include>
	</div>	
</div>

<!-- delete activityForm -->
<div class="modal hide fade" id="deleteSupportPostModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    <h3 id="myModalLabel">请注意</h3>
	  </div>
	  <div class="modal-body">
	    <p>你确定删除该项吗？</p>
	  </div>
	  <div class="modal-footer">
	    <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
	    <form action='<c:url value="/admin/support/destory"></c:url>' method="post" style="display: inline-block;" >
	    	<input id="support_id" type="hidden" name="support_id" />
	    	<button class="btn btn-success">确定</button>
	    </form>
	  </div>
</div>