<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
           prefix="springForm"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Form</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/registration_style.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
    </head>

    <body>
        <div class="container">
            <div class="header">
                <h2>Create Account</h2>
            </div>
            <form:form  id="form" class="form" modelAttribute="registeruser" action='doregister' method="POST">
                <div class="form-control">
                    <label for="username">Username</label>
                    <form:input path="username" type="text" placeholder="e.g Bootcamp User" id="username" />
                    <i class="fas fa-check-circle"></i>
                    <i class="fas fa-exclamation-circle"></i>
                    <small>Error message</small>
                    <springForm:errors path="username" cssClass="error" />
                </div>
                <div class="form-control">
                    <label for="email">Email</label>
                    <form:input path="email" type="email" placeholder="e.g bestsite@gmail.com" id="email" />
                    <i class="fas fa-check-circle"></i>
                    <i class="fas fa-exclamation-circle"></i>
                    <small>Error message</small>
                    <td><springForm:errors path="email" cssClass="error" /></td>
                </div>
                <div class="form-control">
                    <label for="password">Password</label>
                    <form:input path="password" type="password" placeholder="Password" id="password"/>
                    <i class="fas fa-check-circle"></i>
                    <i class="fas fa-exclamation-circle"></i>
                    <springForm:errors path="password" cssClass="error" />
                    <small>Error message</small>
                </div>
                <div class="form-control">
                    <label for="password2">Confirm password</label>
                    <form:input path="password2" type="password" placeholder="Confirm password" id="password2"/>
                    <i class="fas fa-check-circle"></i>
                    <i class="fas fa-exclamation-circle"></i>
                    <springForm:errors path="password2" cssClass="error"/>
                    <small>Error message</small>
                </div>
                    <form:button id="submitbutton" disabled="true">Submit</form:button>
            </form:form >
        </div>
    </body>
    
    <script src="${pageContext.request.contextPath}/js/register.js"></script> 

</html>
