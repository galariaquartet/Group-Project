<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/shoppingCart.css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Cart</title>

        <style>
            * {

                color: white;
            }

            td {
                text-align: center;
            }

            #header {
                margin-bottom: 5%;

            }
        </style>
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

                <div>Shopping Cart</div>
                <div>Checkout</div>
                <div>Order Complete</div>
            </div>


            <div align="center">
                <br/>
                <br/>
                <table style="width: 100%" cellpadding="10">
                    <thead>
                        <tr>
                            <th><input id="parent" type="checkbox" onClick="checkAll(this)"></th>
                            <th>Image</th>
                            <th>Product Name</th>
                            <th>Product Color</th>
                            <th>Product Size</th>
                            <th>quantity</th>
                            <th>Product Price</th>
                            <th>price</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="sc" items="${shoppingCart}">
                            <tr style="border-bottom:1px solid white;">
                                <th style="border:none" ><input type="checkbox" name="child" value="${sc.shoppingCartId}" onclick="parentCheckbox(); updatePrice(this, ${sc.quantity*sc.productId.productPrice});"></th>
                                <td>
                                    <c:forEach var = "s" items="${sc.productId.productImageList}">
                                        <img src="${s.productFilepath}" height="75px" width="75px" />
                                    </c:forEach>
                                </td>
                                <td>${sc.productId.productName}</td>
                                <td>${sc.productId.colorId.colorName}</td>
                                <td>${sc.productId.sizeId.sizeName}</td>
                                <td>
                                    <input type="number" name="newquantity" value="${sc.quantity}" min="1" max="${sc.productId.productStock}" 
                                           onchange="updateQuantity(${sc.shoppingCartId}, value)">
                                </td>
                                <td>${sc.productId.productPrice}&euro;</td>
                                <td style="font-weight: bold;">${sc.quantity*sc.productId.productPrice}<span>&euro;</span></td>
                            </tr>
                        </c:forEach>

                    </tbody>
                    <form id="update" action="#" method="POST"></form>
                    <form id="checkoutForm" action="#" method="POST"></form>
                    <form id="deleteForm" action="#" method="POST"></form>
                </table>
                <div class="total_price_SC">
                    <span>Total Price: </span>
                    <span id="totalPrice">0</span>&euro;
                </div>
                <hr style="margin-top: 3%">
                <div style="color: red; text-align: center;" id="error"></div>

                <br>
                <div class="SC_button_L">
                    <button id="checkout"  type="submit" value="Submit">Proced to Payment</button>
                    <button id="delete" value="Delete">Delete</button>
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
        </div>

    </body>

    <script>

        window.addEventListener("pageshow", function (event) {
            var historyTraversal = event.persisted ||
                    (typeof window.performance !== "undefined" &&
                            window.performance.navigation.type === 2);
            if (historyTraversal) {
                window.location.reload();
            }
        });

        const checkoutButton = document.querySelector("#checkout");
        const deleteButton = document.querySelector("#delete");
        const error = document.querySelector("#error");
        const checkboxes = document.getElementsByName('child');
        const totalPricePrint = document.querySelector("#totalPrice");
        let totalPrice = 0;

        function updatePrice(source, price) {
            if (source.checked) {
                totalPrice += price;
            } else {
                totalPrice -= price;
            }
            totalPricePrint.innerHTML = totalPrice.toFixed(2);
        }

        function parentCheckbox() {
            let allchecked = true;
            for (var i = 0, n = checkboxes.length; i < n; i++) {
                if (!checkboxes[i].checked) {
                    allchecked = false;
                }
            }
            if (allchecked) {
                document.getElementById("parent").checked = true;
            } else {
                document.getElementById("parent").checked = false;
            }
        }

        function checkAll(source) {
            for (var i = 0, n = checkboxes.length; i < n; i++) {
                checkboxes[i].checked = source.checked;
            }
            totalPrice = 0;
            if (source.checked) {
        <c:forEach var="sc" items="${shoppingCart}">
                totalPrice += ${sc.quantity*sc.productId.productPrice};
        </c:forEach>
            } else {
                totalPrice = 0;
            }
            totalPricePrint.innerHTML = totalPrice.toFixed(2);
        }

        function updateQuantity(cartid, value) {
            const update = document.getElementById('update');
            update.action = "/updatequantity/" + cartid + "/" + value;
            update.submit();
        }

        checkoutButton.addEventListener("click", () => {
            const products = document.querySelectorAll('input[type="checkbox"]:checked');
            if (products.length === 0) {
                error.innerHTML = "You haven't selected any product";
                return false;
            }
            let checkedproducts = [];
            products.forEach((product) => {
                if (product.value !== 'on') {
                    checkedproducts.push(product.value);
                }
            });
            const checkoutForm = document.querySelector("#checkoutForm");
            checkoutForm.action = "/order/" + checkedproducts + "/" + totalPrice;
            checkoutForm.submit();
        });

        deleteButton.addEventListener("click", () => {
            const products = document.querySelectorAll('input[type="checkbox"]:checked');
            if (products.length === 0) {
                error.innerHTML = "You haven't selected any product";
                return false;
            }
            let checkedproducts = [];
            products.forEach((product) => {
                if (product.value !== 'on') {
                    checkedproducts.push(product.value);
                }
            });
            const deleteForm = document.querySelector("#deleteForm");
            deleteForm.action = "/deleteShoppingCart/" + checkedproducts;
            deleteForm.submit();
        });

    </script> 

</html>
