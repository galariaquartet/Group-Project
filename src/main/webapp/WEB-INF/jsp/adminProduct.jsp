<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Admin_Cat_del_up</title>

        <link href="https://fonts.googleapis.com/css?family=Muli:300,400,700,900" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminMain.css">
    </head>
    <body>
        <header id="header">
            <nav class="headernav">
                <ul class="nav-links">
                    <li><a href="/aboutUs"> About us </a></li>
                    <li><a href="#"> Game </a></li>
                    <li><a href="/products"> Shop </a></li>
                    <li><a href="/contact"> Contact </a></li>
                    <li><a href="/adminMain"> Admin </a></li>
                </ul>
                <ul class="nav-links">
                    <li><a href="/account"><img class="acount_icon" src="https://i.ibb.co/ydgtt5p/acount.png"></a></li>
                    <li><a href="/shoppingCart"><img class="basket_icon" src="https://i.ibb.co/Fkr4Ddv/basket4.png"></a></li>
                </ul>
            </nav>
            <div id="logo" class="mask">
                <span class="logo-text masked"><a href="/home"> <img src="https://i.ibb.co/87qghMy/LOGO33.png"></a></span>
            </div> 
        </header>
        <div class="space"></div>
        <div class="admin_cat_container">
            <div class="all">
                <h2>Products</h2>
                <br/>
                <a href="/newProduct">Create New Product</a>
                <table border='1' cellpadding="10">
                    <thead>
                        <tr>
                            <th>Product Name</th>
                            <th>Product Stock</th>
                            <th>Product Price</th>
                            <th>Product Color</th>
                            <th>Product GenderId</th>
                            <th>Product Material</th>
                            <th>Product Size</th>
                            <th>Product SubCategory</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="p" items="${productList}">  
                            <tr>

                                <td>${p.productName}</td>
                                <td>${p.productStock}</td>
                                <td>${p.productPrice}</td>
                                <td>${p.colorId.colorName}</td>
                                <td>${p.genderId.genderName}</td>
                                <td>${p.materialId.materialName}</td>
                                <td>${p.sizeId.sizeName}</td>
                                <td>${p.subcategoryId.subcategoryName}</td>
                                <td>
                                    <a href="/editProduct/${p.productId}">Edit</a>
                                    <a href="/deleteProduct/${p.productId}">Delete</a>
                                </td>   
                            </tr>
                        </tbody>
                    </c:forEach>
                </table>
            </div>
        </div>


        <div class="footer">
            <div class="footercontainer">
                <div class="social_footer">
                    <div class="social_footer">
                        <div class="follow_us">Follow us </div>
                        <div class="social_icon"><img src="https://i.ibb.co/1LbHv7c/facebook-icon.png"></div>
                        <div class="social_icon"><img src="https://i.ibb.co/37ymrym/instagram-icons.png"></div>
                        <div class="social_icon"><img src="https://i.ibb.co/P6dSF3w/white-github-icon-813505.png"></div>
                    </div>
                </div>

            </div>
            <script src="${pageContext.request.contextPath}/js/main.js"></script>

    </body>
</html>

