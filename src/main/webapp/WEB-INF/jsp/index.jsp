<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" />

    </head>
    <body>

        <h3>${welcomecustomer}</h3>

        <div class="loginForm">
            <form action="dologin" method="POST" >
                <h2>Login</h2>
              
                <input type="text" name="username" maxlength="30">
                <br>
                <p style="color: red; font-size: x-small; margin: 2px 10px; " ><strong>${wrongusername}</strong></p>

                 <br>
                <input type="password" name="password" placeholder="Password" maxlength="30">
                <br>
                <p style="color: red; font-size: x-small; margin: 2px 10px; " ><strong>${wrongpassword}</strong></p>
                <br>
                <br>
                <a href="dologin"><input type="submit" value="Login"></a>
                <p><strong>${login_required}</strong></p>


                <br>
                <br>

                <div style="padding-left:40px">
                    <a href="preregister">Not a member? Click to Register</a></div>
            </form>

        </div>

    </body>
</html>