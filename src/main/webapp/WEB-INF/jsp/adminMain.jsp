<%-- 
    Document   : adminMain
    Created on : May 23, 2020, 2:08:16 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Admin Main</title>
        <link href="https://fonts.googleapis.com/css?family=Muli:300,400,700,900" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminMain.css">
    </head>

    <body>

        <nav class="headernav">
            <ul class="nav-links">
                <li><a href="/aboutUs"> About us </a></li>
                <li><a href="/chat"> Game </a></li>
                <li><a href="/products"> Shop </a></li>
                <li><a href="/contact"> Contact </a></li>
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
            <span class="logo-text masked"><a href="/home"><img src="https://i.ibb.co/87qghMy/LOGO33.png"></a></span>
        </div> 

        <div id="admin_main_countainer">
            <div class="space">
            </div>
            <div class="admin_option">
                <div class="option_box">
                    <div></div>
                    <div><a href="/adminCategory">Add/Update/Delete Category </a></div>
                </div>
                <div class="option_box">
                    <div></div>
                    <div><a href="/adminSubategory">Add/Update/Delete Subcategory</a></div>

                </div>
                <div class="option_box">
                    <div></div>
                    <div><a href="/adminProductList">Add/Update/Delete product</a></div>
                </div>
                <div class="option_box">
                    <div></div>
                    <div><a href="/variables">Add/Update/Delete Color, Gender, Material, </a></div>
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
        <script src="${pageContext.request.contextPath}/js/main.js"></script>
        <script src="${pageContext.request.contextPath}/js/burger.js"></script>
    </body>

</html>
