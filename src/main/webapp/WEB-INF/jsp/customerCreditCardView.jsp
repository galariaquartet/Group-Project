<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Customer Credit Card</h1>
                
                <div align="center">
    
       
            <br/>
            <br/>
            <table border='1' cellpadding="10">
                <thead>
                    <tr>
                        <th>cardId</th>
                        <th>owner First Name</th>
                        <th>owner Last Name</th>
                        <th>card Number</th>
                        <th>card Number Last Digits</th>
                        <th>cvv</th>
                        <th>expiration Date</th>
                        <th>customerId</th>
                        
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="ccc" items="${listCustomerCreditCard}">
                        <tr>
                            <!--                            edw bazoume tis metablhtes akribws pou antistoixoun sto entity-->
                            <td>${ccc.cardId}</td>
                            <td>${ccc.ownerFirstName}</td>
                            <td>${ccc.ownerLastName}</td>
                            <td>${ccc.cardNumber}</td>
                            <td>${ccc.cardNumberLastDigits}</td>
                            <td>${ccc.cvv}</td>
                            <td>${ccc.expirationDate}</td>
                            <td>${ccc.customerId}</td>

                            <td>

                                <a href="/deleteCustomerCreditCard/${ccc.cardId}">Delete</a>
                            </td>   
                        </tr>
                    </tbody>
                </c:forEach>
            </table>
    </body>
</html>
