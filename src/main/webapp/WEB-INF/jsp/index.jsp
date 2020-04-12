<%-- 
    Document   : index-jsp
    Created on : Apr 12, 2020, 10:06:46 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <form action="dologin" method="POST">
            Username: <input type="text" name = "username" placeholder="username"> <span style="color: red"><strong>${wrongusername}</strong></span>
            Password: <input type="password" name = "password" placeholder="password"> <span style="color: red"><strong>${wrongpassword}</strong></span>
            <input type="submit" value="Login">
        </form>
        <hr/>
        <a href="preregister">Not a member? Click to Register</a>
        <hr>
        <h3>${welcomecustomer}</h3>
    </body>
</html>