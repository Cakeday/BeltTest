<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

    <h1>${show.title}</h1>
    <table>
        <thead>
            <th>Name</th>
            <th>Rating</th>
        </thead>
        <c:forEach items="${finalList}" var="rater">
            <tr>
                <td>${rater.user.name}</td>
                <td>${rater.rating}</td>
            </tr>
        </c:forEach>
    </table>

    <a href="/shows/${show.id}/edit">Edit!</a>

    <h2>Leave a rating!</h2>
    <form:form action="/createrating/${show.id}" method="POST" modelAttribute="rating">
        <p>
            <form:select path="rating">
                <option selected disabled>Pick a number!</option>
                <form:option value="1">1</form:option> 
                <form:option value="2">2</form:option> 
                <form:option value="3">3</form:option> 
                <form:option value="4">4</form:option> 
                <form:option value="5">5</form:option> 
            </form:select>
        </p>
        <input type="submit" value="Create">
    </form:form>
    
</body>
</html>