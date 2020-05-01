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
        
          <hr/>
        <a href="products">Products</a>
        <hr>
        <a href="customerInformation">Customer Information</a>
        <hr>
        <a href="category">Category</a>
        <hr>
        <hr>
        <a href="orderStatus">OrderStatus</a>
        <hr>
    </body>
</html>