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

        <a href="newSubcategory">Create New Subcategory</a>
        <br/>

        <table border='1' cellpadding="10">
            <thead>
                <tr>
                    <th>Subcategory id</th>
                    <th>Subcategory Name</th>
                    <th>Subcategory Filepath</th>
                    <th>Category Name</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>

                <c:forEach var="c" items="${listsubCategory}">           
                    <tr>
                        <!--                            edw bazoume tis metablhtes akribws pou antistoixoun sto entity-->
                        <td>${c.subcategoryId}</td>
                        <td>${c.subcategoryName}</td>
                        <td><img src="${c.subcategoryImageFilepath}" width="100px" height="100px"/></td>
                        <td>${c.categoryId.categoryName}</td>
                        <td>
                            <a href="/editSubcategory/${c.subcategoryId}">Edit</a>
                            <a href="/deleteSubcategory/${c.subcategoryId}">Delete</a>
                        </td>   
                    </tr>
                </tbody>
            </c:forEach>
        </table>

    </body>
</html>