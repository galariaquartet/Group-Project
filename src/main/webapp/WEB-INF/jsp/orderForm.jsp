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



            body{font:14px Arial, Helvetica, sans-serif;}
            .formSection{padding:10px;margin-bottom:10px;border:2px solid #ccc;transition: background 0.4s ease;}
            .formSection *{transition: opacity 0.4s ease;}
            label, input, button{display:block;margin:5px;}
            input{background:transparent;border:1px solid #ccc;padding:2px 1px;}
            label{padding-left:2px;font-weight:bold;font-size:12px;text-transform:uppercase;}

            .actionButtons{margin:5px 5px 0;}
            .cancelButton{margin-right:10px; color:#666;font-weight:bold;text-decoration:none;}
            .saveButton{display:inline-block;padding:8px 16px;background:#9db0a3;color:#fff;border:2px solid #fff;cursor:pointer;transition: background 0.4s ease;}
            .saveButton:hover,.editButton:hover{background:#849589;}
            .editButton{display:none;margin-top:10px;padding:8px 16px;background:#9db0a3;color:#fff;border:2px solid #fff;transition: background 0.4s ease;}


            .formSection.readOnly {background:#e5f6ea;}
            input[disabled]{color:#000;border-color:transparent;}
            .readOnly .actionButtons{display:none;}
            .readOnly .editButton{display:block;cursor:pointer;}

            .formSection.disabled *{opacity:.5;}
            .disabled .editButton{display:block;cursor:default;}
            .disabled .editButton:hover{background:#9db0a3;}


        </style>

        <script>
            $(document).ready(function () {
                $("#firstName").focusout(function () {
                    var firstName = $("#firstName").val();
                    $.ajax({
                        type: "POST",
                        url: "/order/checkemail/" + firstName,
                        data: {input: $('#firstName').val(),
                            input: $('#lastName').val()}
                    });
                });
            });
        </script>

    </head>
    <body>

        <div class="formSection readOnly">

            <form:form method="POST" action="/saveChangesToCustomerInfo/${checkedproducts}" modelAttribute="customerInformation"  >
                <form:input path="customerId" type="hidden" value=""/>


                <form:label path="firstName">first Name</form:label>
                <form:input path="firstName" id="firstName"  type="text" value="${customerInformation.firstName}" disabled="true"/>

                <form:label path="lastName">last Name</form:label>
                <form:input path="lastName" id="lastName" type="text" value="${customerInformation.lastName}" disabled="true" />

                <form:label path="country">country</form:label>
                <form:input path="country" type="text" value="${customerInformation.country}" disabled="true"/>

                <form:label path="state">state</form:label>
                <form:input path="state" type="text" value="${customerInformation.state}" disabled="true"/>

                <form:label path="city">city</form:label>
                <form:input path="city" type="text" value="${customerInformation.city}" disabled="true"/>

                <form:label path="street">street</form:label>
                <form:input path="street" type="text" value="${customerInformation.street}" disabled="true"/>

                <form:label path="zip">zip</form:label>
                <form:input path="zip" type="text" value="${customerInformation.zip}" disabled="true"/>

                <form:label path="phone">phone</form:label>
                <form:input path="phone" type="number" value="${customerInformation.phone}" disabled="true"/>

                <button type="button" class="editButton">Edit</button>
                <div class="actionButtons">
                    <a href="#" class="cancelButton">Cancel</a>
                    <button class="saveButton" type="submit">Save</button>
                </div>
            </form:form>
        </div>


        <form:form method="POST" action="/process/${checkedproducts}" modelAttribute="sicipDTO"  >


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
                <form:form action="/card/${checkedproducts}" method="POST" modelAttribute="customerCreditCard">
                    <a href="#" onclick="showPaymentCardInformation();"> Add new Card</a>
                </form:form>
            </div>
        </div>

        <div id="cardPaymentForm" class="hide">
            <div class="center hideform">
                <button id="closePaymentForm" style="float: right;">X</button>               
                <form:form action="/cardInfo/${checkedproducts}" method="POST" modelAttribute="customerCreditCard">

                    <form:label path="ownerFirstName">ownerFirstName</form:label>            
                    <form:input path="ownerFirstName" type="text" />

                    <form:label path="ownerLastName">ownerLastName</form:label>               
                    <form:input path="ownerLastName"  type="text" />

                    <form:label path="cardNumber">cardNumber</form:label>
                    <form:input path="cardNumber"  type="text" />

                    <form:label path="cardNumberLastDigits">cardNumberLastDigits</form:label>
                    <form:input path="cardNumberLastDigits"  type="text" />

                    <form:label path="cvv">cvv</form:label>
                    <form:input path="cvv"  type="text" />

                    <form:label path="expirationDate">expirationDate</form:label>
                    <form:input path="expirationDate"  type="text" />

                    <br><br>
                    <input type="submit" value="Submit"/>
                </form:form>

            </div>
        </div>

        ${checkedproducts};


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

        <script>
            var oldValues = null;

            $(document)
                    .on("click", ".editButton", function () {

                        var section = $(this).closest(".formSection");
                        var otherSections = $(".formSection").not(section);
                        var inputs = section.find("input");

                        section
                                .removeClass("readOnly");

                        otherSections
                                .addClass("disabled")
                                .find('button').prop("disabled", true);

                        oldValues = {};
                        inputs
                                .each(function () {
                                    oldValues[this.id] = $(this).val();
                                })
                                .prop("disabled", false);
                    })

                    .on("click", ".cancelButton", function (e) {

                        var section = $(this).closest(".formSection");
                        var otherSections = $(".formSection").not(section);
                        var inputs = section.find("input");

                        section
                                .addClass("readOnly");

                        otherSections
                                .removeClass("disabled");

                        $('button').prop("disabled", false);

                        inputs
                                .each(function () {
                                    $(this).val(oldValues[this.id]);
                                })
                                .prop("disabled", true)

                        e.stopPropagation();
                        e.preventDefault();
                    });

        </script>
    </body>
</html>
