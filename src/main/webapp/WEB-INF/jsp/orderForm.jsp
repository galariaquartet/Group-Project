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
        <form:form method="POST" action="order/process" modelAttribute="sicipDTO">

            <form:input path="customerInformation.customerId" type="hidden" value=""/>

            <form:label path="customerInformation.firstName" >first Name</form:label>
            <form:input path="customerInformation.firstName" type="text" value="${customerInformation.firstName}"/>

            <form:label path="customerInformation.lastName">last Name</form:label>
            <form:input path="customerInformation.lastName" type="text" value="${customerInformation.lastName}"/>

            <form:label path="customerInformation.country">country</form:label>
            <form:input path="customerInformation.country" type="text" value="${customerInformation.country}"/>

            <form:label path="customerInformation.state">state</form:label>
            <form:input path="customerInformation.state" type="text" value="${customerInformation.state}"/>

            <form:label path="customerInformation.city">city</form:label>
            <form:input path="customerInformation.city" type="text" value="${customerInformation.city}"/>

            <form:label path="customerInformation.street">street</form:label>
            <form:input path="customerInformation.street" type="text" value="${customerInformation.street}"/>

            <form:label path="customerInformation.zip">zip</form:label>
            <form:input path="customerInformation.zip" type="text" value="${customerInformation.zip}"/>

            <form:label path="customerInformation.phone">phone</form:label>
            <form:input path="customerInformation.phone" type="number" value="${customerInformation.phone}"/>

            <hr>    
              <form:checkbox  path="check" value="" id="myCheck"  onclick="myFunction()"/>
<!--            <input path="check" type="checkbox" id="myCheck"  onclick="myFunction()">-->
            <div id="text" style="display:none">
                <hr>
                <form:input path="shippingInformation.shippingInformationId" type="hidden" value=""/>

                <form:label path="shippingInformation.shippingCountry">shippingCountry</form:label>
                <form:input path="shippingInformation.shippingCountry" type="text"/>

                <form:label path="shippingInformation.shippingState">shippingState</form:label>
                <form:input path="shippingInformation.shippingState" type="text"/>

                <form:label path="shippingInformation.shippingCity">shippingCity</form:label>
                <form:input path="shippingInformation.shippingCity" type="text"/>

                <form:label path="shippingInformation.shippingStreet">shippingStreet</form:label>
                <form:input path="shippingInformation.shippingStreet" type="text"/>

                <form:label path="shippingInformation.shippingZip">shippingZip</form:label>
                <form:input path="shippingInformation.shippingZip" type="text"/>

                <form:label path="shippingInformation.recipientFirstName">recipientFirstName</form:label>
                <form:input path="shippingInformation.recipientFirstName" type="text"/>

                <form:label path="shippingInformation.recipientLastName">recipientLastName</form:label>
                <form:input path="shippingInformation.recipientLastName" type="text"/>

                <form:label path="shippingInformation.recipientPhone">recipientPhone</form:label>
                <form:input path="shippingInformation.recipientPhone" type="number"/>
            </div>

            <hr>
            <form:radiobuttons  path="payment" items="${payments}" itemLabel="paymentName" itemValue="paymentId"/>
            <form:errors path="payment" cssClass="error"/>

            <input type="submit" value="Submit"/>
        </form:form>




        <script>
            function myFunction() {
                var checkBox = document.getElementById("myCheck");
                var text = document.getElementById("text");
                if (checkBox.checked == true) {
                    text.style.display = "block";
                } else {
                    text.style.display = "none";
                }
            }
        </script>

    </body>
</html>
