<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Details</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <nav class="headernav">
            <ul class="nav-links">
                <li><a href="/aboutUs"> About us </a></li>
                <li><a href="/preGame"> Game </a></li>
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
            <span class="logo-text masked"><a href="/home"> <img src="https://i.ibb.co/87qghMy/LOGO33.png"></a></span>
        </div> 

        <div class="order_details_container">
            <div class="space_big"></div>
            <div class="order_details_form">
                <h2> Order Details </h2>
                <c:forEach var="o" items="${orderDetails}">
                    <p> <strong>Order Number : </strong> ${o.orderNumber.orderNumber}</p>
                    <p><strong>Payment Details : </strong> ${o.paymentId.paymentName}</p>
                    <p><strong>Product Details : </strong> ${o.productId.productName}, ${o.productId.productPrice}, ${o.productId.colorId.colorName}, ${o.productId.genderId.genderName}, ${o.productId.materialId.materialName}, ${o.productId.sizeId.sizeName} </p>
                    <p><strong>User Info : </strong> ${o.shippingInformationId.recipientFirstName}, 
                        ${o.shippingInformationId.recipientLastName},
                        ${o.shippingInformationId.recipientPhone},
                        ${o.shippingInformationId.shippingCountry},
                        ${o.shippingInformationId.shippingState},
                        ${o.shippingInformationId.shippingCity},
                        ${o.shippingInformationId.shippingStreet},
                        ${o.shippingInformationId.shippingZip},

                    </p>

                    <hr>
                </c:forEach>
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
        <script src="${pageContext.request.contextPath}/js/burger.js"></script>
    </body>
</html>
