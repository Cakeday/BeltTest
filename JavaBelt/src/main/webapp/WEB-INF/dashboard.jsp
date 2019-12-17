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

    <h1>Welcome, ${user.name}</h1>

    <div class="container">
        <table>
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Network</th>
                    <th>Rating</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${shows}" var="show">
                    <tr>
                        <td><a href="/shows/${show.id}">${show.title}</a></td>
                        <td>${show.network}</td>
                        <td>
                            Averages will go here
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <a href="/shows/new">Add a show</a>
    
</body>
</html>