<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html
        PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Lista dei Libri</title>
    <jsp:useBean id="cliente" class="psw.spring.springmvcsemplice.entities.Cliente" scope="request" />
</head>
<body>
<form method="post" action="/clienti/modcliente">
    Id: ${cliente.id}<input type="hidden" name="id" value="${cliente.id}"/><br/>
    Nome: <input type="text" name="nome" value="${cliente.nome}"/><br/>
    <input type="submit" value="Modifica Cliente"/>
    <input type="reset" value="pulisci i campi"/>
</form>
</body>
</html>