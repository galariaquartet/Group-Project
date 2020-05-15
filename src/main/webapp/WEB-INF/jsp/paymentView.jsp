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

        <a href="newPayment">Create new Payment</a>
        <br/>

        <table border='1' cellpadding="10">
            <thead>
                <tr>
                    <th>payment Id</th>
                    <th>payment Name</th>
                </tr>
            </thead>
            <tbody>

                <c:forEach var="p" items="${listPayment}">           
                    <tr>
                        <!--                            edw bazoume tis metablhtes akribws pou antistoixoun sto entity-->
                        <td>${p.paymentId}</td>
                        <td>${p.paymentName}</td>

                        <td>
                            <a href="/editPayment/${p.paymentId}">Edit</a>
                            <a href="/deletePayment/${p.paymentId}">Delete</a>

                        </td>   
                    </tr>

                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
