<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html
        PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Lista dei Libri</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Titolo</th>
        <th>Autori</th>
        <th>Prezzo</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>
                ${book.id}
            </td>
            <td>
                ${book.title}
            </td>
            <td>
                    ${book.authors}
            </td>
            <td>
                    ${book.price}
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>