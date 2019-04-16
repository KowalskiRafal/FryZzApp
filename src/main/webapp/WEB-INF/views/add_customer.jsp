<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FryZzApp - Dodaj nowego klienta</title>
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
            Dodaj nowego klienta
        </div>
        <div class="card-body">
            <form action="" method="post">
                <div class="input-group form-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-user"></i></span>
                    </div>
                    <input type="text" name="firstName" class="form-control" placeholder="Imię (pole wymagane)" required>
                </div>

                <div class="input-group form-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-user"></i></span>
                    </div>
                    <input type="text" name="lastName" class="form-control" placeholder="Nazwisko (pole wymagane)" required>
                </div>

                <div class="input-group form-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-phone"></i></span>
                    </div>
                    <input type="tel" name="telephoneNumber" class="form-control" placeholder="XXX-XXX-XXX  Numer telefonu (9 cyfr - pole wymagane)">
                </div>

                <div class="input-group form-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-calendar"></i></span>
                    </div>
                    <input type="date" name="visitDate" class="form-control" placeholder="termin wizyty">

                </div>

            <div class="input-group form-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-clock"></i></span>
                    </div>
                    <input type="time" name="visitTime" step="1" class="form-control" placeholder="Godzina">

                </div>

                <div class="input-group form-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-user"></i></span>
                    </div>
                    <input type="text" name="assignedHairdresser" class="form-control" placeholder="Kto strzyże (wpisz login fryzjera)">

                </div>

                <div class="input-group form-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-exclamation-triangle"></i></span>
                    </div>
                    <input type="text" name="info" class="form-control" placeholder="Ważne informacje (uczulenia, alergie)">

                </div>

                <div class="input-group form-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-comments"></i></span>
                    </div>
                    <input type="text" name="comments" class="form-control" placeholder="Własne uwagi">

                </div>




                <div class="card-text text-left text-white">
                    <p5>Wymagane pola - Imię, Nazwisko, numer telefonu, data, godzina </p5>
                </div>
                <div class="form-group">
                    <input type="submit" name="btn" value="Dodaj" class="btn btn-outline-danger float-right login_btn">
                </div>

            </form>
        </div>
    </div>
</div>
</body>
</html>