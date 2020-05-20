<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categories</title>
    </head>
    <body>

        <a href="newCategory">Create New Category</a>
        <br/>

        <table border='1' cellpadding="10">
            <thead>
                <tr>
                    <th>Category id</th>
                    <th>Category Name</th>
                    <th>Category Image</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>

                <c:forEach var="c" items="${listcategory}">           
                    <tr>
                        <td>${c.categoryId}</td>
                        <td>${c.categoryName}</td>
                        <td> <a href="/subCategory/${c.categoryId}"><img src="${c.categoryImageFilepath}" width="100px" height="100px"></a></td>   
                        <td>
                            <a href="/editCategory/${c.categoryId}">Edit</a>
                            <a href="/deleteCategory/${c.categoryId}">Delete</a>
                        </td>   
                    </tr>
                </tbody>
            </c:forEach>
        </table>

    </body>
</html>
