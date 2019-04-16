<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="navbar-brand">Fryzjer u janka</div>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/home">Strona Główna</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/add_customer">Dodaj klienta</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Wyświetl klientów
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/display_customers">Wszyscy klienci</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/arranged">Wszyscy umówieni</a>
                    <a class="dropdown-item" href="/your_arranged">Twoi umówieni</a>
                    <a class="dropdown-item" href="/not_arranged">Nie umówieni</a>
                </div>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown1" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Wsparcie techniczne
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/support">Kontakt</a>
                    <a class="dropdown-item" href="/doc">Dokumentacja</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/logout">Wyloguj</a>
            </li>
        </ul>
        <span class="navbar-text">
      Zalogowany: ${user.firstName} ${user.lastName}
    </span>
    </div>
</nav>