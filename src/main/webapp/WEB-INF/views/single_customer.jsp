<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FryZzApp - ${customer.firstName} ${customer.lastName}</title>
    <link rel="stylesheet" href="sources/css/customer.css">
    <script src="sources/js/customer-filter.js"></script>
    <jsp:include page="elements/header.jsp"/>
</head>
<body>
<c:set var="deleteCustomerURL">
    <c:url value="/delete_customer">
        <c:param name="singleCustomerId" value="${customer.id}"/>
    </c:url>
</c:set>

<c:set var="editCustomerURL">
    <c:url value="/edit_customer">
        <c:param name="singleCustomerId" value="${customer.id}"/>
    </c:url>
</c:set>

<c:set var="cancelVisitUrl">
    <c:url value="/cancel_visit">
        <c:param name="singleCustomerId" value="${customer.id}"/>
    </c:url>
</c:set>

<c:set var="generatePDF">
    <c:url value="/pdf_report">
        <c:param name="singleCustomerId" value="${customer.id}"/>
    </c:url>
</c:set>

<c:set var="editVisitURL">
    <c:url value="/edit_visit">
        <c:param name="singleCustomerId" value="${customer.id}"/>
    </c:url>
</c:set>

<c:set var="editInfoURL">
    <c:url value="/edit_info">
        <c:param name="singleCustomerId" value="${customer.id}"/>
    </c:url>
</c:set>

<c:set var="editCommentsURL">
    <c:url value="/edit_comments">
        <c:param name="singleCustomerId" value="${customer.id}"/>
    </c:url>
</c:set>

<c:set var="customer" value = "${customer}"/>
<jsp:include page="elements/menu.jsp"/><BR>
<div class="container">

    <div class="card  text-center bg-dark">
        <div class="card-header">
            <td>${customer.firstName} ${customer.lastName}</td>

            <table class="table table-striped table-dark">
                <thead>
                <tr>
                    <th>
                        <i class="fas fa-phone"></i> tel: ${customer.telephoneNumber}
                    </th>
                </thead>
            </table>

            <div class="card-deck">
                <div class="card text-dark bg-danger mb-3" style="max-width: 18rem;">
                    <div class="card-header"> <i class="fas fa-exclamation-triangle"></i> WAŻNE <i class="fas fa-exclamation-triangle"></i></div>
                    <div class="card-body">
                        <h5 class="card-title">ważne informacje</h5>
                        <c:if test="${empty customer.info}">
                            Brak <!-- tutaj przycisk z edycją lub dodaniem info --><BR>
                            <input type="button" name="edit" value="Dodaj info" onclick="location.href = '${editInfoURL}'" class="btn btn-outline-dark float-center login_btn">
                            <%--<input type="submit" name="btn" value="Dodaj info" class="btn btn-outline-dark float-center login_btn">--%>
                        </c:if>
                        <c:if test="${not empty customer.info}">
                            <p class="card-text">${customer.info}</p>
                            <input type="button" name="edit" value="Zmień info" onclick="location.href = '${editInfoURL}'" class="btn btn-outline-dark float-center login_btn">
                            <%--<input type="submit" name="btn" value="zmień info" class="btn btn-outline-dark float-center login_btn">--%>
                        </c:if>
                    </div>
                </div>

                <div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
                    <div class="card-header"><i class="fas fa-calendar-alt"></i> Termin wizyty</div>
                    <div class="card-body">
                        <c:if test="${empty customer.visitDate}">
                            Klient nie umówił jeszcze wizyty <!-- tutaj przycisk z przekierowaniem do umówienia wizyty --><br/>
                            <input type="button" name="edit" value="Dodaj termin" onclick="location.href = '${editVisitURL}'" class="btn btn-outline-danger float-center login_btn">
                            <%--<input type="submit" name="btn" value="Dodaj wizytę" class="btn btn-outline-danger float-center login_btn">--%>
                        </c:if>
                        <c:if test="${not empty customer.visitDate}">
                            <h5 class="card-text">Data: ${customer.visitDate}</h5>
                            <h5 class="card-text">Godzina: ${customer.visitTime}</h5>
                            <input type="button" name="edit" value="Zmień termin" onclick="location.href = '${editVisitURL}'" class="btn btn-outline-danger float-center login_btn">
                            <input type="button" name="edit" value="Odwołaj" onclick="location.href = '${cancelVisitUrl}'" class="btn btn-outline-danger float-center login_btn">

                            <%--<input type="submit" name="btn" value="Zmień termin" class="btn btn-outline-danger float-center login_btn">--%>
                        </c:if>
                    </div>
                </div>

                <div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
                    <div class="card-header"><i class="fas fa-address-card"></i> Fryzjer</div>
                    <div class="card-body">
                        <%--<p class="card-text">czeka na logike</p>--%>
                            <c:if test="${not empty customer.assignedHairdresser}">
                            <h5 class="card-text">Imię i Nazwisko</h5>
                            <p class="card-text">
                                    ${user.firstName} ${user.lastName}
                                </c:if>
                                <c:if test="${empty customer.assignedHairdresser}">
                                Jeszcze nie przypisano
                                </c:if>
                    </div>
                </div>

                <div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
                    <div class="card-header"><i class="fas fa-comments"></i> Uwagi</div>
                    <div class="card-body">
                        <c:if test="${empty customer.comments}">
                            Brak<BR>
                            <input type="button" name="edit" value="Dodaj uwagi" onclick="location.href = '${editCommentsURL}'" class="btn btn-outline-danger float-center login_btn">
                            <%--<input type="submit" name="btn" value="Dodaj uwagi" class="btn btn-outline-danger float-center login_btn">--%>
                            <!-- przycisk do edycji lub dodania -->
                            </p>
                        </c:if>
                        <c:if test="${not empty customer.comments}">
                            <h5 class="card-text">${customer.comments}</h5>
                            <div class="form-group">
                                <input type="button" name="edit" value="Zmień" onclick="location.href = '${editCommentsURL}'" class="btn btn-outline-danger float-center login_btn">
                                <%--<input type="submit" name="btn" value="Edytuj" class="btn btn-outline-danger float-center login_btn">--%>
                            </div>
                        </c:if>
                    </div>
                </div>

            </div>


            <div class="form-group">
                <input type="button" name="delete" value="Usuń klienta" onclick="location.href = '${deleteCustomerURL}'" class="btn btn-outline-danger float-left login_btn">

                <input type="button" name="" value="Generuj Rachunek" onclick="location.href = '${generatePDF}'" formtarget="_blank" class="btn btn-outline-success float-lg-center login_btn" >

                <input type="button" name="edit" value="Edytuj klienta" onclick="location.href = '${editCustomerURL}'" class="btn btn-outline-danger float-lg-right login_btn">

            </div>

        </div>
    </div>
</div>
</body>
</html>