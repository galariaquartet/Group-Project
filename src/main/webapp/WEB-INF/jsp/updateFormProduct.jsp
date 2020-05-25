<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>New Product</title>

        <link href="https://fonts.googleapis.com/css?family=Muli:300,400,700,900" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminMain.css">
    </head>
    <body>

        <header id="header">
            <nav class="headernav">
                <ul class="nav-links">
                    <li><a href="/aboutUs"> About us </a></li>
                    <li><a href="/preGame"> Game </a></li>
                    <li><a href="/products"> Shop </a></li>
                    <li><a href="/contact"> Contact </a></li>
                    <li><a href="/adminMain"> Admin </a></li>
                    <li><a href="/account"><img class="acount_icon" src="https://i.ibb.co/ydgtt5p/acount.png"></a></li>
                    <li><a href="/shoppingCart"><img class="basket_icon" src="https://i.ibb.co/Fkr4Ddv/basket4.png"></a></li>
                </ul>
            </nav>
            <div id="logo" class="mask">
                <span class="logo-text masked"><a href="/home"> <img src="https://i.ibb.co/87qghMy/LOGO33.png"></a></span>
            </div> 
        </header>
        <div class="space"></div>
        <div class="admin_new_product_container">
            
               <h2>Update Product</h2>

            <form:form method="POST" action="/updateProduct" modelAttribute="product">

                <form:input path="productId" type="hidden" value="" />

                <form:label path="productName">Product Name: </form:label>
                <form:input path="productName" value="${product.productName}" type="text" required="true"/><br><br>

                <form:label path="sizeId">Product Size: </form:label>
                <form:select path="sizeId" items="${sizes}" itemLabel="sizeName" itemValue="sizeId" required="true"/>
                <form:errors path="sizeId" cssClass="error"/><br><br>

                <form:label path="colorId">Product Color: </form:label>  
                <form:select path="colorId" items="${colors}" itemLabel="colorName" itemValue="colorId" required="true"/>
                <form:errors path="colorId" cssClass="error"/><br><br>

                <form:label path="materialId">Product Material: </form:label>
                <form:select path="materialId" items="${materials}" itemLabel="materialName" itemValue="materialId" required="true"/>
                <form:errors path="materialId" cssClass="error"/><br><br>

                <form:label path="genderId">Product Gender: </form:label>
                <form:select path="genderId" items="${genders}" itemLabel="genderName" itemValue="genderId" required="true"/>
                <form:errors path="genderId" cssClass="error"/><br><br>

                <form:label path="productStock">Product Stock: </form:label>
                <form:input path="productStock" type="number" min="0" required="true"/><br><br>

                <form:label path="productPrice">Product Price: </form:label>
                <form:input path="productPrice" type="number" min="0" required="true" step="0.01"/><br><br>

                <form:label path="subcategoryId">Product Category: </form:label>
                <form:select path="subcategoryId" items="${subcategory}" itemLabel="subcategoryName" itemValue="subcategoryId" required="true"/>
                <form:errors path="subcategoryId" cssClass="error"/><br><br>

                <label for="myphotos">
                    Product Photos (* e.g url1, url2, url3...)
                </label>
                <c:forEach var="c" items="${imageFilePath}">     
                    <input type="text" value="${c.productFilepath}" name="myphotos" required="true"/><br><hr>
                </c:forEach>
                <input type="submit" value="Submit"/>
            </form:form>

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

    </body>
</html>