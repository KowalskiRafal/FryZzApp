<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FryZzApp - Zmień termin</title>
    <link rel="stylesheet" href="/sources/css/customer.css">
    <link rel="stylesheet" href="sources/css/style.css">
    <script src="sources/js/customer-filter.js"></script>
    <jsp:include page="elements/header.jsp"/>
</head>
<body>
<jsp:include page="elements/menu.jsp"/><BR>
<form action="${pageContext.request.contextPath }/edit_visit" method="post">
    <div class="container">


        <div class="card  text-center bg-dark">
            <div class="card-header">
                Umów wizytę lub zmień termin dla klienta: ${customer.firstName} ${customer.lastName}
            </div>
            <input type="hidden" name="id" value="${customer.id}">
            <input type="hidden" name="firstName" value="${customer.firstName}">
            <input type="hidden" name="lastName" value="${customer.lastName}">
            <input type="hidden" name="telephoneNumber" value="${customer.telephoneNumber}">
            <input type="hidden" name="comments" value="${customer.comments}">
            <input type="hidden" name="info" value="${customer.info}">

            <div class="card-body">
                <div class="input-group form-group">

                <div class="input-group form-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-calendar"></i></span>
                    </div>
                    <input type="date" name="visitDate" class="form-control" value="${customer.visitDate}">
                </div>

                <div class="input-group form-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-clock"></i></span>
                    </div>
                    <input type="time" step="1" name="visitTime" class="form-control" value="${customer.visitTime}">
                </div>

                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user"></i></span>
                        </div>
                        <input type="text" name="assignedHairdresser" class="form-control" value="${customer.assignedHairdresser}" placeholder="Kto strzyże (wpisz login fryzjera)">
                    </div>


                <div class="form-group">
                    <input type="button" name="btn" value="Anuluj" onclick="window.history.back()" class="btn btn-outline-danger float-lg-left login_btn">
                    <input type="submit" name="btn" value="Zmień"  class="btn btn-outline-danger float-lg-right login_btn">
                </div></div>
            </div>
        </div>
    </div>
</form>
</body>
</html>

