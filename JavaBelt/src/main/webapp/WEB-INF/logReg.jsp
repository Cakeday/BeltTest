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

    <div class="container">
        <h1>Register!</h1>
            
        <p><form:errors path="user_r.*"/></p>
            
        <form:form method="POST" action="/registration" modelAttribute="user_r">
            <p>
                    <form:label path="name">Name:</form:label>
                    <form:input type="text" path="name"/>
            </p>
            <p>
                <form:label path="email">Email:</form:label>
                <form:input type="email" path="email"/>
            </p>
            <p>
                <form:label path="password">Password:</form:label>
                <form:password path="password"/>
            </p>
            <p>
                <form:label path="passwordConfirmation">Password Confirmation:</form:label>
                <form:password path="passwordConfirmation"/>
            </p>
            <button type="submit">Register</button>
        </form:form>
    </div>
    <div class="container">
        <h1>Login</h1>
        <p><c:out value="${error}" /></p>
        <form method="post" action="/login">
            <p>
                <label for="email">Email</label>
                <input type="text" id="email" name="email_l"/>
            </p>
            <p>
                <label for="password">Password</label>
                <input type="password" id="password" name="password_l"/>
            </p>
            <button type="submit">Login</button>
        </form>    
    </div>
    
</body>
</html>