<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html
        PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Lista dei Libri</title>
    <jsp:useBean id="msg" class="java.lang.String" scope="request" />
</head>
<body>
<c:if test="${msg!=null}">
    <h2>${msg}</h2>
</c:if>
<table border="1">
    <thead>
    <tr>
        <th>Id</th>
        <th>Nome</th>
        <th>Azioni</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${clienti}" var="cliente">
        <tr>
            <td>
                ${cliente.id}
            </td>
            <td>
                ${cliente.nome}
            </td>
            <td><a href="/clienti/modcliente?id=${cliente.id}">Modifica</a> <a href="/clienti/eliminacliente?id=${cliente.id}" >Elimina</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form action="/clienti/inscliente" method="post">
    Nome: <input type="text" name="nome" placeholder="Nome del cliente"/><br/>
    <input type="submit" value="Inserisci Cliente"/>
    <input type="reset" value="pulisci i campi"/>
</form>
</body>
</html>