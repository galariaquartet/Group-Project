<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account</title>
        <link href="https://fonts.googleapis.com/css?family=Muli:300,400,700,900" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <header id="header">
            <nav class="headernav">
                <ul class="nav-links">
                    <li><a href="/aboutUs"> About us </a></li>
                    <li><a href="#"> Game </a></li>
                    <li><a href="/products"> Shop </a></li>
                    <li><a href="/contact"> Contact </a></li>
                </ul>
                <ul class="nav-links">
                    <li><a href="#"><img class="acount_icon" src="https://i.ibb.co/ydgtt5p/acount.png"></a></li>
                    <li><a href="/shoppingCart"><img class="basket_icon" src="https://i.ibb.co/Fkr4Ddv/basket4.png"></a></li>
                </ul>
            </nav>
            <div id="logo" class="mask">
                <span class="logo-text masked"><a href="/home"> <img src="https://i.ibb.co/87qghMy/LOGO33.png"></a></span>
            </div> 
        </header>
        <div id="account_countainer">
            <div class="acount_title">
                <h1>My Account</h1>
                <p>Username</p>
            </div>
            <div class="account_all">
                <div class="account_left">
                    <div class="acount_categories">
                    </div>
                    <div id="profile">
                        <p >PROFILE</p>
                    </div>
                    <div id="orders" class="right-border">
                        <p>ORDER</p>
                    </div>
                    <div id="credit_card">
                        <p>CREDITS</p>
                    </div>
                </div>
                <div class="account_right">
                    <div id="customer_info_cont">
                        <h3>My Info</h3>
                        <p>Myname</p>
                        <p>Mylastname</p>
                        <p>Myemail</p>
                    </div>
                    <div id="orders_info_cont">
                        <h3 class="my_orders">My orders</h3>
                        <div class="orders">
                            <dir id="order" >
                                <p>Myname</p>
                                <p>Mylastname</p>
                                <p>Myemail</p>   
                            </dir>
                            <dir id="order">
                                <p>Myname</p>
                                <p>Mylastname</p>
                                <p>Myemail</p>   
                            </dir>
                        </div>
                    </div>
                    <div id="credits_info_cont">
                        <p>MyCard</p>
                        <p>MyNumberCard</p>
                        <p>MyCcv</p>

                    </div>
                </div>
            </div>
        </div>
        <div class="footer">
            <div class="footercontainer">
                <div class="social_footer">
                    <div class="follow_us">Follow us </div>
                    <div class="social_icon"><img src="https://i.ibb.co/1LbHv7c/facebook-icon.png"></div>
                    <div class="social_icon"><img src="https://i.ibb.co/37ymrym/instagram-icons.png"></div>
                    <div class="social_icon"><img src="https://i.ibb.co/P6dSF3w/white-github-icon-813505.png"></div>
                </div>
            </div>
        </div>
        <script src="${pageContext.request.contextPath}/js/acount.js"></script>
    </body>
</html>
