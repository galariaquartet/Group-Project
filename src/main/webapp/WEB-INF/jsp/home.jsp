<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="https://fonts.googleapis.com/css?family=Muli:300,400,700,900" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>

        <nav class="headernav">
            <ul class="nav-links">
                <li><a href="/aboutUs"> About us </a></li>
                <li><a href="#"> Game </a></li>
                <li><a href="/products"> Shop </a></li>
                <li><a href="/contact"> Contact </a></li>
                <li><a href="/adminMain"> Admin </a></li>
                <li><a href="/account"><img class="acount_icon" src="https://i.ibb.co/ydgtt5p/acount.png"></a></li>
                <li><a href="/shoppingCart"><img class="basket_icon" src="https://i.ibb.co/Fkr4Ddv/basket4.png"></a></li>
            </ul>

            <div class="burger" >
                <div class="line1"></div>
                <div class="line2"></div>
                <div class="line3"></div>
            </div>
        </nav>

        <div id="hero-slider">
            <div id="logo" class="mask">
                <span class="logo-text masked"><a href="#"> <img src="https://i.ibb.co/87qghMy/LOGO33.png"></a></span>
            </div> 
            <div class="linediv">
                <div id="scrolDown"></div>
            </div>

            <div class="linedivS">
                <div id="scrolDownR"></div>
            </div>

            <div class="linedivV">
                <div id="scrolDownV"></div>
            </div>
            <div id="slideshow">
                <div id="slides-main" class="slides">
                    <div class="slide" data-index="0">
                        <div class="abs-mask">
                            <div class="slide-image" style="background-image: url(https://i.ibb.co/SXHFk4K/slide-1.jpg)"></div>
                        </div>
                    </div>
                    <div class="slide" data-index="1">
                        <div class="abs-mask">
                            <div class="slide-image" style="background-image: url(https://i.ibb.co/NWpn5xg/slide-2.jpg)"></div>
                        </div>
                    </div>
                    <div class="slide" data-index="2">
                        <div class="abs-mask">
                            <div class="slide-image" style="background-image: url(https://i.ibb.co/CbfgL51/slide-3.jpg)"></div>
                        </div>
                    </div>
                    <div class="slide" data-index="3">
                        <div class="abs-mask">
                            <div class="slide-image" style="background-image: url(https://i.ibb.co/S3T3MgK/Ourgame-Bg.png)"></div>
                        </div>
                    </div>
                </div>
                <div id="slides-aux" class="slides mask">
                    <div class="slide-title slide " data-index="0">
                        <a href="<?php echo get_home_url(); ?>/proionta/">
                            <div class="circletexthm">PRODUCTS</div>
                        </a>
                        <div class="ftextfront">It's the Light</div>
                        <a href="<?php echo get_home_url(); ?>/proionta/">
                            <div class="circleHm">
                                <div class="circletexth">PRODUCTS</div>
                            </div>
                        </a>
                    </div>
                    <div class="slide-title slide" data-index="1">
                        <a href="<?php echo get_home_url(); ?>/proionta/">
                            <div class="circletexthm">PRODUCTS</div>
                        </a>
                        <div  class="ftextfront">Vibia  J. Ll. Xuclà </div>
                        <a href="<?php echo get_home_url(); ?>/proionta/">
                            <div class="circleHm">
                                <div class="circletexth">PRODUCTS</div>
                            </div>
                        </a>
                    </div>
                    <div class="slide-title slide" data-index="2">
                        <a href="<?php echo get_home_url(); ?>/projects/">
                            <div class="circletexthm"> PROJECTS     </div>
                        </a>
                        <div  class="ftextfront">Future Lights</div>
                        <a href="<?php echo get_home_url(); ?>/projects/">
                            <div class="circleHm">
                                <div class="circletexth"> PROJECTS </div>
                            </div>
                        </a>
                    </div>
                    <div class="slide-title slide" data-index="3">
                        <a href="<?php echo get_home_url(); ?>/etaireia/">
                            <div class="circletexthm1">SHOW ROOM</div>
                        </a>
                        <div class="ftextfront">One stop shop for lighting</div>
                        <a href="<?php echo get_home_url(); ?>/etaireia/">
                            <div class="circleHm">
                                <div class="circletexth1"> SHOW ROOM</div>
                            </div>
                        </a>
                    </div>
                </div>
                <nav id="slider-nav">
                    <span class="current">01</span>
                    <span class="sep"></span>
                    <span class="total">04</span>
                </nav>
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

