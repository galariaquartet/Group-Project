<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Details</title>
        <link href="https://fonts.googleapis.com/css?family=Muli:300,400,700,900" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    </head>

    <body>
        <div id="logo" class="mask">
            <span class="logo-text masked"><a href="/home"> <img src="https://i.ibb.co/87qghMy/LOGO33.png"></a></span>
        </div> 
        <nav class="headernav">
            <ul class="nav-links">
                <li><a href="/aboutUs"> About us </a></li>
                <li><a href="/chat"> Game </a></li>
                <li><a href="/products"> Shop</a></li>
                <li><a href="/contact"> Contact </a></li>
                <li><a href="/adminMain"> Admin </a></li>
                <li><a href="/account"><img class="acount_icon" src="https://i.ibb.co/ydgtt5p/acount.png"></a></li>
                <li><a href="/shoppingCart"><img class="basket_icon" src="https://i.ibb.co/Fkr4Ddv/basket4.png"></a></li>
            </ul>
            <div class="burger" >
                <div class="line1"></div>
                <div class="line2"></div>
                <div class="line3"></div>
            </div>
        </nav>
        <div id="Product_Page_countainer">
            <div class="space"></div>
            <div id="product"></div>
            <form id="addTocart" action="#" method="POST"></form>
            <div  id="errorDiv"></div>
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
        fetch("http://localhost:8080/JsonProducts")
                .then(function (response) {
                    return response.json();
                })
                .then(getProducts)
                .catch(function (error) {
                    console.log("Error:", error.message);
                });

        const product = [];
        let productsWithSameColor = [];
        let selectedSize = [];
        const productBox = document.querySelector("#product");
        const errorDiv = document.querySelector("#errorDiv");
        const myForm = document.querySelector("#addTocart");

        let selectedProductId;
        let colorsOfProduct = new Set();
        let sizesOfProduct = new Set();
        let sizesOfColor = [];
        let selectedProductQuantity = 0;

        function getProducts(data) {
            for (let i = 0; i < data[${index}].length; i++) {
                product.push(data[${index}][i]);
            }
            displayProducts();
        }

        function displayProducts() {
            productBox.innerHTML = "";
            let productOutput = "";
            // Name Section
            productOutput += `
               <div class="row">
               <div class="product_image_p">
               `;
            // Image Section
            productOutput += `<div id="image">
                <img style="float: none" src="\${product[0].productImageList[0].productFilepath}" >
                <img style="float: none" src="\${product[0].productImageList[1].productFilepath}" > 
                </div></div>`;
            // Color Section
            productOutput += `<hr><div class="product_info_p">`;
            productOutput += `<div class="product_name"><h1>\${product[0].productName}</h1></div>`;
            // Material Section
            productOutput += `<div id="material" class="product_matirial"><p>Material: \${product[0].materialId.materialName}</p></div>`;
            productOutput += `<div id="colors" style="display: flex; justify-content: flex-start;width:max-content;"><p style:"margin-top:0.2rem;">Colors:</p>`;
            for (let i = 0; i < product.length; i++) {
                colorsOfProduct.add(product[i].colorId.colorName);
                sizesOfProduct.add(product[i].sizeId.sizeName);
            }
            for (let color of colorsOfProduct) {
                productOutput += `
                            <button title="\${color}" class="btn_color_product_details" onclick=productsByColor("\${color}") style="background-color: \${color};" ></button>
                            `;
            }
            productOutput += `</div>`;
            //Size Section
            productOutput += `<div id="size" class="product_size_p" >`;
            for (let size of sizesOfProduct) {
                productOutput += `
                            <button title="\${size}") style="text-align: center; border: 1px solid black; width:35px; height:25px; margin: auto;">\${size}</button>
                            `;
            }
            productOutput += `</div>`;
            //Price Section
            productOutput += `<div id="price" class=".product_price_p"><p >Price: \${product[0].productPrice}&euro;</p></div>`;

            // Quantity Section, Max = productstock, Min = 1
            productOutput += `<div>Quantity: <span id = "quantitySpan"><input type="number" min="0" max="0" /> </span></div>`;

            // Total Price = product price * quantity
            productOutput += `<div class="product_price_p">Total Price: <span id="totalprice">0</span>&euro;</div>`;
            //            productOutput += `<div style="color: white;" id="errorDiv">sadhajhdasjkdhakjdaskd</div>`;
            // Add to Cart Section

            productOutput += `<button class="Add_to_cart_b" onclick="cartFunction()">Add To Cart</button>`;
            productOutput += `</div></div>`; // Outer Div
            productBox.innerHTML = productOutput;
        }

        function productsByColor(color) {
            const totalPriceSpan = document.querySelector("#totalprice");
            selectedProductId = undefined;
            errorDiv.innerHTML = "";
            totalPriceSpan.innerHTML = 0;
            selectedProductQuantity = 0;
            const imageDiv = document.querySelector("#image");
            const sizeDiv = document.querySelector("#size");
            let sizeOutput = "";
            productsWithSameColor = [];
            sizesOfColor = [];
            imageDiv.innerHTML = "";
            sizeDiv.innerHTML = "";
            for (let i = 0; i < product.length; i++) {
                if (product[i].colorId.colorName === color) {
                    productsWithSameColor.push(product[i]);
                }
            }
            for (let j = 0; j < productsWithSameColor.length; j++) {
                if (productsWithSameColor[j].productStock > 0) {
                    sizesOfColor.push(productsWithSameColor[j]);
                    sizeOutput += `<button title="\${productsWithSameColor[j].sizeId.sizeName}" onclick="finalProduct(\${productsWithSameColor[j].productId})" style="text-align: center; border: 1px solid black; width:35px; height:25px; margin: auto;">\${productsWithSameColor[j].sizeId.sizeName}</button>
                            `;
                } else {
                    sizeOutput += `<button disabled title="\${productsWithSameColor[j].sizeId.sizeName}" style="text-align: center; border: 1px solid black; width:35px; height:25px; margin: auto;">\${productsWithSameColor[j].sizeId.sizeName}</button>
                            `;
                }
            }

            imageDiv.innerHTML = `
                <img style="float: none" src="\${productsWithSameColor[0].productImageList[0].productFilepath}">
                <img style="float: none" src="\${productsWithSameColor[0].productImageList[1].productFilepath}" >        
            `;
            sizeDiv.innerHTML = sizeOutput;
        }

        function finalProduct(productId) {
            selectedProductQuantity = 0;
            const totalPriceSpan = document.querySelector("#totalprice");
            totalPriceSpan.innerHTML = 0;
            let tempProduct;
            const quantitySpan = document.querySelector("#quantitySpan");
            errorDiv.innerHTML = "";
            selectedProductId = productId;
            for (let k2 = 0; k2 < product.length; k2++) {
                if (product[k2].productId === productId) {
                    tempProduct = product[k2];
                }
            }
            quantitySpan.innerHTML = `<input type="number" onchange="finalProductQuantity(this)"  min="1" max="\${tempProduct.productStock}" />`;
        }

        function finalProductQuantity(source) {
            errorDiv.innerHTML = "";
            const totalPriceSpan = document.querySelector("#totalprice");
            selectedProductQuantity = source.value;
            const totalPrice = product[0].productPrice * selectedProductQuantity;
            totalPriceSpan.innerHTML = totalPrice.toFixed(2);
        }

        function cartFunction() {

            if (typeof selectedProductId === "undefined") {
                errorDiv.innerHTML = "*You have to select a product first";
            } else if (selectedProductQuantity === 0) {
                errorDiv.innerHTML = "*You have to select a quantity first";
            } else {
                console.log("Final Product ID ", selectedProductId);
                console.log("Final Product Quantity ", selectedProductQuantity);
                myForm.action = "/addToCart/" + selectedProductId + "/" + selectedProductQuantity;
                myForm.submit();
            }
        }

    </script>

</html>


