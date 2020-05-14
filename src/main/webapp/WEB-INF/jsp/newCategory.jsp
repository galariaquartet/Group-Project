<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Category</title>
    </head>
    <body>
        <div allign="center" class="insert-courses">
            <form:form method="POST" action="saveCategory" modelAttribute="category">
                <h2>Create New Category</h2>
                <form:label path="categoryName">Category Name</form:label>
                <form:input path="categoryName" type="text"/>

                <form:label path="categoryFilepath">Category Image Filepath</form:label>
                <form:input path="categoryFilepath" type="text" />

                <input type="submit" value="Save Product"/>
            </form:form>
        </div>
    </body>
</html>
