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
        <form:form method="POST" action="${customerId}/saveCustomerOrder/" modelAttribute="customerOrder">

            <form:label path="orderDate">order Date</form:label>
            <form:input path="orderDate" type="datetime-local"/>

            <input type="submit" value="Submit"/>

        </form:form>
    </body>
</html>
