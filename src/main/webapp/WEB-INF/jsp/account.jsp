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
        <p>${test123456}</p>
        <hr>
        <a href="customerInformation">My Info   |</a>
        <!--      //  <a href="customerOrder">Orders (Default)   |</a>-->

        <div align="center">                 
            <br/>
            <br/>
            <table border='1' cellpadding="10">
                <thead>
                    <tr>
                        <th>order Number</th>
                        <th>orderDate</th>
                        <th>customerId</th>
                        <th>order Status Id</th>

                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="co" items="${listCustomerOrder}">
                        <tr>
                            <!--                            edw bazoume tis metablhtes akribws pou antistoixoun sto entity-->
                            <td>${co.orderNumber}</td>
                            <td>${co.orderDate}</td>
                            <td> <a href="orderdetails/${co.orderNumber}">Order Details</a></td>

                        </tr>

                    </c:forEach>
                </tbody>
            </table>
        </div>

        <a href="">Logout    |</a>
    </body>
</html>
