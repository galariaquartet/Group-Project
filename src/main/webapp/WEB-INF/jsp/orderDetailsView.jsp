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
        <h1>Tzitzis bot at your service</h1>
        <p>${order_details}</p>


        <div align="center">
            <br/>
            <a href="newShippingInformation">Create new shippingInformation</a>
            <br/>

            <br/>
            <table border='1' cellpadding="10">
                <thead>
                    <tr>
                        <th>shippingInformation Id</th>
                        <th>shipping Country</th>
                        <th>shipping State</th>
                        <th>shipping City</th>
                        <th>shipping Street</th>
                        <th>shipping Zip</th>
                        <th>recipient First Name</th>
                        <th>recipient Last Name</th>
                        <th>recipient Phone</th>

                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="si" items="${listShippingInformation}">
                        <tr>
                            <!--                            edw bazoume tis metablhtes akribws pou antistoixoun sto entity-->
                            <td>${si.shippingInformationId}</td>
                            <td>${si.shippingCountry}</td>
                            <td>${si.shippingState}</td>
                            <td>${si.shippingCity}</td>
                            <td>${si.shippingStreet}</td>
                            <td>${si.shippingZip}</td>
                            <td>${si.recipientFirstName}</td>
                            <td>${si.recipientLastName}</td>
                            <td>${si.recipientPhone}</td>

                        </tr>

                    </c:forEach>
                </tbody>
            </table>

        </div>

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
