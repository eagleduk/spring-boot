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
            Todo
        </h1>

        <div>
            <form:label for="description" path="description">
                Description
            </form:label>

            <form:input type="text" path="description" id="description" required="required" />
            <form:errors path="description" />
        </div>

        <div>
            <form:label for="targetDate" path="targetDate">
                Target Date
            </form:label>

            <form:input type="date" path="targetDate" />
        </div>

        <form:input type="hidden" path="id" />
        <form:input type="hidden" path="done" />
        <form:input type="hidden" path="username" />
        <input type="submit" class="btn btn-success" />
    </form:form>

    <script src="/webjars/bootstrap/5.3.7/js/bootstrap.min.js"></script>
</body>
</html>