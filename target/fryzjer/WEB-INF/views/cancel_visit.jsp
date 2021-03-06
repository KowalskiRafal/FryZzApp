<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FryZzApp - Zmień Informacje</title>
    <link rel="stylesheet" href="/sources/css/customer.css">
    <link rel="stylesheet" href="sources/css/style.css">
    <script src="sources/js/customer-filter.js"></script>
    <jsp:include page="elements/header.jsp"/>
</head>
<body>
<jsp:include page="elements/menu.jsp"/><BR>
<form action="${pageContext.request.contextPath }/cancel_visit" method="post">
    <div class="container">


        <div class="card  text-center bg-dark">
            <div class="card-header">
                Czy na pewno chcesz odwołać wizytę ${customer.firstName} ${customer.lastName} ?
            </div>
            <input type="hidden" name="id" value="${customer.id}">
            <input type="hidden" name="firstName" value="${customer.firstName}">
            <input type="hidden" name="lastName" value="${customer.lastName}">
            <input type="hidden" name="telephoneNumber" value="${customer.telephoneNumber}">
            <input type="hidden" name="visitDate" value="${customer.visitDate}">
            <input type="hidden" name="visitTime" value="${customer.visitTime}">
            <input type="hidden" name="assignedHairdresser" value="${customer.assignedHairdresser}">
            <input type="hidden" name="info" value="${customer.info}">
            <input type="hidden" name="comments" value="${customer.comments}">

            <div class="card-body">

                    <div class="input-group form-group">
                        <div class="form-group">
                            <input type="button" name="btn" value="Anuluj" onclick="window.history.back()" class="btn btn-outline-danger float-lg-left login_btn">
                            <input type="submit" name="btn" value="Odwołaj" onclick="window.history.back()"class="btn btn-outline-danger float-lg-center login_btn">
                        </div>
                    </div>

            </div>
        </div>
    </div>
</form>
</body>
</html>