
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
        
                <div align="center">
          
       
            <br/>
            <br/>
            <table border='1' cellpadding="10">
                <thead>
                    <tr>
                        <th>customer Id</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>country</th>
                        <th>state</th>
                        <th>city</th>
                        <th>street</th>
                        <th>zip</th>
                        <th>phone</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="ci" items="${listCustomerInformations}">
                        <tr>
                            <!--                            edw bazoume tis metablhtes akribws pou antistoixoun sto entity-->
                            <td>${ci.customerId}</td>
                            <td>${ci.firstName}</td>
                            <td>${ci.lastName}</td>
                            <td>${ci.country}</td>
                            <td>${ci.state}</td>
                            <td>${ci.city}</td>
                            <td>${ci.street}</td>
                            <td>${ci.zip}</td>
                            <td>${ci.phone}</td>
                           
                            <td>
                                <a href="/editCustomerInformation/${ci.customerId}">Edit</a>
                                <a href="/deleteCustomerInformation/${ci.customerId}">Delete</a>
                            </td>   
                        </tr>
                    </tbody>
                </c:forEach>
            </table>

        </div>
    </body>
</html>
