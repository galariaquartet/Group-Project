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
        <form:form method="POST" action="saveShippingInformation" modelAttribute="shippingInformation">
            <h2>Sign Up</h2>
            
            <form:label path="shippingCountry">shipping Country</form:label>
            <form:input path="shippingCountry" type="text"/>

            <form:label path="shippingState">shipping State</form:label>
            <form:input path="shippingState" type="text"/>

            <form:label path="shippingCity">shipping City</form:label>
            <form:input path="shippingCity" type="text"/>

            <form:label path="shippingStreet">shipping Street</form:label>
            <form:input path="shippingStreet" type="text"/>
            
            <form:label path="shippingZip">shipping Zip</form:label>
            <form:input path="shippingZip" type="text"/>
            
            <form:label path="recipientFirstName">recipient First Name</form:label>
            <form:input path="recipientFirstName" type="text"/>
            
            <form:label path="recipientLastName">recipient Last Name</form:label>
            <form:input path="recipientLastName" type="text"/>
            
            <form:label path="recipientPhone">recipient Phone</form:label>
            <form:input path="recipientPhone" type="text"/>

            <input type="submit" value="Submit"/>

        </form:form>
    </body>
</html>
