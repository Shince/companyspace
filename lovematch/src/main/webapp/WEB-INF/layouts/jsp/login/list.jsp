<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style>	
ul{
	list-style-type: none;
}

h4{
	padding-bottom: 5px;
	color: #5196e2;
}
.cont{
	text-align: left;
}

</style>
<div class="row-fluid ">
<div class="sec_contents round">
	<div class="titles">
		<img src="<c:url value='/resources/img/icon_round.png'></c:url>"> 登录
	</div>
	
	<div class="cont" >
	<br>
		<div style="margin-left: 250px;">
			<form action="<c:url value='/signin'></c:url>" id="login_form"  method="post">
				<div class="control-group" id="email">	
					<div class="controls">
						邮箱：<input type="text" name="email" placeholder="邮箱" style="width: 300px;"><span class="help-inline"></span>
					</div>
				</div>
				<div class="control-group" id="password">
					
					<div class="controls">
						密码：<input type="password" name="password" placeholder="密码"  style="width: 300px;"><span class="help-inline"  id="passwordErr"></span>
					</div>
				</div>
				<div>
					<div class="control-group">
						<div class="controls " style="margin-left: 35px;">
							<button  type="submit"  class="btn btn-primary" onclick="return checkLoginEmailAndPwd();">登录</button>
							 <a style="margin-left: 10px;"  class="btn"  href="<c:url value='/register'></c:url>">注册</a>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	
</div>
</div>
<script type="text/javascript">
function checkLoginEmailAndPwd() {
	$form = $('#login_form');
	$form.bind('submit', function(e) {
		var $inputs = $form.find('input');
		var dataValues = collectFormData($inputs);
		$.post("<c:url value='/checkEmailAndPassword'></c:url>", dataValues, function(response) {
			$form.find('.modal-body').removeClass('error');
			$form.find('.help-inline').empty();
			$form.find('.alert').remove();
			if (response.status == 'FAIL') {
				for ( var i = 0; i < response.errorMessageList.length; i++) {
					var item = response.errorMessageList[i];
					var $controlGroup = $('#' + item.fieldName);
					$controlGroup.addClass('error');
					$controlGroup.find('.help-inline').html("<font color='#ff0000'>"+item.message+"</font>");
				}
			} else{
				$.ajax({
					  type: "post",
					  url: "<c:url value='checkLogin'></c:url>",
					  data:dataValues,
					  dataType:"text",
					  success:function(number){
						if(number == "0"){
							$("#passwordErr").html("<font color='#ff0000'>邮箱或密码错误</font>");
							return false;
						}else{
							$form.unbind('submit');
							$form.submit();
						}
					  }
					});
				
			}
		}, 'json');
		e.preventDefault();
		return false;

	});
}
</script>


