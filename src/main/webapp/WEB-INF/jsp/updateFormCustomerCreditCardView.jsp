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
        <div allign="center" class="insert-courses">
            <form:form method="POST" action="/updateCustomerCreditCard/${customerId}" modelAttribute="customerCreditCard">
                <form:input path="cardId" type="hidden"/>

                <form:label path="ownerFirstName">owner First Name</form:label>
                <form:input path="ownerFirstName" type="text"/>

                <form:label path="ownerLastName">owner Last Name</form:label>
                <form:input path="ownerLastName" type="text"/>

                <form:label path="cardNumber">card Number</form:label>
                <form:input path="cardNumber" type="text"/>

                <form:label path="cardNumberLastDigits">card Number Last Digits</form:label>
                <form:input path="cardNumberLastDigits" type="text"/>

                <form:label path="cvv">cvv</form:label>
                <form:input path="cvv" type="text"/>

                <form:label path="expirationDate">expiration Date</form:label>
                <form:input path="expirationDate" type="text"/>



                <input type="submit" value="Submit"/>

            </form:form>
    </body>
</html>
