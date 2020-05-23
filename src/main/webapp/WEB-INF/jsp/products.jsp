<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style_shop.css">
        <script src="${pageContext.request.contextPath}/js/shop.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>
    </head>
    <body>

        <header id="header">
            <nav class="headernav">
                <ul class="nav-links">
                    <li><a href="/aboutUs"> About us </a></li>
                    <li><a href="#"> Game </a></li>
                    <li><a href="#"> Shop </a></li>
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

        <div id="shop_countainer">
            <div class="space"></div>
            <div class="shop_top_bar">
                <div class="filter_button">
                    <span>Sort by</span>
                    <div class="burger_shoppage" >
                        <div class="line1"></div>
                        <div class="line2"></div>
                        <div class="line3"></div>
                    </div>
                </div>
            </div>

            <div class="custom-menu">
                <ul class="custom-menu-list" >
                    <li class="custom-menu-li " id="cat1">CLOTHES</li>
                    <li class="custom-menu-li proionta-item" id="cat2">ACCESSORIES<span><button onclick="toggleSubMenu()" class="plusmenubuttom" >+</button></span>
                        <ul class="custom-sub-menu" style="display: none;">
                            <li class="custom-menu-li" style="margin-bottom: 0;">BOARD GAMES</li>
                            <li class="custom-menu-li" style="margin-bottom: 0;">OTHER</li>
                        </ul>
                    </li>
                    <li class="custom-menu-li" id="cat3">BOARD GAMES</li>
                    <li class="custom-menu-li" id="cat4">OTHER</li>
                </ul>
            </div>
            <div id="categories_menu"></div>
            <div id="products" class="products_container"></div>
        </div>
        <div class="footer">
            <div class="footercontainer">
                <div class="social_footer">

                    <div class="follow_us">Follow us </div>
                    <div class="social_icon"><img src="https://i.ibb.co/1LbHv7c/facebook-icon.png"></div>
                    <div class="social_icon"><img src="https://i.ibb.co/37ymrym/instagram-icons.png"></div>
                    <div class="social_icon"><img src="https://i.ibb.co/P6dSF3w/white-github-icon-813505.png"></div>
                </div>
            </div>
        </div>

    </body>

    <script>
        fetch("http://localhost:8084/JsonProducts")
                .then(function (response) {
                    return response.json();
                })
                .then(getProducts)
                .catch(function (error) {
                    console.log("Error:", error.message);
                });

        const allproducts = [];
        let counter = 0;

        function getProducts(data) {
            for (let i = 0; i < data.length; i++) {
                allproducts.push(data[i]);
            }
            displayProducts();
        }

        let selectedColors = [];
        const productsBox = document.querySelector("#products");
        let colorsPerProduct = new Set();

        function displayProducts() {
            productsBox.innerHTML = "";
            let productsOutput = "";
            for (let i = 0; i < allproducts.length; i++) { // allproducts.length μας δείχνει τον αριθμό των ΕΝΤΕΛΩΣ διαφορετικών προϊόντων  
                productsOutput = "";
                // Name Section
                productsOutput += `
                <div class="product product_container btn">`;
                // Get's all the available colors
                colorsPerProduct.clear();
                for (let j = 0; j < allproducts[i].length; j++) {
                    colorsPerProduct.add(allproducts[i][j].colorId.colorName);
                }
                // Image Section
                productsOutput += `<div id="images\${i}" class="product_image"></div></a>`;
                productsOutput += `<div class="product_title">\${allproducts[i][0].productName}</div>`;
                // Color Section
                productsOutput += `<hr>`;
                productsOutput += `<div id="colors" style="margin: auto; display: inline-block">`;
                for (let color of colorsPerProduct) {
                    productsOutput += `
                            <button id="btn-color" title="\${color}" onclick=productsByColor("\${color}",\${i});  style="background-color: \${color}; border: none; box-shadow: 0px 0px 3px 1px rgba(255,255,255,1); width:25px; height:25px; margin: auto;"></button>
                            `;
                }
                productsOutput += `</div>`;
                //Price Section
                productsOutput += `<p style="text-align: center">Price: \${allproducts[i][0].productPrice}&euro;</p></div>`;
                productsBox.innerHTML += productsOutput;
                productsByColor(allproducts[i][0].colorId.colorName, i);
            }
        }

        function productsByColor(color, product) {
            counter = 0;
            const imageDiv = document.querySelector("#images" + product);
            imageDiv.innerHTML = "";
            let productIndex;
            for (let j = 0; j < allproducts[product].length; j++) {
                if (allproducts[product][j].colorId.colorName === color) {
                    productIndex = j;
                    break;
                }
            }
            imageDiv.innerHTML += `
                <a style="display: inline-block;
                height: 20rem;" href="productdetails/\${product}"><img style="float: none;" src="\${allproducts[product][productIndex].productImageList[0].productFilepath}" width="150px" height="150px"></a>
                <div style="position: relative;
                z-index: 51;
                margin: auto;
                float: right;
                margin-top: 0.4rem;">        
                <button style="background-color: transparent; border: none;" onclick=carousel(\${product},\${productIndex})><img class="arrow_carousel" src="https://i.ibb.co/RTk18Nw/BELOS-KATO.png " margin="0" "></button>
                </div>   `;
        }

        function carousel(product, productIndex) {
            const imageDiv = document.querySelector("#images" + product);
            counter++;
            imageDiv.innerHTML = `
                <a style="display: inline-block;
                height: 20rem;" href="productdetails/\${product}"><img style="float: none" src="\${allproducts[product][productIndex].productImageList[counter%2].productFilepath}" width="150px" height="150px"></a>
               <div style="position: relative;
                z-index: 51;
                margin: auto;
                float: right;
                margin-top: 0.4rem;">        
                        <button style="background-color: transparent; border: none;" onclick=carousel(\${product},\${productIndex})><img class="arrow_carousel" src="https://i.ibb.co/RTk18Nw/BELOS-KATO.png " margin="0" "></button>
                    </div>   `;
        }

    </script>

</html>
