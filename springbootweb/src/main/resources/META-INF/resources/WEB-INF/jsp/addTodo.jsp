<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Todo List</title>
    <link rel='stylesheet' href='/webjars/bootstrap/5.3.7/css/bootstrap.min.css'>
</head>
<body>

    <form:form cssClass="container" method="POST" modelAttribute="todo">
        <h1>
            New Todos
        </h1>

        <label>
            Description
        </label>

        <form:input type="text" path="description" required="required" />
        <form:errors path="description" />

        <form:input type="hidden" path="id" />
        <form:input type="hidden" path="done" />
        <form:input type="hidden" path="targetDate" />
        <input type="submit" class="btn btn-success" />
    </form:form>

    <script src="/webjars/bootstrap/5.3.7/js/bootstrap.min.js"></script>
</body>
</html>