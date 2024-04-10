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


    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="alert alert-danger" role="alert">
                <h3> ${message} </h3>
            </div>
            <a href="/product-management/" class="btn btn-info">HOME PAGE</a>
        </div>
    </div>

</html>