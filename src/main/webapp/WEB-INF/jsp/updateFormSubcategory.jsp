<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Admin_Cat_del_up</title>

        <link href="https://fonts.googleapis.com/css?family=Muli:300,400,700,900" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminMain.css">
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
                    <li><a href="Acoount.html"><img class="acount_icon" src="./assets/img/acount.png"></a></li>

                    <li><a href="ShopingCart.html"><img class="basket_icon" src="./assets/img/basket4.png"></a></li>
                </ul>
            </nav>
            <div id="logo" class="mask">
                <span class="logo-text masked"><a href="index.html"> <img src="./assets/img/LOGO33.png"></a></span>
            </div> 



        </header>
        <div class="space"></div>
        <div class="admin_cat_container">
            <div class="all">
                <h2>Update Subcategory</h2>
                <form:form method="POST" action="/updateSubcategory" modelAttribute="subcategory">

                    <form:input path="subcategoryId" type="hidden" value="" />

                    <form:label path="subcategoryName">Subcategory Name </form:label>
                    <form:input path="subcategoryName" type="text"/>

                    <form:label path="subcategoryImageFilepath">Subcategory Image Filepath</form:label>
                    <form:input path="subcategoryImageFilepath" type="text"/>

                    <form:label path="categoryId">Category</form:label>
                    <form:select path="categoryId" items="${categoryList}" itemLabel="categoryName" itemValue="categoryId"/>
                    <form:errors path="categoryId" cssClass="error"/>

                    <input type="submit" value="Submit"/>
                </form:form>


            </div>
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