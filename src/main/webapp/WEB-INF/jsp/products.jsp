<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style_shop.css">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>
        <!--        <style>
                    select {
                        all: initial;
                        * {
                            all: unset;
                        }
                        background-color: white;
                        color: white;
                    }
                    option {
                        background-color: black;
                    }
                </style>-->
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

        <div id="shop_countainer">
            <div style="height: 6rem;" class="space"></div>
            <div class="shop_top_bar">
                <div class="filter_button">
                    <span class="mobile_only">Sort by</span>
                    <div class="filters"> 
                        <span>Sort by:&nbsp;&nbsp;&nbsp; </span>
                        <label for="price">Price: <span id="selected_price">1500</span>&euro;&nbsp;&nbsp;</label>
                        <input id="price" type="range" min=5 max=1500 value=1500 step=10>
                        <label for="gender">:&nbsp;&nbsp;&nbsp;Gender:&nbsp;&nbsp;</label>
                        <select id="gender">
                            <option value="0" selected>All</option>
                            <option value="1" >Male</option>
                            <option value="2">Female</option>
                            <option value="3">Unisex</option>
                        </select>
                        <label for="subcategory">&nbsp;&nbsp;Categories: &nbsp;&nbsp;</label>
                        <select id="subcategory">
                            <option value="0" selected>All</option>
                            <optgroup label="Clothes">
                                <option value="1">TShirt</option>
                                <option value="2">Sweatshirt</option>
                                <option value="3">Jacket</option>
                            </optgroup>
                            <optgroup label="Accessories">
                                <option value="4">Keychain</option>
                            </optgroup>
                        </select>
                    </div>
                    <div class="burger_shoppage" >
                        <div class="line1"></div>
                        <div class="line2"></div>
                        <div class="line3"></div>
                    </div>
                </div>
            </div>

            <div class="custom-menu">
                <ul class="custom-menu-list" >
                    <li class="custom-menu-li " id="cat"><label for="price">Price: <span id="selected_price">100</span>&euro;</label>
                        <input id="price" type="range" min=5 max=100 value=100 step=5></li>
                    <li class="custom-menu-li " id="cat"><label for="gender">Gender:</label>
                        <select id="gender">
                            <option value="1" selected>Male</option>
                            <option value="2">Female</option>
                            <option value="3">Unisex</option>
                        </select></li>

                    <li class="custom-menu-li" id="cat"><label for="subcategory">Categories:</label>
                        <select id="subcategory">
                            <option value="0" selected>All</option>
                            <optgroup label="Clothes">
                                <option value="1">TShirt</option>
                                <option value="2">Sweatshirt</option>
                                <option value="3">Jacket</option>
                            </optgroup>
                            <optgroup label="Accessories">
                                <option value="4">Keychain</option>
                            </optgroup>
                        </select></li>
                    <li class="custom-menu-li" id="cat">OTHER</li>
                </ul>
            </div>
            <div id="categories_menu"></div>
            <div id="products" class="products_container"></div>
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

    </body>
    <script src="${pageContext.request.contextPath}/js/burger.js"></script>
    <script src="${pageContext.request.contextPath}/js/burger_shop.js"></script>

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
        let filteredProducts = [];
        let counter = 0;

        function getProducts(data) {
            for (let i = 0; i < data.length; i++) {
                allproducts.push(data[i]);
                filteredProducts.push(data[i]);
            }
            displayProducts();
        }

        let selectedColors = [];
        const productsBox = document.querySelector("#products");
        let colorsPerProduct = new Set();

        function displayProducts() {
            productsBox.innerHTML = "";
            let productsOutput = "";
            for (let i = 0; i < filteredProducts.length; i++) { // allproducts.length μας δείχνει τον αριθμό των ΕΝΤΕΛΩΣ διαφορετικών προϊόντων  
                if (filteredProducts[i].length < 1) {
                    continue;
                }
                productsOutput = "";
                // Name Section
                productsOutput += `
                <div class="product product_container btn">`;
                // Get's all the available colors
                colorsPerProduct.clear();
                for (let j = 0; j < filteredProducts[i].length; j++) {
                    colorsPerProduct.add(filteredProducts[i][j].colorId.colorName);
                }
                // Image Section
                productsOutput += `<div id="images\${i}" class="product_image"></div></a>`;
                productsOutput += `<div class="product_title">\${filteredProducts[i][0].productName}</div>`;
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
                productsOutput += `<p style="text-align: center">Price: \${filteredProducts[i][0].productPrice}&euro;</p></div>`;
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

        // Price filtering
        const price = document.querySelector("#price");
        const selectedPriceVal = document.querySelector("#selected_price");
        price.addEventListener("input", handlePriceInput);
        price.addEventListener("change", handlePriceChange);
        let selectedPrice = 1500;

        function handlePriceInput(event) {
            selectedPriceVal.innerText = event.target.value;
        }
        function handlePriceChange(event) {
            selectedPrice = parseInt(event.target.value);
            filterProducts();
        }

        function byPrice(product) {
            return product.productPrice <= selectedPrice;
        }

        // Gender Filtering
        const gender = document.querySelector("#gender");
        gender.addEventListener("change", handleGenderChange);
        let selectedGender = 0;

        function handleGenderChange(event) {
            selectedGender = parseInt(event.target.value);
            filterProducts();
        }

        function byGender(product) {
            if (selectedGender === 0) {
                return product.genderId.genderId;
            }
            return product.genderId.genderId === selectedGender;
        }

        //Subcategory Filtering
        const subcategory = document.querySelector("#subcategory");
        subcategory.addEventListener("change", handleSubcategoryChange);
        let selectedSubcategory = 0;

        function handleSubcategoryChange(event) {
            selectedSubcategory = parseInt(event.target.value);
            filterProducts();
        }

        function bySubcategory(product) {
            if (selectedSubcategory === 0) {
                return product.subcategoryId.subcategoryId;
            }
            return product.subcategoryId.subcategoryId === selectedSubcategory;
        }

        // Final Filtering
        function filterProducts() {
            console.log("selected price:", selectedPrice);
            console.log("selected gender:", selectedGender);
            console.log("selected subcategory", selectedSubcategory);
            for (let i = 0; i < allproducts.length; i++) {
                filteredProducts[i] = allproducts[i].filter(function (product) {
                    return byPrice(product) && byGender(product) && bySubcategory(product);
                });
            }
            console.log("All products: ", allproducts);
            console.log("Filtered products: ", filteredProducts);
            displayProducts();
        }

    </script>

</html>
