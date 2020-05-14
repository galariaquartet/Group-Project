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

            <a href="/shoppingCart">view shopping cart</a>

           <h1>Product Manager</h1> 
            <a href="/newProduct">Create New Product</a>
            <br/>
            <br/>
            <table border='1' cellpadding="10">
                <thead>
                    <tr>
                        <th>Product id</th>
                        <th>Product Name</th>
                        <th>Product Size</th>
                        <th>Product Color</th>
                        <th>Product Material</th>
                        <th>Product Gender</th>
                        <th>Product Stock</th>
                        <th>Product Price</th>
                        <th>Product subcategory Name</th>
                        <th>Product Images </th>
                        <th>Quantity </th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="pr" items="${listproducts}">
                        <tr>
                            <td>${pr.productId}</td>
                            <td>${pr.productName}</td>
                            <td>${pr.productSize}</td>
                            <td>${pr.productColor}</td>
                            <td>${pr.productMaterial}</td>
                            <td>${pr.productGender}</td>
                            <td>${pr.productStock}</td>   
                            <td>${pr.productPrice}</td>   
                            <td>${pr.subcategoryId.subcategoryName}</td>   
                            <td>
                                <c:forEach var="pw" items="${pr.productImageList}">
                                    <img src="${pw.productFilepath}" height="100px" width="150px"/>
                                </c:forEach> 
                            </td>  
                            <td>
                                <form action="/addToCart/${pr.productId}" method="POST" >
                                    <input type="number" value="1" min="1" max="${pr.productStock}" name="quantity" />
                            </td>
                            <td>
                                <a href="/editProduct/${pr.productId}">Edit</a>
                                <a href="/deleteProduct/${pr.productId}">Delete</a>
                                <button type="submit">Add to cart</button>
                            </td> 
                            </form>
                        </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
