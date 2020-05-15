<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Variables</title>

        <style>
            #colors {
                position: absolute;

            }
            #sizes {
                position: absolute;
                margin-left: 30%
            }

            #genders {
                position: absolute;
                margin-left: 50%
            }

            #materials {
                position: absolute;
                margin-left: 75%;
            }
        </style>
    </head>
    <body>
        <button id="colorbutton">Colors</button>
        <button id="sizebutton">Sizes</button>
        <button id="genderbutton">Genders</button>
        <button id="materialbutton">Materials</button>
        <div id="colors">
            <table border='1' width="25%">
                <thead>
                    <tr>
                        <th>Color Name</th>
                        <th>Color Image</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="c" items="${colors}">           
                        <tr>
                            <td>${c.colorName}</td>
                            <td><img src="${c.colorImageFilepath}" /></td> 
                            <td>
                                <a href="/deleteColor/${c.colorId}">Delete</a>
                            </td>   
                        </tr>
                    </c:forEach>
                    <form:form method="POST" action="/saveColor" modelAttribute="newcolor">
                        <tr>
                            <td>
                                <form:label path="colorName">Color Name</form:label>
                                <form:input path="colorName" type="text"/>
                            </td>
                            <td>
                                <form:label path="colorImageFilepath">Color Image Filepath</form:label>
                                <form:input path="colorImageFilepath" type="text" />
                            </td>
                            <td>
                                <input type="submit" value="Save New Color"/>
                            </td>
                        </tr>
                    </form:form>
                </tbody>
            </table>
        </div>


        <div id="sizes">
            <table border='1' width="20%">
                <thead>
                    <tr>
                        <th>Size Name</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="s" items="${sizes}">           
                        <tr>
                            <td>${s.sizeName}</td>
                            <td>
                                <a href="/deleteSize/${s.sizeId}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    <form:form method="POST" action="/saveProductSize" modelAttribute="ProductSize">
                        <tr>
                            <td>
                                <form:label path="sizeName">Size Name</form:label>
                                <form:input path="sizeName" type="text"/>
                            </td>
                            <td>
                                <input type="submit" value="Save New Size"/>
                            </td>
                        </tr>
                    </form:form>
                </tbody>
            </table>
        </div>

        <div id="genders">
            <table border='1' width="20%">
                <thead>
                    <tr>
                        <th>Gender Name</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="g" items="${genders}">           
                        <tr>
                            <td>${g.genderName}</td>
                            <td>
                                <a href="/deleteGender/${g.genderId}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    <form:form method="POST" action="/saveGender" modelAttribute="newgender">
                        <tr>
                            <td>
                                <form:label path="genderName">Gender Name</form:label>
                                <form:input path="genderName" type="text"/>
                            </td>
                            <td>
                                <input type="submit" value="Save New Gender"/>
                            </td>
                        </tr>
                    </form:form>
                </tbody>
            </table>
        </div>

        <div id="materials">
            <table border='1' width="20%">
                <thead>
                    <tr>
                        <th>Material Name</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="m" items="${materials}">           
                        <tr>
                            <td>${m.materialName}</td>

                            <td>  
                                <a href="/deleteMaterial/${m.materialId}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    <form:form method="POST" action="saveMaterial" modelAttribute="newMaterial">
                        <tr>
                            <td>
                                <form:label path="materialName">Material Name</form:label>
                                <form:input path="materialName" type="text"/>
                            </td>
                            <td>
                                <input type="submit" value="Save New Material"/>
                            </td>
                        </tr>
                    </form:form>
                </tbody>
            </table>
        </div>
    </body>

    <script>
        const colorbuttton = document.querySelector("#colorbutton");
        const sizebutton = document.querySelector("#sizebutton");
        const materialbutton = document.querySelector("#materialbutton");
        const genderbutton = document.querySelector("#genderbutton");
        const colordiv = document.querySelector("#colors");
        const sizediv = document.querySelector("#sizes");
        const materialdiv = document.querySelector("#materials");
        const genderdiv = document.querySelector("#genders");
        colordiv.style.display = "none";
        sizediv.style.display = "none";
        materialdiv.style.display = "none";
        genderdiv.style.display = "none";
        
        colorbuttton.addEventListener("click", function () {
            if (colordiv.style.display === "none") {
                colordiv.style.display = "block";
            } else {
                colordiv.style.display = "none";
            }
        });
        
        sizebutton.addEventListener("click", function () {
            if (sizediv.style.display === "none") {
                sizediv.style.display = "block";
            } else {
                sizediv.style.display = "none";
            }
        });
        
        materialbutton.addEventListener("click", function () {
            if (materialdiv.style.display === "none") {
                materialdiv.style.display = "block";
            } else {
                materialdiv.style.display = "none";
            }
        });
        
        genderbutton.addEventListener("click", function () {
            if (genderdiv.style.display === "none") {
                genderdiv.style.display = "block";
            } else {
                genderdiv.style.display = "none";
            }
        });

    </script>

</html>
