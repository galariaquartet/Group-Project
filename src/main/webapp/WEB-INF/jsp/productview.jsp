<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Manager</title>

        <link href="<c:url value="css/main.css" />" rel="stylesheet">

    </head>
    <body style="background-color: #f9dcfa">
        <div align="center">
            <h1>Product Manager</h1>
            <a href="new">Create New Trainer</a>
            <br/>
            <br/>
            <table border='1' cellpadding="10">
                <thead>
                    <tr>
                        <th>Product id</th>
                        <th>Product Name</th>
                        <th>Product Description</th>
                        <th>Product Stock</th>
                        <th>Product Price</th>
                        <th>Product categoryId</th>
                        <th>Product category Name</th>
<!--                        <th>Product ImageId</th>-->
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="pr" items="${listproducts}">
                        <tr>
                            <!--                            edw bazoume tis metablhtes akribws pou antistoixoun sto entity-->
                            <td>${pr.productId}</td>
                            <td>${pr.productName}</td>
                            <td>${pr.productDescription}</td>
                            <td>${pr.productStock}</td>   
                            <td>${pr.productPrice}</td>   
                            <td>${pr.categoryId}</td>   
                            <td>${pr.categoryName}</td>   
                            
               
                            <td>
                                
                            </td>   
                        </tr>
                    </tbody>
                </c:forEach>
            </table>

        </div>

    </body>
</html>
