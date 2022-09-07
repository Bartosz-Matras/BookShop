<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
    <title>BookShop - login</title>

<body>
    <form:form action="processForm" modelAttribute="user">

        Login: <form:input path="username" />

        <br><br>

        Password: <form:input path="password" />

        <br><br>

        <input type="submit" value="Submit" />

    </form:form>
</body>

</html>