<%-- 
    Document   : productdetails
    Created on : May 18, 2020, 3:48:43 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Details Page</title>

        <style>
            .product {
                width: 60%;
                border: 1px solid gray;
                padding: 10px;
                margin: 10px;
                box-shadow: 6px 6px 16px rgba(0, 0, 0, 0.3)
            }
        </style>

    </head>

    <body>

        <div id="product"></div>
        <form id="addTocart" action="#" method="POST"></form>
        <div id="errorDiv"></div>

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
               <div class="product">
               <p style="text-align: center">Product Name: \${product[0].productName}</p>`;
            // Image Section
            productOutput += `<div id="image">
                <img style="float: none" src="\${product[0].productImageList[0].productFilepath}" width="150px" height="150px">
                <img style="float: none" src="\${product[0].productImageList[1].productFilepath}" width="150px" height="150px"> 
                </div>`;
            // Color Section
            productOutput += `<hr>`;
            productOutput += `<div id="colors" style="margin: auto; display: inline-block">`;
            for (let i = 0; i < product.length; i++) {
                colorsOfProduct.add(product[i].colorId.colorName);
                sizesOfProduct.add(product[i].sizeId.sizeName);
            }
            for (let color of colorsOfProduct) {
                productOutput += `
                            <button title="\${color}" onclick=productsByColor("\${color}") style="background-color: \${color}; border: 1px solid black; width:25px; height:25px; margin: auto;"></button>
                            `;
            }
            productOutput += `</div>`;
            //Size Section
            productOutput += `<div id="size" style="margin-left: 60%; display: inline";>`;
            for (let size of sizesOfProduct) {
                productOutput += `
                            <button title="\${size}") style="text-align: center; border: 1px solid black; width:35px; height:25px; margin: auto;">\${size}</button>
                            `;
            }
            productOutput += `</div>`;
            //Price Section
            productOutput += `<div id="price"><p style="text-align: center">ProductPrice: \${product[0].productPrice}&euro;</p></div>`;
            // Material Section
            productOutput += `<div id="material"><p>Material: \${product[0].materialId.materialName}</p></div>`;
            // Quantity Section, Max = productstock, Min = 1
            productOutput += `<div>Quantity: <span id = "quantitySpan"><input type="number" min="0" max="0" /> </span></div>`;
            


            productOutput += `</div>`; // Outer Div

            // Total Price = product price * quantity

            // Add to Cart Section
            productOutput += `<div>
                    <button onclick="cartFunction()">Add To Cart</button>
                    
                              </div>`;
            productBox.innerHTML = productOutput;
        }

        function productsByColor(color) {
            selectedProductId = undefined;
            errorDiv.innerHTML = "";
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
                <img style="float: none" src="\${productsWithSameColor[0].productImageList[0].productFilepath}" width="150px" height="150px">
                <img style="float: none" src="\${productsWithSameColor[0].productImageList[1].productFilepath}" width="150px" height="150px">        
            `;
            sizeDiv.innerHTML = sizeOutput;
        }

        function finalProduct(productId) {
            let tempProduct;
            const quantitySpan = document.querySelector("#quantitySpan");
            errorDiv.innerHTML = "";
            selectedProductId = productId;
            for (let k2 = 0; k2 < product.length; k2++){
                if(product[k2].productId === productId){
                    tempProduct = product[k2];
                }
            }
            quantitySpan.innerHTML = `<input type="number" min="1" max="\${tempProduct.productStock}" />`;
            console.log("Final Product", productId);
        }

        function cartFunction() {

            if (typeof selectedProductId === "undefined") {
                errorDiv.innerHTML = "You have to select a product first";
            } else {
                console.log("Lets add now");
//                myForm.action = "/addToCart/" + selectedProduct + "/" + quantity;
//                myForm.submit();
            }
        }

        // product is the productIndex in the Json file


        //TODO: Make size buttons change dynamically according to the selected color


    </script>

</html>
<!--An o pinakas filteredProducts exei length == 1, activate add to cart, alliws oxi!-->

