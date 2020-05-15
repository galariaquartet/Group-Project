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
        <form:form method="POST" action="/updateCustomerInformation" modelAttribute="customerInformation">
            <h2>Sign Up</h2>
            <form:input path="customerId" type="hidden" value=""/>

            <form:label path="firstName">first Name</form:label>
            <form:input path="firstName" type="text"/>

            <form:label path="lastName">last Name</form:label>
            <form:input path="lastName" type="text"/>

            <form:label path="country">country</form:label>
            <form:input path="country" type="text"/>

            <form:label path="state">state</form:label>
            <form:input path="state" type="text"/>

            <form:label path="city">city</form:label>
            <form:input path="city" type="text"/>

            <form:label path="street">street</form:label>
            <form:input path="street" type="text"/>

            <form:label path="zip">zip</form:label>
            <form:input path="zip" type="text"/>

            <form:label path="phone">phone</form:label>
            <form:input path="phone" type="number"/>


            <input type="submit" value="Submit"/>

        </form:form>
    </body>
</html>
