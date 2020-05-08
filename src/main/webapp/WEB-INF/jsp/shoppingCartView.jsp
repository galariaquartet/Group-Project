<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <script>
//            $(document).ready(function () {
//                $("#quantity").trigger(function () {
//                    alert("changed");
//                    let quantity = $("#quantity").val();
//                    const cartid = $("#cartid").val();
//                    $.ajax({
//                        type: "POST",
//                        url: "updatequantity/" + quantity + "/" + cartid
//
//                });
//            });
//            $(document).ready(function () {
//                $("#quantity").change(function () {
//                    let quantity = $("#quantity").val();
//                    $.ajax({
//                        type: "POST",
//                        url: "updatequantity/" + productId,
//                        data:{"quantity": quantity}  
//                       
//                        success: function (result) {
//                            alert(result);
//                            $("#checkusername").html(result);
//                        }});
//                });
//            });

            $(document).ready(function () {
                $('#quantity').keydown(function () {
                    var username = $("#username").val();
                    $.ajax({
                        type: "POST",
                        url: "updatequantity/" + quantity,
                        data:{"quantity": quantity} 
                        success: function (result) {
                            alert(result);
                         //   $("#checkusername").html(result);
                        }});
                });
            });
//            $(document).ready(function () {
//                $("#quantity").on('keydown','input',function () {
//                    let quantity = $("#quantity").val();
//                    $.ajax({
//                        type: "POST",
//                        url: "updatequantity/" + productId,
//                        data:{"quantity": quantity}  
//                       
//                        success: function (result) {
//                            alert(result);
//                            $("#checkusername").html(result);
//                        }});
//                });
//            });

        </script>
    </head>
    <body>
        <h1>shopping cart</h1>
        <div align="center">
            <br/>
            <br/>
            
                      <table border='1' cellpadding="10">
                <thead>
                    <tr>
                        <th>shoppingCartId</th>
                        <th>quantity</th>
                        <th>edit quantity</th>
                        <th>productID</th>
                        <th>product Stock</th>
                        <th>customerId</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="sc" items="${shoppingCart}">
                        <tr>
                            <!--                            edw bazoume tis metablhtes akribws pou antistoixoun sto entity-->
                            <td>${sc.shoppingCartId}</td>
                            <td>${sc.quantity}</td>
                            <td><input type="number" id="quantity" name="quantity" value="${sc.quantity}" min="1" max="${sc.productId.productStock}"  /></td>
                            <td>${sc.productId}</td>
                            <td>${sc.productId.productStock}</td>
                            <td>${sc.customerId}</td>
                            
                            <td>

                                <a href="/deleteShoppingCart/${sc.shoppingCartId}">Delete product from shopping cart</a>
                            </td>   
                        </tr>
                    </tbody>
                </c:forEach>
<!--                  <a href="/customerInformation">tameio</a>-->
                   <a href="/order">tameio</a>
    
                         
            </table>
            
  

    </body>
</html>
