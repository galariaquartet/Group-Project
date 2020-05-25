<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/updateFormInformation.css">
        <title>Update info</title>
    </head>
    <body>
        <nav class="headernav">
            <ul class="nav-links">
                <li><a href="/aboutUs"> About us </a></li>
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
        <div class="update_info_container">
            <div class="space"></div>

            <div class="update_info_form_container">
                <form:form method="POST" action="/updateCustomerInformation" modelAttribute="customerInformation">
                    <form:input path="customerId" type="hidden" value=""/>

                    <form:label path="firstName" >First Name:</form:label>
                    <form:input path="firstName" type="text" />

                    <form:label path="lastName">Last Name:</form:label>
                    <form:input path="lastName" type="text" />

                    <form:label path="country">Country:</form:label>
                    <form:input path="country" type="text"/>

                    <form:label path="state">State:</form:label>
                    <form:input path="state" type="text"  />

                    <form:label path="city">City:</form:label>
                    <form:input path="city" type="text"/>

                    <form:label path="street">Street:</form:label>
                    <form:input path="street" type="text"/>

                    <form:label path="zip">Zip:</form:label>
                    <form:input path="zip" type="text"/>

                    <form:label path="phone">Phone:</form:label>
                    <form:input path="phone" type="number"/>


                    <input type="submit" value="Submit"/>

                    <hr>
                    <a href="deleteCustomerInformation">Delete Your Info</a>
                </form:form>
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
