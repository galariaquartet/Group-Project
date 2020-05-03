
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

        
        <h1>asdasdasda</h1>
        <p>${customerInformations.customerId}</p>
        <p>${customerInformations.firstName}</p>
        <p>${customerInformations.lastName}</p>
        <p>${customerInformations.country}</p>
        <p>${customerInformations.state}</p>
        <p>${customerInformations.city}</p>
        <p>${customerInformations.street}</p>
        <p>${customerInformations.zip}</p>
        <p>${customerInformations.phone}</p>
 
        <a href="editCustomerInformation"> Edit</a>
        <a href="deleteCustomerInformation"> delete</a>
       
    </body>
</html>
