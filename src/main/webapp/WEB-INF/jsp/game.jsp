<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Game</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/game.css">
        <link href="https://fonts.googleapis.com/css?family=Ubuntu:700&display=swap" rel="stylesheet">
        <script
            src="https://code.jquery.com/jquery-2.2.4.js"
            integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
        crossorigin="anonymous"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/chat.css">

    </head>
    <body>
        <main>
            <nav class="headernav">
                <ul class="nav-links">
                    <li><a href="aboutUs"> About us </a></li>
                    <li><a href="#"> Game </a></li>
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
            <div id="chat-page"  class="box-chat center hidden">

                <button id="closeChat" style="float: right;">X</button>
                <h2>The Knight Community</h2>
                <div class="connecting">Connecting...</div>
                <div>

                    <ul id="messageArea">
                        <c:forEach var="c" items="${messages}"  >    

                            <c:if test = "${c.customerId.username == usernameCustomer }">
                                <li class="my_user_name" id="user"><div>${c.customerId.username}</div></li>
                                <div class="my_user_mess" ><p> ${c.message}</p></div>
                            </c:if>
                            <c:if test = "${c.customerId.username != usernameCustomer }">
                                <li class="other_user_name" ><div>${c.customerId.username}</div></li>
                                <div class="other_user_mess" ><p> ${c.message}</p></div>
                            </c:if>
                        </c:forEach>


                    </ul>
                </div>
                <form id="messageForm" name="messageForm" nameForm="messageForm">
                    <div class="form-group">
                        <div class="input-group clearfix">
                            <input type="hidden" id="name" value="${usernameCustomer}"/>
                            <input type="text" id="message" placeholder="Type a message..."
                                   autocomplete="off" class="form-control" />
                            <button class="send_mess_button" type="submit" class="primary"><img class="send_chat_svg" src="${pageContext.request.contextPath}/chess/img/60525.svg"></button>
                        </div>
                    </div>
                </form>
            </div>



            <div id="logo" class="mask">
                <span class="logo-text masked"><a href="/home"> <img src="https://i.ibb.co/87qghMy/LOGO33.png"></a></span>
            </div> 

            <ul id="scene">
                <div class="container">
                    <!-- CHAT1 -->
                    <!--                    <a  href="">-->
                    <div id="chat" onclick="connect()" class="chat_button layer" data-depth="0.1" >
                        <div class="btn" style="padding: 1rem;width: fit-content"> Chat </div></div>
                    <!--                    </a>-->


                    <a   href="/chess/chess.html">
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
                        <div class="socials_div">
                            <div class="social_icon"><img src="https://i.ibb.co/1LbHv7c/facebook-icon.png"></div>
                            <div class="social_icon"><img src="https://i.ibb.co/37ymrym/instagram-icons.png"></div>
                            <div class="social_icon"><img src="https://i.ibb.co/P6dSF3w/white-github-icon-813505.png"></div>
                        </div>
                    </div>
                </div>
            </div>
            <script src="${pageContext.request.contextPath}/js/game.js"></script>                    
            <script>
                        var scene = document.getElementById('scene');
                        var parallax = new Parallax(scene);
            </script>

        </div>
    </main>

    <script>
        $('#closeChat').on('click', function () {
            $('.center').hide();
        });
        $('#chat').on('click', function () {
            $('.center').show();
        })
    </script>
    <script
    src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
    <script
    src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/chat2.js"></script>
    <script src="${pageContext.request.contextPath}/js/burger.js"></script>       
</body>
</html>