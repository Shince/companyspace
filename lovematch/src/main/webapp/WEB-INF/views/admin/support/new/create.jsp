<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="<c:url value="/resources/js/emptyCheck-ajax.js" />"></script>
<script>

</script>
<style>

</style>
<div class="row-fluid custom round">
	<div  class="row">
		<h4>支持单位>添加单位</h4>
	</div>
	<div class="content">
		<form action= "<c:url value='/admin/support/new'></c:url>" enctype="multipart/form-data"  method="post" name="support_post" id="support_new_form"  >
			<div class="control-group" id="name">
				<div class="controls">
					单位名称：<input type="text" name="name" placeholder="单位名称"> <span class="help-inline"></span>
				</div>
			</div>
			<div class="control-group" id="url">
				<div class="controls">
					单位链接：<input type="text" name="url" placeholder="单位链接"> <span class="help-inline"></span>
				</div>
			</div>
				<div class="control-group" >
					<div class="controls">
						图片：<input type="file" name="supportFile" /><span style="font-size: 13px; color: red;">${errorMsg }</span>
										<br><span style="color: red;  margin-left: 70px;">只支持jpg、gif、bmp、png格式，建议宽度90px，高度450px</span>
						<span class="help-inline"></span><br>
					</div>
				</div>
			<label style="clear: right;"></label>
			<button type="submit" class="btn btn-info">保存</button>&nbsp;&nbsp;
			<button type="reset" class="btn">取消</button>
		</form>
	</div>
</div>

<script type="text/javascript">
		$(document).ready(function() {
			$("#support_new_form").submit(function(){
				return checkEmptyAjax("support_new_form","<c:url value='/admin/support/createSupportAjax'></c:url>");
			});
	    });
</script>