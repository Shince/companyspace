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
		<h4>新闻列表>>修改新闻</h4>
	</div>
	<div class="content">
		<form action= "<c:url value='/admin/news/edit/edit'></c:url>" enctype="multipart/form-data"  method="post" name="news_post" id="news_new_form"   >
			<input type="hidden" value="${news.id }" name="news_id" >
			<div class="control-group" id="title">
				<div class="controls">
					<input type="text" name="title" placeholder="标题" value="${news.title }"> <span class="help-inline"></span>
				</div>
			</div>
			<div class="control-group" id="type">				
				<div class="controls">
					<select name="type">
						<option value="zhxw">综合新闻</option>
						<option value="hyzx">行业资讯</option>
						<option value="yjdt">科研动态</option>
					</select>
				</div>
			</div>
			
			<div class="control-group" id="content">
				<div class="controls">
					<textarea  style="width:80%;height:280px;"  name="content"  placeholder="内容">${news.content }</textarea>
					<span class="help-inline"></span>
				</div>
			</div>
			<div class="control-group" >
				<div class="controls">
					图片：<input type="file" name="coverFile" /><span style="font-size: 13px; color: red;">${errorMsg }</span>
					<br><span class="text-error"><em>
									<c:if test="${bizType== 'news' }">
										只支持jpg、gif、bmp、png格式，建议封面宽度690px，高度380px
									</c:if>
									<c:if test="${bizType== 'scenic' }">
										只支持jpg、gif、bmp、png格式，建议封面宽度275px，高度165px
									</c:if>
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
			var editor = KindEditor.create('textarea[name="content"]',{
				cssPath : '<c:url value="/resources/kindeditor-4.1.3/plugins/code/prettify.css"/>',
				uploadJson : '${uploadJson}',
				fileManagerJson : '${fileManagerJson}',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
				}
			});
			$("#news_new_form").submit(function(){
				editor.sync();
				return checkEmptyAjax("news_new_form","<c:url value='/admin/news/editNewsInfoAJAX'></c:url>");
			});
			prettyPrint();
			
			var type = "${news.type}";
			$("select option[value="+type+" ]").attr("selected", true); 
			
	    });
</script>