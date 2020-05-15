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
        <a href="newOrderStatus">Create new order Status</a>
        <br/>

        <table border='1' cellpadding="10">
            <thead>
                <tr>
                    <th>order Status Id</th>
                    <th>order Status Name</th>
                    <th>tracking No</th>
                </tr>
            </thead>
            <tbody>

                <c:forEach var="o" items="${orderStatusList}">           
                    <tr>
                        <!--                            edw bazoume tis metablhtes akribws pou antistoixoun sto entity-->
                        <td>${o.orderStatusId}</td>
                        <td>${o.orderStatusName}</td>
                        <td>${o.trackingNo}</td>

                        <td>
                            <a href="/editOrderStatus/${o.orderStatusId}">Edit</a>
                            <a href="/deleteOrderStatus/${o.orderStatusId}">Delete</a>

                        </td>   
                    </tr>
                </tbody>
            </c:forEach>
        </table>
    </body>
</html>
