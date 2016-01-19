<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style>

body{
	background-image: url(<c:url value='/resources/img/admin_bg.jpg' ></c:url>) ;
	background-position: left top; background-repeat: repeat-x;
}

 .row.bg {
	margin: 0px auto;
	height: 600px;
	background: url(<c:url value='/resources/img/login_bg.gif' ></c:url>) center repeat;
}

.span9.left {
	width: 100%;
	text-align: left;
	margin-top: -20px;
}

.span9.right {
	width: 55%;
	margin-top: -5px;
}

.span4.login-panel {
	height: 60%;width: 305px;
	margin: 60px -50px auto;
	text-align: center;background-image: url('<c:url value="/resources/img/login_panel_bg.png"></c:url>');
	background-position: left top;background-repeat: repeat;"
}


.login-context {
	width: 80%;
	height: 100%;
	margin:0 auto;
}

.login-logo {
	height: 80px;
	margin:5px auto;
	text-align: center;
}

.form-horizontal {
	margin: 0 auto;
}

.form-horizontal .controls {
	margin-left: 0px;
}

.form-horizontal-register {
	margin: 0 auto;
}
.hr-bg {
	height: 5px;
	background: url(<c:url value='/resources/img/hr.png' ></c:url>) center no-repeat;
}

.radio.inline{
	width: 20%;
}
.help-inline{
	margin-top: -5px;
}
.help-inline-third{
	margin-left:100px;
	margin-top: -15px;
}
.title-index{
	color:#fff;
	text-align: left;
}

</style>
<script type="text/javascript" charset="utf-8" src="<c:url value="/resources/js/loginCheck.js"/>"></script>
<script type="text/javascript">
	function checkEmailAndPwd(){
		return checkEmailAndPass("sigin_info_form",'<c:url value="/checkEmailAndPassword"></c:url>');
	}
	$(document).ready(function() { 
		var thirdPartyName=$("#thirdPartyName").val();
		if(thirdPartyName!=""){
			$('#myModal').modal('show');
		}
	}); 
</script>

<div class="row bg">
	<div class="span8 left"></div>
	<div class="span4 login-panel round" >
		<div class="login-context" >
			<form:form class="form-horizontal" action="signin" id="sigin_info_form" modelAttribute="loginForm" method="post">
				<h4 class="title-index" style="color: #fff;">用户登录</h4>
				<div class="hr-bg"></div>
				<div class="controls" id="name" style="margin-top: 20px;">
					<h5 style="text-align: left;" class="title-index"></h5>
					<div class="controls" style="text-align: right;">
						<input type="text" id="em" name="name" placeholder="用户名" style="width: 230px;">
						<span class="help-inline"></span>
					</div>
				</div>
				<div class="controls" id="password" style="margin-top: -10px;">
					<h5 style="text-align: left; color: #fff;" class="title-index">登录密码</h5>
					<div class="controls" style="text-align: right;">
						<input type="password" id="ps" name="password" placeholder="请输入您的密码" style="width: 230px;">
						<span class="help-inline"  id="passwordErr"><form:errors path="psw"></form:errors></span>
					</div>
				</div>
				<button class="btn btn-large btn-block btn-primary" type="submit" onclick="return checkEmailAndPwd();" style="font-family: 'Microsoft YaHei'; margin-top: 40px;">登录</button>
			</form:form>
				<div class="hr-bg"></div>
	
		</div>
	</div>
	

</div>

