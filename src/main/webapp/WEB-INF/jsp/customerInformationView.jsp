
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
        <p>${listCustomerInformations.customerId}</p>
        <p>${listCustomerInformations.firstName}</p>
        <p>${listCustomerInformations.lastName}</p>
        <p>${listCustomerInformations.country}</p>
        <p>${listCustomerInformations.state}</p>
        <p>${listCustomerInformations.city}</p>
        <p>${listCustomerInformations.street}</p>
        <p>${listCustomerInformations.zip}</p>
        <p>${listCustomerInformations.phone}</p>
 
       
    </body>
</html>
