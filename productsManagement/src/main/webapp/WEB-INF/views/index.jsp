<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/product-management/">TASK FOR SKYTOUCH</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/product-management/products/" >Product Catalog</a></li>
            <li><a href="/product-management/products/add/">Add Product</a></li>
        </ul>
    </div>
</nav>
    <div class="container-fluid col-md-offset-4">
       <h2>Task</h2>
        <div class="row">
            <div class="col-md-4">
                <a href="/product-management/products/add" class="btn btn-info">Add Product</a>
                <a href="/product-management/products/" class="btn btn-info">Product Catalog</a>
            </div>
            <div class="col-md-4"></div>
        </div>
    </div>

</body>
</html>