<%@ page trimDirectiveWhitespaces="true" pageEncoding="utf-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>中台系统</title>
		<link rel="stylesheet" type="text/css" href="${commonResourcePath}/css/loginpage.css"/>
	</head>
	<body>
		<div class="omsbox">
			<div class="landbox">
				<div class="logo">
					<img src="${commonResourcePath}/images/logo.png"/>
					<p>系统登陆</p>
				</div>
				<div class="account">
					<form:form class="form-horizontal" id="login_form" action="${contextPath}/j_spring_security_check" method="post">
						<label><span>账号</span><input type="text" name="j_username" autofocus="autofocus"/></label>
						<label><span>密码</span><input type="password" name="j_password"/></label>
					</form:form>
					<p class="omstis">
						<c:if test="${!empty accInfoMsgs}">
						     <c:forEach items="${accInfoMsgs}" var="msg">
						       <span><spring:theme code="${msg.code}" arguments="${msg.attributes}"/></span>
						     </c:forEach>
						</c:if>
						<c:if test="${!empty accErrorMsgs}">
							<c:forEach items="${accErrorMsgs}" var="msg">
							    <span style="color:red;"><spring:theme code="${msg.code}" arguments="${msg.attributes}"/></span>
							</c:forEach>
						</c:if>
						<c:if test="${empty accErrorMsgs && empty accInfoMsgs}">
							<span>请输入您的用户名和密码.</span>
						</c:if>
					</p>
					<p class="omsbtn">登陆</p>
					<p class="omssug">*建议您使用Chrome(谷歌)浏览器访问本系统*</p>
				</div>
				<p class="register"><span class="modifybtn">修改密码？</span></p>
				<div class="modify">
					<div class="logo">
						<img src="${commonResourcePath}/images/logo.png"/>
							<p>修改密码</p>
					</div>
					<div class="account1">
						<form:form id="update_form" action="${encodedContextPath}/updatePass" method="post">
							<label><span>用户名</span><input type="text" name="userId"/></label>
							<label><span>原密码</span><input type="password" name="password_old"/></label>
							<label><span>新密码</span><input type="password" name="password_new"/></label>
							<label><span>确认密码</span><input type="password" name="password_new2"/></label>
						</form:form>
						<p>
							 <span style="color:red;" id="errerMes"></span>
						</p>
						<a class="back" href="JavaScript:void(0)">返回登陆</a><span class="modbtn">修改</span>
					</div>
			</div>
		</div>
		<script src="${commonResourcePath}/js/jquery-3.2.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			$(function(){
			    $(document).keydown(function(e){
			        if(e && e.keyCode==13){
                        $(".omsbtn").click();
                    }
				});
				$(".modifybtn").click(function(){
					$(".modify").show();
				})
				$(".back").click(function(){
					$(".modify").hide();
				})
				$(".omsbtn").click(function(){
					$("#login_form").submit();
				});
				$(".modbtn").click(function(){
					if($("input[name='userId']").val()){
						if($("input[name='password_old']").val()){
							if($("input[name='password_new']").val()){
								if($("input[name='password_new2']").val()){
									if($("input[name='password_new']").val()==$("input[name='password_new2']").val()){
										$("#errerMes").html("");
										$("#update_form").submit();
									}else{
										$("#errerMes").html("两次密码输入不一致");
									}
								}else{
									$("#errerMes").html("请输入确认密码");
								}
							}else{
								$("#errerMes").html("请输入新密码");
							}
						}else{
							$("#errerMes").html("请输入原密码");
						}
					}else{
						$("#errerMes").html("请输入用户名");
					}
				});
			});
		</script>
	</body>

</html>
