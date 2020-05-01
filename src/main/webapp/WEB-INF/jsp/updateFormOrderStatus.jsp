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
            <form:form method="POST" action="/updateOrderStatus" modelAttribute="orderStatus">

                  <form:input path="orderStatusId" type="hidden" value="" />
                
                <form:label path="orderStatusName">order Status Name</form:label>
                <form:input path="orderStatusName" type="text"/>

                <form:label path="trackingNo">tracking No</form:label>
                <form:input path="trackingNo" type="text"/>

                <input type="submit" value="Submit"/>

            </form:form>
    </body>
</html>
