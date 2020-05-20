<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>

        <style>
            .product {
                width: 20%;
                border: 1px solid gray;
                padding: 10px;
                margin: 10px;
                box-shadow: 6px 6px 16px rgba(0, 0, 0, 0.3)
            }
            
            a {
                text-decoration: none;
            }
        </style>
    </head>
    <body>

        <div id="products"></div>

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
                // Name Section
                productsOutput += `
                <div class="product">
                <p style="text-align: center">Product Name: \${allproducts[i][0].productName}</p>`;
                // Get's all the available colors
                colorsPerProduct.clear();
                for (let j = 0; j < allproducts[i].length; j++) {
                    colorsPerProduct.add(allproducts[i][j].colorId.colorName);
                }
                // Image Section
                productsOutput += `<a href="productdetails/\${i}"><div id="images\${i}">
                <img style="float: none" src="\${allproducts[i][0].productImageList[0].productFilepath}" width="150px" height="150px">
                <img style="float: none" src="\${allproducts[i][0].productImageList[1].productFilepath}" width="150px" height="150px"> 
                </div></a>`;
                // Color Section
                productsOutput += `<hr>`;
                productsOutput += `<div id="colors" style="margin: auto; display: inline-block">`;
                for (let color of colorsPerProduct) {
                    productsOutput += `
                            <button title="\${color}" onclick=productsByColor("\${color}",\${i}) style="background-color: \${color}; border: 1px solid black; width:25px; height:25px; margin: auto;"></button>
                            `;
                }
                productsOutput += `</div>`;
                //Price Section
                productsOutput += `<p style="text-align: center">ProductPrice: \${allproducts[i][0].productPrice}&euro;</p></div>`;

            }
            productsBox.innerHTML = productsOutput;
        }

        // product is the productIndex in the Json file
        function productsByColor(color, product) {
            const imageDiv = document.querySelector("#images" + product);
            console.log("product index in Json", product);
            selectedColors = [];
            imageDiv.innerHTML = "";
            for (let j = 0; j < allproducts[product].length; j++) {
                if (allproducts[product][j].colorId.colorName === color) {
                    selectedColors.push(allproducts[product][j]);
                }
            }
            imageDiv.innerHTML += `
                <img style="float: none" src="\${selectedColors[0].productImageList[0].productFilepath}" width="150px" height="150px">
                <img style="float: none" src="\${selectedColors[0].productImageList[1].productFilepath}" width="150px" height="150px">        
            `;
        }

    </script>

</html>


