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

        <form:form method="POST" action="saveProduct" modelAttribute="product">

            <form:label path="productName">Product Name</form:label>
            <form:input path="productName" type="text"/>

            <form:label path="sizeId">Product Size</form:label>
            <form:select path="sizeId" items="${sizes}" itemLabel="sizeName" itemValue="sizeId"/>
            <form:errors path="sizeId" cssClass="error"/>

            <form:label path="colorId">Product Color</form:label>  
            <form:checkboxes path="colorId" items="${colors}" itemLabel="colorName" itemValue="colorId"/>
            <form:errors path="colorId" cssClass="error"/>

            <form:label path="materialId">Product Material</form:label>
            <form:select path="materialId" items="${materials}" itemLabel="materialName" itemValue="materialId"/>
            <form:errors path="materialId" cssClass="error"/>

            <form:label path="genderId">Product Gender</form:label>
            <form:select path="genderId" items="${genders}" itemLabel="genderName" itemValue="genderId"/>
            <form:errors path="genderId" cssClass="error"/>

            <form:label path="productStock">product Stock</form:label>
            <form:input path="productStock" type="number"/>

            <form:label path="productPrice">product Price</form:label>
            <form:input path="productPrice" type="number"/>

            <form:select path="subcategoryId" items="${subcategory}" itemLabel="subcategoryName" itemValue="subcategoryId"/>
            <form:errors path="subcategoryId" cssClass="error"/>


            <input type="text" name="myphotos"/>

            <input type="submit" value="Submit"/>

        </form:form>


    </body>
</html>
