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
        <h1>shopping cart</h1>
        <div align="center">
            <br/>
            <br/>
            <table border='1' cellpadding="10">
                <thead>
                    <tr>
                        <th>shoppingCartId</th>
                        <th>quantity</th>
                        <th>productId</th>
                        <th>customerId</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="sc" items="${shoppingCart}">
                        <tr>
                            <!--                            edw bazoume tis metablhtes akribws pou antistoixoun sto entity-->
                            <td>${sc.shoppingCartId}</td>
                            <td>${sc.quantity}</td>
                            <td>${sc.productId}</td>
                            <td>${sc.customerId}</td>
                            <td>

                                <a href="/deleteShoppingCart/${sc.shoppingCartId}">Delete</a>
                            </td>   
                        </tr>
                    </tbody>
                </c:forEach>
            </table>
    </body>
</html>
