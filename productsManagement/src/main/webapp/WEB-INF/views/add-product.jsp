<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Add Product</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<c:if test="${addProductSuccess == true}">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="alert alert-success" role="alert">Successfully added Product: ${savedProduct.name}</div>
        </div>
    </div>
</c:if>

<c:if test="${addProductSuccess == false}">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="alert alert-danger" role="alert">Error adding Product: ${savedProduct.name}</div>
        </div>
    </div>
</c:if>

<c:url var="add_product_url" value="/products/add"/>
<div class="row">
    <div class="col-md-4 col-md-offset-4">
        <h2>Add Product</h2>
        <form:form action="${add_product_url}" method="post" modelAttribute="product">
            <div class="form-group">
                <form:label path="name">Name: </form:label>
                <form:input type="text" path="name" cssClass="form-control"/>
            </div>
            <div class="form-group">
                <form:label path="cost">Cost: </form:label>
                <form:input type="number" path="cost" cssClass="form-control" />
            </div>
            <div class="form-group">
                <form:label path="storeName">Store Name: </form:label>
                <form:input type="text" path="storeName" cssClass="form-control"/>
            </div>
            <input type="submit" value="submit" class="btn btn-primary"/>
        </form:form>
    </div>
</div>
</body>
</html>