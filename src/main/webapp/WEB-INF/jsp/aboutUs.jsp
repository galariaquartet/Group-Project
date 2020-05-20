<%-- 
    Document   : aboutUs
    Created on : May 19, 2020, 4:19:42 PM
    Author     : User
--%>

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

      <header id="header">
       <nav class="headernav">
          <ul class="nav-links">
            <li><a href="/aboutUs"> About us </a></li>
            <li><a href="#"> Game </a></li>
           <li><a href="/products"> Shop </a></li>
            <li><a href="/contact"> Contact </a></li>
          </ul>

          <ul class="nav-links">
              <li><a href="/account"><img class="acount_icon" src="./assets/img/acount.png"></a></li>
            
             <li><a href="Checkout.html"><img class="basket_icon" src="./assets/img/basket4.png"></a></li>
          </ul>
        </nav>
        <div id="logo" class="mask">
            <span class="logo-text masked"><a href="index.html"> <img src="./assets/img/LOGO33.png"></span>
        </div> 


       
        </header>





        <div id="abouts_us_countainer">
          <div class="about_text">
            <h1>About us</h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
            
          </div>

          
         

            
        
        




<!--    <div class="logo_mobile">
                    <a href="http://axtida.lighting"><img src="http://axtida.lighting/wp-content/uploads/2020/01/ASPRO-LOGO-AXTIDA.png" ></a>
                    <div class="burger" onclick="myFunction(this)">
                            <div class="line1"></div>
                            <div class="line2"></div>
                            <div class="line3"></div>
                    </div>
    </div>
    <script>function myFunction(x) { x.classList.toggle("change"); }</script> -->


</div>
<div class="footer">
  <div class="footercontainer">
    <div class="social_footer">

      <div class="follow_us">Follow us </div>

      <div class="social_icon"><img src="./assets/img/facebook-icon.png"></div>
      <div class="social_icon"><img src="./assets/img/instagram-icons.png"></div>
       <div class="social_icon"><img src="./assets/img/white-github-icon-813505.png"></div>
      
    </div>

    
  </div>
  
</div>
    <script src="${pageContext.request.contextPath}/js/main.js"></script>
</body>

</html>
