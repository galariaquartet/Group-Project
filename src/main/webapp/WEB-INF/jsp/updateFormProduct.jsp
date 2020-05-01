
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Upadate Product form</h1>

        <form:form enctype="multipart/form-data"  method="POST" action="/updateProduct" modelAttribute="product">

            <form:input path="productId" type="hidden" value="" />

            <form:label path="productName">product Name</form:label>
            <form:input path="productName" type="text"/>

            <form:label path="productDescription">productDescription</form:label>
            <form:input path="productDescription" type="text"/>

            <form:label path="productStock">product Stock</form:label>
            <form:input path="productStock" type="number"/>

            <form:label path="productPrice">product Price</form:label>
            <form:input path="productPrice" type="number"/>

            <form:select path="categoryId" items="${categoryList}" itemLabel="categoryName" itemValue="categoryId"/>
            <form:errors path="categoryId" cssClass="error"/>



            <!--             <input type="file" name="myfile">-->
            <input type="submit" value="Submit"/>


        </form:form>
    </body>
</html>
