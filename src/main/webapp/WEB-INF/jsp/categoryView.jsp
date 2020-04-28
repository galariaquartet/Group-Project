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
        <h1>Hello World!</h1>
        
                  <a href="newCategory">Create New Category</a>
            <br/>
        
            <table border='1' cellpadding="10">
                <thead>
                    <tr>
                        <th>Category id</th>
                        <th>Category Name</th>
                        <th>Category Image</th>
                        <th>Filename</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
    
                <c:forEach var="c" items="${listcategory}">           
                    <tr>
                        <!--                            edw bazoume tis metablhtes akribws pou antistoixoun sto entity-->
                        <td>${c.categoryId}</td>
                        <td>${c.categoryName}</td>
                        <td>${c.categoryImage}</td>
                        <td>${c.filename}</td>   
                        <td>
                            <a href="/edit/${c.categoryId}">Edit</a>
                                <a href="/delete/${c.categoryId}">Delete</a>

                        </td>   
                    </tr>
                    </tbody>
                </c:forEach>
            </table>

    </body>
</html>
