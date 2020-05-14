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

            <form:label path="productSize">Product Size</form:label>
            <form:input path="productSize" type="text"/>
            
            <form:label path="productColor">Product Color</form:label>
            <form:input path="productColor" type="text"/>
            
            <form:label path="productMaterial">Product Material</form:label>
            <form:input path="productMaterial" type="text"/>
            
             <form:label path="productGender">Product Gender</form:label>
            <form:input path="productGender" type="text"/>

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
