<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Cart</title>
    </head>
    <body>
        <h1 style="text-align: center">shopping cart</h1>
        <div align="center">
            <br/>
            <div id="error"></div>
            <br/>
            <table border='1' cellpadding="10">
                <thead>
                    <tr>
                        <th><input id="parent" type="checkbox" onClick="checkAll(this)"></th>
                        <th>shoppingCartId</th>
                        <th>quantity</th>
                        <th>productID</th>
                        <th>Product Price</th>
                        <th>customerId</th>
                        <th>price</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="sc" items="${shoppingCart}">
                        <tr>
                            <th><input type="checkbox" name="child" value="${sc.shoppingCartId}" onclick="parentCheckbox(); updatePrice(this, ${sc.quantity*sc.productId.productPrice});"></th>
                            <td>${sc.shoppingCartId}</td>
                            <td>
                                <input type="number" name="newquantity" value="${sc.quantity}" min="1" max="${sc.productId.productStock}" 
                                       onfocusout="updateQuantity(${sc.shoppingCartId}, value)">
                            </td>
                            <td>${sc.productId}</td>
                            <td>${sc.productId.productPrice}</td>
                            <td>${sc.customerId}</td>
                            <td>${sc.quantity*sc.productId.productPrice}</td>
                        </tr>
                    </c:forEach>
                <th>Total Price</th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th><span id="totalPrice">0</span>&euro;</th>
                </tbody>
                <form id="update" action="#" method="POST"></form>
                <form id="checkoutForm" action="#" method="POST"></form>
                <form id="deleteForm" action="#" method="POST"></form>
            </table>
            <br>
            <button id="checkout" type="submit" value="Submit">Checkout</button>
            <button id="delete" value="Delete">Delete</button>
    </body>

    <script>
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
            totalPricePrint.innerHTML = totalPrice;
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
            totalPricePrint.innerHTML = totalPrice;
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
            checkoutForm.action = "/order/" + checkedproducts;
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
