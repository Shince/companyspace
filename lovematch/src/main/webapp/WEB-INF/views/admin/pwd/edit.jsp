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
		<h4>修改密码</h4>
	</div>
	<div class="content">
		<form class="form-horizontal" action="<c:url value='/admin/changepsw/edit/edit'></c:url>" method="post" id="chanePsw_info_form">
		    <div id="message" style="margin-left: 155px;"><h5 style="color: #adcc75">${message}</h5></div>
				<div class="control-group" id="ori_psw">
					<label class="control-label" for="ori_psw">当前密码</label>
					<div class="controls">
						<input type="password"  id="oriPsw" name="ori_psw" placeholder="请输入您的当前密码" >
						<span class="help-inline" id="oriError"></span>
					</div>
				</div>
				<div class="control-group" id="new_psw">
					<label class="control-label" for="new_psw">新密码</label>
					<div class="controls">
						<input type="password" id="alter_new_psw" name="new_psw" placeholder="请输入您的新密码">
					    <span class="help-inline" id="newPsw"></span>
					</div>
				</div>
				<div class="control-group" id="confirm_new_psw">
					<label class="control-label" for="confirm_new_psw">确认密码</label>
					<div class="controls">
						<input type="password" id="alter_confirm_new_psw" name="confirm_new_psw" placeholder="再次输入一遍您的新密码">
						<span class="help-inline" id="errorPs"></span>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<button type="submit" onclick="return changPwdOnclick();"  class="btn  btn-info">修改密码</button>
					</div>
				</div>
			</form>
	</div>
</div>

<script type="text/javascript">

 function changPwdOnclick(){
	return modifyPwd("chanePsw_info_form","<c:url value='/admin/pswInfoAJAX'></c:url>");
}; 
$(document).ready(function(){
	$("#alter_confirm_new_psw").focus(function(){
		$("#errorPs").html("");
	});
	$("#alter_new_psw").focus(function(){
		$("#newPsw").html();
	});
	$("#oriPsw").focus(function(){
		$("#oriError").html("");
	});
});
</script>
