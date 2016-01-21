<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="<c:url value="/resources/js/emptyCheck-ajax.js" />"></script>
<style>

</style>
<div class="row-fluid custom round">
	<div  class="row">
		<h4>相关产品</h4>
	</div>
	<div class="content">
		<form action= "<c:url value='/admin/product/add'></c:url>" enctype="multipart/form-data"  method="post" name="news_post" id="news_new_form"   >
			<input type="hidden" value="${competition_id }" name="competition_id" >
			<input type="hidden" value="${product.id }" name="id" >
			<div class="control-group" id="title">
				<div class="controls">
					产品名称：<input type="text"  required="required" name="name" placeholder="名称" value="${product.name}"> <span class="help-inline"></span>
				</div>
			</div>
						
			<div class="control-group" id="content">
				<div class="controls">
					<textarea  style="width:80%;height:280px;"  name="description"  placeholder="产品描述">${product.description }</textarea>
					<span class="help-inline"></span>
				</div>
			</div>
			<div class="control-group" >
				<div class="controls">
					图片：<input type="file" name="coverFile" /><span style="font-size: 13px; color: red;">${errorMsg }</span>
					<br><span class="text-error"><em>
						只支持jpg、gif、bmp、png格式，建议封面宽度500px，高度300px
					</em></span>
					<span class="help-inline"></span><br>
				</div>
			</div>
			<label style="clear: right;"></label>
			<button type="submit" class="btn btn-info">保存</button>&nbsp;&nbsp;
			<button type="reset" class="btn">取消</button>
		</form>
	</div>
</div>

<c:url var="uploadJson" value="/file_upload/${sessionUserInfo.id}"></c:url>
<c:url var="fileManagerJson" value="/file_manager/${sessionUserInfo.id}"></c:url>
<link rel="stylesheet" href="<c:url value="/resources/kindeditor-4.1.3/themes/default/default.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/kindeditor-4.1.3/plugins/code/prettify.css"/>" />
<script type="text/javascript" charset="utf-8" src="<c:url value="/resources/kindeditor-4.1.3/plugins/code/prettify.js"/>"></script>
<script type="text/javascript">
		$(document).ready(function() {
			var editor = KindEditor.create('textarea[name="description"]',{
				cssPath : '<c:url value="/resources/kindeditor-4.1.3/plugins/code/prettify.css"/>',
				uploadJson : '${uploadJson}',
				fileManagerJson : '${fileManagerJson}',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
				}
			});
			/*$("#news_new_form").submit(function(){
				editor.sync();
				return checkEmptyAjax("news_new_form","<c:url value='/admin/news/editNewsInfoAJAX'></c:url>");
			});*/
			prettyPrint();
			
		
			
	    });
</script>