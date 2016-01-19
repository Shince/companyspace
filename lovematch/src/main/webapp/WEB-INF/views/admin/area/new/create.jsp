<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style>

</style>
<div class="row-fluid custom round">
	<div  class="row">
		<h4>研究领域>>添加内容</h4>
	</div>
	<div class="content">
		<form action= "<c:url value='/admin/area/new'></c:url>"  method="post" name="news_post" id="news_new_form"  >
		
			<div class="control-group" id="title">
				<label class="control-label" for="title"><strong> 标题</strong></label>
				<div class="controls">
					<input type="text" name="title" placeholder="标题"> <span class="help-inline"></span>
				</div>
			</div>
			<div class="control-group" id="type">				
				<div class="controls">
					<select name="type">
						<option value="cgzr" selected="selected">成果转让</option>
						<option value="jszy">技术转移</option>
						<option value="zlsq">专利授权</option>
						<option value="zlzx">专利咨询</option>
					</select>
				</div>
			</div>
			<div class="control-group" id="content">
				<div class="controls">
					<textarea  style="width:80%;height:280px;"  name="content"  ></textarea>
					<span class="help-inline"></span>
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
				return checkEmptyAjax("news_new_form","<c:url value='/admin/news/newsInfoAJAX'></c:url>");
			});
			prettyPrint();
	    });
</script>