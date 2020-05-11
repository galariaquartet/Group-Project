<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>


        <script
            src="https://code.jquery.com/jquery-2.2.4.js"
            integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
        crossorigin="anonymous"></script>

        <style>

            /*            to xrhsimopoihsame sthn pop up forma*/
            .hide {
                display: none;
            }


            .center {
                margin: auto;
                width: 60%;
                padding: 20px;
                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
            }
        </style>

    </head>
    <body>


        <form:form method="POST" action="order/process" modelAttribute="sicipDTO"  >


            <form:input path="customerInformation.customerId" type="hidden" value=""/>


            <form:label path="customerInformation.firstName">first Name</form:label>
            <form:input path="customerInformation.firstName" id="firstName"  type="text" value="${customerInformation.firstName}" />

            <form:label path="customerInformation.lastName">last Name</form:label>
            <form:input path="customerInformation.lastName" id="lastName" type="text" value="${customerInformation.lastName}" />

            <form:label path="customerInformation.country">country</form:label>
            <form:input path="customerInformation.country" type="text" value="${customerInformation.country}" />

            <form:label path="customerInformation.state">state</form:label>
            <form:input path="customerInformation.state" type="text" value="${customerInformation.state}" />

            <form:label path="customerInformation.city">city</form:label>
            <form:input path="customerInformation.city" type="text" value="${customerInformation.city}" />

            <form:label path="customerInformation.street">street</form:label>
            <form:input path="customerInformation.street" type="text" value="${customerInformation.street}" />

            <form:label path="customerInformation.zip">zip</form:label>
            <form:input path="customerInformation.zip" type="text" value="${customerInformation.zip}" />

            <form:label path="customerInformation.phone">phone</form:label>
            <form:input path="customerInformation.phone" type="number" value="${customerInformation.phone}" />

            <hr>    
            <form:checkbox  path="check" value="" id="myCheck"  onclick="myFunction()" checked="checked"/> h dieu8unsh apostolhs 8es na einai idia me thn dieu8unsh tou customer information????
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

            <!--            piswtikh <form:radiobutton path="payment" value="1" onclick="showCardInformation();"/>  -->
            piswtikh <form:radiobutton path="payment" value="1" onclick="showCardInformation();" id="show"/>  
            xrewstikh <form:radiobutton path="payment" value="2" onclick="show1();" checked="checked"/> 



            <input type="submit" value="Submit"/>
        </form:form>
        <!--            gia thn pop up payment forma-->
        <div id="showPopupForm" class="hide">
            <div class="center hideform">
                <button id="close" style="float: right;">X</button>
                <form:form action="order/card" method="POST" modelAttribute="customerCreditCard">
                    <a href="#" onclick="showPaymentCardInformation();"> Add new Card</a>
                </form:form>
            </div>
        </div>

        <div id="cardPaymentForm" class="hide">
            <div class="center hideform">
                <button id="closePaymentForm" style="float: right;">X</button>               
                <form:form action="order/cardInfo" method="POST" modelAttribute="customerCreditCard">
                    First name:<br>
                    <form:input path="ownerFirstName" type="text" name="firstname" value="Mickey"/>
                    <br>
                    Last name:<br>
                    <form:input path="ownerLastName"  type="text" name="lastname" value="Mouse"/>
                    <br><br>
                    <input type="submit" value="Submit"/>
                </form:form>

            </div>
        </div>


        <script>
            //otan patame ta radio button to ena den emfanizei tipota enw to allo mas emafanizei to CustomerCreditCard pop up
            function show1() {
                document.getElementById('showPopupForm').style.display = 'none';
            }
            function showCardInformation() {
                document.getElementById('showPopupForm').style.display = 'block';
                document.getElementById('cardPaymentForm').style.display = 'none';
            }

            function showPaymentCardInformation() {
                document.getElementById('showPopupForm').style.display = 'none';
                document.getElementById('cardPaymentForm').style.display = 'block';
            }
            //afora thn pop up forma        
            $('#show').on('click', function () {
                $('.center').show();

            })

            $('#close').on('click', function () {
                $('.center').hide();
                $('#show').show();
            })
            $('#closePaymentForm').on('click', function () {
                $('.center').hide();
                $('#show').show();

            })
            //*************************************************************************************************************************************
            function myFunction() {
                var checkBox = document.getElementById("myCheck");
                var text = document.getElementById("text");
                if (checkBox.checked != true) {
                    text.style.display = "block";
                } else {
                    text.style.display = "none";
                }
            }


        </script>
    </body>
</html>
