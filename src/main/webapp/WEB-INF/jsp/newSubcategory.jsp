<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Subcategory</title>
    </head>
    <body>
        <form:form method="POST" action="saveSubcategory" modelAttribute="subcategory">

            <form:label path="subcategoryName">subcategory Name </form:label>
            <form:input path="subcategoryName" type="text"/>

            <form:label path="subcategoryImageFilepath">subcategoryImageFilepath</form:label>
            <form:input path="subcategoryImageFilepath" type="text"/>

            <form:select path="categoryId" items="${categoryList}" itemLabel="categoryName" itemValue="categoryId"/>
            <form:errors path="categoryId" cssClass="error"/>

            <input type="submit" value="Submit"/>
        </form:form>
    </body>
</html>
