<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FryZzApp - Dodano klienta</title>
    <link rel="stylesheet" href="sources/css/customer.css">
    <script src="sources/js/customer-filter.js"></script>
    <jsp:include page="elements/header.jsp"/>
</head>
<body>
<jsp:include page="elements/menu.jsp"/><BR>
<div class="container">

    <div class="card  text-center bg-dark">
        <div class="card-header">
           Nowy klient został dodany poprawnie
        </div>

    </div>
</div>

<script>
    var timer = setTimeout(function() {
        window.location='/single_customer'
    }, 5000);
</script>

</body>
</html>