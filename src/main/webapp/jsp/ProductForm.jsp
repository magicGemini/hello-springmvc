<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>ProductFrom</title>
</head>
<body>

<div id="global">

    <c:if test="${requestScope.errors != null}">
        <p id="errors">
            Error(s)!
        <ul>
            <c:forEach var="error" items="${requestScope.errors}">
                <li>${error}</li>
            </c:forEach>
        </ul>
        </p>
    </c:if>

    <h1>Add a product</h1>
    <form action="product_save.action" method="post">
        <p>
            <label>Product Name:</label>
            <input type="text" id="name" name="name" tabindex="1"/>
        </p>
        <p>
            <label>Product Descrption:</label>
            <input type="text" id="description" name="description" tabindex="2"/>
        </p>
        <p>
            <label>Product Price:</label>
            <input type="text" id="price" name="price" tabindex="3"/>
        </p>
        <p>
            <input type="reset" id="reset" tabindex="4"/>
            <input type="submit" id="submit" tabindex="5" value="Add Product"/>
        </p>
    </form>
</div>

</body>
</html>
