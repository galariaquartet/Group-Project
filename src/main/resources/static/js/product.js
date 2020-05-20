        fetch("http://localhost:8080/JsonProducts")
                .then(function (response) {
                    return response.json();
                })
                .then(getProducts)
                .catch(function (error) {
                    console.log("Error:", error.message);
                });

        const allproducts = [];
        const productsBox = document.querySelector("#products");

        function getProducts(data) {
            for (let i = 0; i < data.length; i++) {
                allproducts.push(data[i]);
            }
//            console.log(allproducts.length);
//            console.log(allproducts);
//            console.log(allproducts[0]);
//            console.log(allproducts[0][0].productId);
//            console.log(allproducts[0][0]);
//
//            for (let i = 0; i < allproducts.length; i++) {
//                for (let j = 0; j < allproducts[i].length; j++) {
//                    console.log(allproducts[i][j].productId, allproducts[i][j].productName);
//                }
//            }
            displayProducts();
        }

        function displayProducts() {
            console.log("*****************");
            for (let i = 0; i < allproducts.length; i++) {
                for (let j = 0; j < allproducts[i].length; j++) {
                    console.log(allproducts[i][j].productId, allproducts[i][j].productName);
                }
            }
            
            productsBox.innerHTML = "";
            let productsOutput = "";
            for (let i = 0; i < allproducts.length; i++) {
                for (let j = 0; j < allproducts[i].length; j++) {
                    productsOutput += `
                    <div class="product">
                      <p>Test: ${5+5}</p>
                      <p>ProductID: ${allproducts[i][j].productId} </p>
                      <p>ProductName: ${allproducts[i][j].productName} </p>
                    </div>
                    `;
                }
            }
            productsBox.innerHTML = productsOutput;
        }
