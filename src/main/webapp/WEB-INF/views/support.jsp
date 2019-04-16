<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FryZzApp - Wsparcie Techniczne</title>
    <link rel="stylesheet" href="sources/css/customer.css">
    <link rel="stylesheet" href="sources/css/style.css">
    <script src="sources/js/customer-filter.js"></script>
    <jsp:include page="elements/header.jsp"/>
</head>
<body>
<jsp:include page="elements/menu.jsp"/><BR>
<div class="container">

    <div class="card  text-center bg-dark">
        <div class="card-header">
            Wybierz zagadnienie z listy poniżej
        </div>

        <div id="accordion">
            <div class="card text-white bg-dark">
                <div class="card-header" id="headingOne">
                    <h5 class="mb-0">
                        <input type="button" value="Nie mogę dodać klienta" class="btn btn-outline-danger collapsed" data-toggle="collapse" data-target="#collapseOne">

                    </h5>
                </div>

                <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
                    <div class="card-body">
                    U nas działa.
                    </div>
                </div>
            </div>
            <div class="card text-white bg-dark">
                <div class="card-header" id="headingTwo">
                    <h5 class="mb-0">
                        <input type="button" value="Nie pokazuje mi czegoś tam" class="btn btn-outline-danger collapsed" data-toggle="collapse" data-target="#collapseTwo">
                    </h5>
                </div>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
                    <div class="card-body">
                    Nam pokazuje coś tam.
                    </div>
                </div>
            </div>
            <div class="card text-white bg-dark">
                <div class="card-header" id="headingThree">
                    <h5 class="mb-0">
                        <input type="button" value="Pojawia się błąd HTT500" class="btn btn-outline-danger collapsed" data-toggle="collapse" data-target="#collapseThree">
                    </h5>
                </div>
                <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordion">
                    <div class="card-body">
Tak, nam też... odśwież i nie zawracaj dupy
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="card-header">
        Nie udało się rozwiązać Problemu? Zadzwoń 0700-700-700
    </div>
</div>

</body>
</html>