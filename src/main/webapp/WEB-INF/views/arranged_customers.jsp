<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FryZzApp - Umówione Wizyty</title>
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

           <c:choose>
            <c:when test="${empty userToDisplay}">
               Umówione wizyty
            </c:when>

               <c:otherwise>
              Wizyty umówione do ciebie - ${user.firstName} ${user.lastName}
               </c:otherwise>
           </c:choose>
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
                    Nazwisko
                </th>
                <th>
                    <i class="fas fa-calendar-alt"></i>
                    Data
                </th>
                <th>
                    <i class="fas fa-clock"></i>
                    Godzina
                </th>
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

                    <c:set var="editVisitURL">
                        <c:url value="/edit_visit">
                            <c:param name="singleCustomerId" value="${customer.id}"/>
                        </c:url>
                    </c:set>
                <c:set var="cancelVisitURL">
                    <c:url value="/cancel_visit">
                        <c:param name="singleCustomerId" value="${customer.id}"/>
                    </c:url>
                </c:set>

                <tr>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.visitDate}</td>
                    <td>${customer.visitTime}</td>
                    <td>
                        <input type="submit" name="btn" value="Pokaż" onclick="location.href = '${singleCustomerURL}'" class="btn btn-danger float-center btn-sm ">
                        <input type="submit" name="btn" value="Zmień termin" onclick="location.href = '${editVisitURL}'" class="btn btn-danger float-center btn-sm ">
                        <input type="submit" name="btn" value="Odwołaj" onclick="location.href = '${cancelVisitURL}'" class="btn btn-danger float-center btn-sm ">

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
</body>
</html>
