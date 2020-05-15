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
        <h1>update</h1>
        <form:form method="POST" action="/${customerId}/updateShoppingCart" modelAttribute="shoppingCart">

            <form:input path="shoppingCartId" type="hidden" value=""/>

            <form:input path="customerId" type="hidden" value="${customerId}"/>

            <form:label path="quantity">quantity</form:label>
            <form:input path="quantity" type="number"/>

            <form:input path="productId" type="hidden"/>



            <input type="submit" value="Submit"/>

        </form:form>
    </body>
</html>
