<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/order.css">

        <script
            src="https://code.jquery.com/jquery-2.2.4.js"
            integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
        crossorigin="anonymous"></script>

        <style>

            .hide {
                display: none;
            }


            .center {
                margin: auto;
                width: min-content;
                padding: 20px;
                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
            }
            .center1 {
                margin: auto;

            }

            body{font:14px Arial, Helvetica, sans-serif;}
            .formSection{padding:10px;margin-bottom:10px;border:2px solid #ccc;transition: background 0.4s ease; }
            .formSection *{transition: opacity 0.4s ease;}
            label, input, button{display:block;margin:5px;}
            input{background:transparent;border:1px solid #ccc;padding:2px 1px;color: white;}
            label{padding-left:2px;font-weight:bold;font-size:12px;text-transform:uppercase;}

            .actionButtons{margin:5px 5px 0;}
            .cancelButton{margin-right:10px; color:#666;font-weight:bold;text-decoration:none;}
            .saveButton{display:inline-block;padding:8px 16px;background:#9db0a3;color:#fff;border:2px solid #fff;cursor:pointer;transition: background 0.4s ease;}
            .saveButton:hover,.editButton:hover{background:#849589;}
            .editButton{display:none;margin-top:10px;padding:8px 16px;background:#9db0a3;color:#fff;border:2px solid #fff;transition: background 0.4s ease;}


            .formSection.readOnly {background:#BE1629;}
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
        <header id="header">
            <nav class="headernav">
                <ul class="nav-links">
                    <li><a href="/aboutUs"> About us </a></li>
                    <li><a href="/preGame"> Game </a></li>
                    <li><a href="/products"> Shop </a></li>
                    <li><a href="/contact"> Contact </a></li>
                </ul>
                <ul class="nav-links">
                    <li><a href="/account"><img class="acount_icon" src="https://i.ibb.co/ydgtt5p/acount.png"></a></li>
                    <li><a href="/shoppingCart"><img class="basket_icon" src="https://i.ibb.co/Fkr4Ddv/basket4.png"></a></li>
                </ul>
            </nav>
            <div id="logo" class="mask">
                <span class="logo-text masked"><a href="/home"><img src="https://i.ibb.co/87qghMy/LOGO33.png"></a></span>
            </div> 
        </header>
        <div class="ShopingCart_countainer">
            <div class="space"></div>

            <div class="shoping-cart-nav">

                <div>Shopping Cart</div>
                <div>Checkout</div>
                <div>Order Complete</div>

            </div>
            <div class="row">
                <div class="shiping_checkout">

                    <div class="formSection readOnly">

                        <form:form method="POST" action="/saveChangesToCustomerInfo/${checkedproducts}/${totalPrice}" modelAttribute="customerInformation"  >
                            <form:input path="customerId" type="hidden" value=""/>

                            <form:label path="firstName">First Name</form:label>
                            <form:input path="firstName" id="firstName"  type="text" value="${customerInformation.firstName}" disabled="true"/>
                            <form:errors path="firstName" />

                            <form:label path="lastName">Last Name</form:label>
                            <form:input path="lastName" id="lastName" type="text" value="${customerInformation.lastName}" disabled="true" />

                            <form:label path="country">Country</form:label>
                            <form:input path="country" type="text" value="${customerInformation.country}" disabled="true"/>

                            <form:label path="state">State</form:label>
                            <form:input path="state" type="text" value="${customerInformation.state}" disabled="true"/>

                            <form:label path="city">City</form:label>
                            <form:input path="city" type="text" value="${customerInformation.city}" disabled="true"/>

                            <form:label path="street">Street</form:label>
                            <form:input path="street" type="text" value="${customerInformation.street}" disabled="true"/>

                            <form:label path="zip">ZIP</form:label>
                            <form:input path="zip" type="text" value="${customerInformation.zip}" disabled="true"/>

                            <form:label path="phone">Phone</form:label>
                            <form:input path="phone" type="number" value="${customerInformation.phone}" disabled="true"/>

                            <button type="button" class="editButton">Edit</button>
                            <div class="actionButtons">
                                <a href="#" class="cancelButton">Cancel</a>
                                <form:button class="saveButton" type="submit">Save</form:button>
                                </div>
                        </form:form>
                    </div>
                </div>
                <div class="order_checout">     

                    <form:form method="POST" action="/process/${checkedproducts}/${totalPrice}" modelAttribute="sicipDTO"  >


                        <hr>    
                        <form:checkbox  path="check" value="" id="myCheck"  onclick="myFunction()" checked="checked"/>Unckeck to use a different shipping address
                        <!--            <input path="check" type="checkbox" id="myCheck"  onclick="myFunction()">-->
                        <div id="text" style="display:none">
                            <hr>
                            <form:input path="shippingInformation.shippingInformationId" type="hidden" value=""/>

                            <form:label path="shippingInformation.shippingCountry">Shipping Country</form:label>
                            <form:input path="shippingInformation.shippingCountry" type="text"/>

                            <form:label path="shippingInformation.shippingState">Shipping State</form:label>
                            <form:input path="shippingInformation.shippingState" type="text"/>

                            <form:label path="shippingInformation.shippingCity">Shipping City</form:label>
                            <form:input path="shippingInformation.shippingCity" type="text"/>

                            <form:label path="shippingInformation.shippingStreet">Shipping Street</form:label>
                            <form:input path="shippingInformation.shippingStreet" type="text"/>

                            <form:label path="shippingInformation.shippingZip">Shipping Zip</form:label>
                            <form:input path="shippingInformation.shippingZip" type="text"/>

                            <form:label path="shippingInformation.recipientFirstName">Recipient First Name</form:label>
                            <form:input path="shippingInformation.recipientFirstName" type="text"/>

                            <form:label path="shippingInformation.recipientLastName">Recipient Last Name</form:label>
                            <form:input path="shippingInformation.recipientLastName" type="text"/>

                            <form:label path="shippingInformation.recipientPhone">Recipient Phone</form:label>
                            <form:input path="shippingInformation.recipientPhone" type="number"/>
                        </div>
                    </div>



                    <hr>
                    <div class="payment_radios"> 
                        Credit/Debit Card <form:radiobutton checked="checked" path="payment" value="1" onclick="showCardInformation();" id="show"  />  
                        Pay on delivery <form:radiobutton path="payment" value="2" onclick="show1();" /> </div>


                    <div class="submit_checkout"><input type="submit" value="Submit Order"/></div>


                </form:form>
                <!--            gia thn pop up payment forma-->
                <div id="showPopupForm" class="hide">
                    <div class="center hideform">
                        <button id="close" style="float: right;">X</button>

                        <div class="formSection extraform readOnly">

                            <form:form action="/updateCustomerCreditCard/${checkedproducts}/${totalPrice}" method="POST" modelAttribute="customerCreditCardSavedDataFromDB">
                                <form:input path="cardId" type="hidden" value=""/>
                                <form:label path="ownerFirstName">Owner First Name</form:label>            
                                <form:input path="ownerFirstName" type="text" />

                                <form:label path="ownerLastName">Owner Last Name</form:label>               
                                <form:input path="ownerLastName"  type="text" />

                                <form:label path="cardNumber">Card Number</form:label>
                                <form:input path="cardNumber"  type="text" />

                                <form:label path="cardNumberLastDigits">Card Number Last Digits</form:label>
                                <form:input path="cardNumberLastDigits"  type="text" />

                                <form:label path="cvv">CVV</form:label>
                                <form:input path="cvv"  type="text" />

                                <form:label path="expirationDate">Expiration Date</form:label>
                                <form:input path="expirationDate"  type="text" />
                                <button type="button" class="editButton">Edit</button>
                                <div class="actionButtons">
                                    <a href="#" class="cancelButton">Cancel</a>
                                    <button class="saveButton" type="submit">Save</button>
                                </div>
                            </form:form>
                        </div>

                    </div>
                </div>



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
//                document.getElementById('cardPaymentForm').style.display = 'none';
            }

//            function showPaymentCardInformation() {
//                document.getElementById('showPopupForm').style.display = 'none';
//                document.getElementById('cardPaymentForm').style.display = 'block';
//            }
            //afora thn pop up forma        
            $('#show').on('click', function () {
                $('.center').show();

            })

            $('#close').on('click', function () {
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
