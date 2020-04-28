
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
              <div allign="center" class="insert-courses">
            <form:form method="POST" action="/updateCategory" modelAttribute="category">
                <h2>Update</h2>
                 <form:input path="categoryId" type="hidden" value="" />
                 
                <form:label path="categoryName">category Name</form:label>
                <form:input path="categoryName" type="text"/>

                <form:label path="categoryImage">category Image</form:label>
                <form:input path="categoryImage" type="text"/>

                <form:label path="filename">filename</form:label>
                <form:input path="filename" type="text"/>

                <input type="submit" value="Submit"/>

            </form:form>
    </body>
</html>
