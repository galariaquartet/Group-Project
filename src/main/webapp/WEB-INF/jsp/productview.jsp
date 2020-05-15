<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Manager</title>

        <link href="<c:url value="css/main.css" />" rel="stylesheet">

        <style>
            #product {
                margin: 2px;
                border: 1px solid black;
            }

            #byproduct {
                margin: 2px;
                border: 1px dashed red;
            }

        </style>
    </head>
    <body>
        <a href="/shoppingCart">view shopping cart</a>
        <hr>
        <c:forEach var="pr" items="${allproducts}">
            <div id="product">
                <c:set var = "s" value = "${pr}"/>
                <c:out value="${s[0].productName}"/>
                <c:forEach var="p" items="${pr}">
                    <div id="byproduct">
                        ${p.sizeId.sizeName}
                        ${p.colorId.colorName}
                        ${p.materialId.materialName}
                        ${p.genderId.genderName}
                    </div>
                </c:forEach>
            </div>
        </c:forEach>
        <hr>
        <a href="/newProduct">Create New Product</a>
    </body>
</html>
