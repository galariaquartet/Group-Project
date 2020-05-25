<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>About us</title>
        <link href="https://fonts.googleapis.com/css?family=Muli:300,400,700,900" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    </head>

    <body>
     <nav class="headernav">
            <ul class="nav-links">
                <li><a href="#"> About us </a></li>
<!--                <li><a href="/chat"> chat </a></li>-->
                <li><a href="/preGame"> Game </a></li>
                <li><a href="/products"> Shop </a></li>
                <li><a href="/contact"> Contact </a></li>
                
<!--                            <sec:authorize access="hasAuthority('admin')">-->
<!--                               <li><a href="/adminMain"> admin </a></li>-->
<!--                    </sec:authorize>-->
         
                
<!--                <li><a href="/adminMain"> admin </a></li>-->
                <li><a href="/account"><img class="acount_icon" src="https://i.ibb.co/ydgtt5p/acount.png"></a></li>
                <li><a href="/shoppingCart"><img class="basket_icon" src="https://i.ibb.co/Fkr4Ddv/basket4.png"></a></li>
            </ul>
            <div class="burger" >
                <div class="line1"></div>
                <div class="line2"></div>
                <div class="line3"></div>
            </div>
        </nav>
          <div id="logo" class="mask">
                <span class="logo-text masked"><a href="index.html"> <img src="https://i.ibb.co/87qghMy/LOGO33.png"></a></span>
            </div> 
        <div id="abouts_us_countainer">
            <div class="about_text">
                <h1>About us</h1>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
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
        <script src="${pageContext.request.contextPath}/js/main.js"></script>
         <script src="${pageContext.request.contextPath}/js/burger.js"></script>
    </body>

</html>
