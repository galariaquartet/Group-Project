<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/order.css">

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
         <nav class="headernav">
            <ul class="nav-links">
                <li><a href="/aboutUs"> About us </a></li>
                <li><a href="/preGame"> Game </a></li>
                <li><a href="/products"> Shop </a></li>
                <li><a href="/contact"> Contact </a></li>
                <li><a href="/account"><img class="acount_icon" src="https://i.ibb.co/ydgtt5p/acount.png"></a></li>
                <li><a href="/shoppingCart"><img class="basket_icon" src="https://i.ibb.co/Fkr4Ddv/basket4.png"></a></li>
            </ul>
            <div class="burger" >
                <div class="line1"></div>
                <div class="line2"></div>
                <div class="line3"></div>
            </div>
        </nav>
         <div id="logo" class="mask">
                <span class="logo-text masked"><a href="/home"> <img src="https://i.ibb.co/87qghMy/LOGO33.png"></a></span>
            </div> 
        <div class="ShopingCart_countainer">
            <div class="space"></div>

            <div class="shoping-cart-nav">

                <div>Checkout</div>
                <div><a href="Checkout.html"> Checkout </a></div>
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
                </div>
                
                
                    
            </div>
            <div class="footer">
            <div class="footercontainer">
                <div class="social_footer">

                    <div class="follow_us">Follow us </div>
                    <div class="socials_div">
                    <div class="social_icon"><img src="https://i.ibb.co/1LbHv7c/facebook-icon.png"></div>
                    <div class="social_icon"><img src="https://i.ibb.co/37ymrym/instagram-icons.png"></div>
                    <div class="social_icon"><img src="https://i.ibb.co/P6dSF3w/white-github-icon-813505.png"></div>
                    </div>
                </div>
            </div>
        </div>
            


<script src="${pageContext.request.contextPath}/js/burger.js"></script>

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
                $('.center1').hide();
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