<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FryZzApp - Nasi klienci</title>
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
            Nasi Klieci
        </div>

        <div class="input-group form-group">
            <div class="input-group-prepend">
                <span class="input-group-text"><i class="fas fa-user"></i></span>
            </div>
            <input type="text" id="myInput" class="form-control" placeholder="Wyszukaj klienta...">
        </div>

        <table class="table table-striped table-dark">
            <thead>
            <tr>

                <th>
                    <i class="fas fa-user"></i>
                    Imię
                </th>
                <th>
                    <i class="fas fa-user"></i>
                    Nazwisko</th>
                <th>
                    <i class="fas fa-phone"></i>
                    Telefon</th>
                <th>
                    <i class="fas fa-edit"></i>
                    Akcje</th>
            </tr>
            </thead>

            <tbody id="myTable">
            <c:forEach items="${customersList}" var="customer">
                <c:set var="singleCustomerURL">
                    <c:url value="/single_customer">
                    <c:param name="singleCustomerId" value="${customer.id}"/>
                    </c:url>
                </c:set>
                <tr>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.telephoneNumber}</td>
                    <td>

                        <%--<a href = <c:url value = "${singleCustomerURL}"/>>Pokaż</a>--%>


                            <input type="submit" name="btn" value="Pokaż" onclick="location.href = '${singleCustomerURL}'" class="btn btn-danger float-center btn-sm ">

                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <script>
        $(document).ready(function(){
            $("#myInput").on("keyup", function() {
                var value = $(this).val().toLowerCase();
                $("#myTable tr").filter(function() {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
            });
        });
        </script>
    </div>
</div>
</body>
</html>