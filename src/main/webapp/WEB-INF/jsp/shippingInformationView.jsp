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
        <div align="center">
            <br/>
            <a href="newShippingInformation">Create new shippingInformation</a>
            <br/>
            <!--auto mallon den 8a to xreiastoume-->
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
                            <td>
                                <a href="/editShippingInformation/${si.shippingInformationId}">Edit</a>
                                <a href="/deleteShippingInformation/${si.shippingInformationId}">Delete</a>
                            </td>   
                        </tr>

                    </c:forEach>
                </tbody>
            </table>

        </div>
    </body>
</html>
