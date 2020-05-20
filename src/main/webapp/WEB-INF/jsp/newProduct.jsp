<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Product</title>
    </head>
    <body>

        <form:form method="POST" action="${formpath}" modelAttribute="product">

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
            <form:input path="productPrice" type="number" min="0" required="true"/><br><br>

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


    </body>
</html>
