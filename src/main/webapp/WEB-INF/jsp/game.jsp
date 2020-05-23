<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Game</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/game.css">
        <link href="https://fonts.googleapis.com/css?family=Ubuntu:700&display=swap" rel="stylesheet">
    </head>
    <body>
        <main>
            <nav class="headernav">
                <ul class="nav-links">
                    <li><a href="aboutUs"> About us </a></li>
                    <li><a href="#"> Game </a></li>
                    <li><a href="/products"> Shop </a></li>
                    <li><a href="/contact"> Contact </a></li>
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

            <ul id="scene">
                <div class="container">
                    <!-- CHAT1 -->
                    <a href="">
                        <div class="chat_button layer" data-depth="0.1" >
                            <div class="btn" style="padding: 1rem;width: fit-content"> Chat </div></div>
                    </a>
                    <a href="/chess/chess.html">
                        <div class="layer button_play " data-depth="0.1">

                            <div class="btn ">
                                <div class="button_play_inner" style="">
                                    <h1 > PLAY </h1>
                                    <h1 >THE GAME</h1> 
                                </div>
                            </div>
                        </div>
                    </a>
                    <li class="layer" data-depth="0.7"><img src="https://i.ibb.co/FH7PMzx/filledpolygon.png" alt="image"></li>></li>
                    <li class="layer" data-depth="0.3"><img src="https://i.ibb.co/jD4979J/lettercuts.png" alt="image"></li>
                    <!--  <li class="layer" data-depth="0.05"><img src="images/unicorntext.png" alt="image"></li> -->
                    <li class="layer" data-depth="0.15"><img src="https://i.ibb.co/myFYtzf/polygons.png" alt="image"></li>>

                    <li class="layer" data-depth="0.09"><img src="https://i.ibb.co/BfRMf8M/arereal.png" alt="image"></li>
                    <!-- <li class="layer" data-depth="0.20"><img src="images/unicorn.png" alt="image"></li>></li> -->
            </ul>

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
            <script>
                var scene = document.getElementById('scene');
                var parallax = new Parallax(scene);
            </script>
        </div>
    </main>
    <script src="${pageContext.request.contextPath}/js/game.js"></script>
</body>
</html>