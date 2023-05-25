<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get" action="${pageContext.request.contextPath}/convert">
    <label for="type">Type Convert:</label>
    <c:if test="${type=='usd'||type==null}">
        <select name="type" id="type">
            <option value="usd" selected>USD => VND</option>
            <option value="vnd">VND => USD</option>
        </select>
    </c:if>
    <c:if test="${type=='vnd'}">
        <select name="type" id="type">
            <option value="usd">USD => VND</option>
            <option value="vnd" selected>VND => USD</option>
        </select>
    </c:if>
    <br/>
    <label for="value">Value: </label>
    <input type="number" name="value" id="value" value="${value}">
    <br/>
    <label for="rate">Rate USD/VND: </label>
    <input type="number" name="rate" id="rate" value="${rate}">
    <br/>
    <button type="submit">Convert</button>
    <br/>
    <p>Result: <b>${result}</b></p>
</form>
</body>
</html>
