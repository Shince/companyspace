<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript">
$(document).ready(function() {
	$('.deleteContPostBtn').on('click', function() {
		var cont_id = $(this).next().val();
		$('#deleteContPostModal #contId').val(cont_id);	
	});
});

</script>
<style>
.mybtn{
margin-bottom: 10px;
}
.mysplit{
	margin-left: 5px;
}
</style>


<div class="row-fluid custom round">
	<div  class="row" >
		<h4>科研成果</h4>
	</div>
	<div class="content">
		<div style="text-align: right;">
			<a href='<c:url value="/admin/cont/gjxm/list"></c:url>' class="btn btn-primary pull-left mybtn">
				国家项目</a>
			<a href='<c:url value="/admin/cont/sjxm/list"></c:url>'  class="btn btn-primary pull-left mybtn mysplit">
				省级项目</a>
			<a href='<c:url value="/admin/cont/sjxm/list"></c:url>' class="btn btn-primary pull-left mybtn mysplit">
				市级项目</a>
			<a href='<c:url value="/admin/cont/wtxm/list"></c:url>' class="btn btn-primary pull-left mybtn mysplit">
				委托项目</a>

			<a href='<c:url value="/admin/cont/add"></c:url>' class="btn btn-primary pull-right mybtn">
				添加内容</a><br>
			<table class="table table-bordered table-hover"  cellpadding="5" width=100%  border=0>
				<thead><tr>
						<th >图片</th>
						<th >标题</th>
						<th   width="150">发布时间</th>
						<th   width="115">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.content}" var="page">
						<tr>
						<td align="center" ><img src="<c:url value='${page.photo_path}'></c:url>" style="width: 140px; border: 1px #ccc dashed ;"></td>
							<td >${page.title}</td>
							
							<td ><fmt:formatDate value="${page.date}" pattern="yyyy-MM-dd hh:mm" /></td>
							<td >
								 <a class="deleteContPostBtn btn btn-info" href="#deleteContPostModal" role="button" data-toggle="modal" data-target="#deleteContPostModal">删除</a><input type="hidden" value="${page.id} ">   
								 <a class="btn btn-info" href='<c:url value="/admin/cont/edit/${page.id}"></c:url>'>修改</a>	
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="content"><jsp:include page="/WEB-INF/views/_shared/pagination.jsp"></jsp:include></div>
		</div>
	</div>	
</div>

<!-- delete annoForm -->
<div class="modal hide fade" id="deleteContPostModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    <h3 id="myModalLabel">请注意</h3>
	  </div>
	  <div class="modal-body">
	    <p>你确定删除该内容吗？</p>
	  </div>
	  <div class="modal-footer">
	    <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
	    <form action='<c:url value="/admin/cont/destory"></c:url>' method="post" style="display: inline-block;" >
	    	<input id="contId" type="hidden" name="cont_id" />
	    	<button class="btn btn-success">确定</button>
	    </form>
	  </div>
</div>