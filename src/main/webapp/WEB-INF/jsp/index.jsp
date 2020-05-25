<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Welcome</title>
        <link href="https://fonts.googleapis.com/css?family=Muli:300,400,700,900" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    </head>
    <body>
        <header id="header">
            <div id="logo" class="mask">
                <span class="logo-text masked"><a href="#"><img src="https://i.ibb.co/87qghMy/LOGO33.png"></a></span>
            </div> 
        </header>
        <div class="space"></div>
        <div class="login_container">
            <h3>${welcomecustomer}</h3>
            <div class="loginForm form-control">
                <div class="header">
                    <h2>Login</h2>
                </div>
                <form action="${pageContext.request.contextPath}/dologin" method="POST" >
                    <label for="username">Username</label>
                    <input type="text" name="username" maxlength="30">
                    <br>
                    <div style="height: 0.5rem"><p style="color: red; font-size: x-small; margin: 2px 10px; " ><strong>${wrongusername}</strong></p></div>
                    <br>
                    <label for="password">Password</label>
                    <input type="password" name="password" maxlength="30">
                    <br>
                    <div style="height: 0.5rem"><p style="color: red; font-size: x-small; margin: 2px 10px; " ><span>${wrongpassword}</span></p></div>
                    <br>
                    
                    <a href="dologin"><input type="submit" value="Login"></a>
                    <div style="height: 0.5rem"><p><strong>${login_required}</strong></p></div>
                    
                 
                    <div style="text-align:center;">
                        <a  href="preregister">Not a member? Click to Register</a></div>
                </form>
            </div>
        </div>
 <div class="footer">
            <div class="footercontainer">
                <div class="social_footer">

                    <div class="follow_us">Follow us </div>
                    <div class="socials_div">
                    <div class="social_icon"><img src="https://i.ibb.co/1LbHv7c/facebook-icon.png"></div>
                    <div class="social_icon"><img src="https://i.ibb.co/37ymrym/instagram-icons.png"></div>
                    <div class="social_icon"><img src="https://i.ibb.co/P6dSF3w/white-github-icon-813505.png"></div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>