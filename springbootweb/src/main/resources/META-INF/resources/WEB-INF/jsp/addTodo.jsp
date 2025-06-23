<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Todo List</title>
    <link rel='stylesheet' href='/webjars/bootstrap/5.3.7/css/bootstrap.min.css'>
</head>
<body>

    <form class="container" method="POST">
        <h1>
            New Todos
        </h1>

        <label>
            Description
        </label>

        <input type="text" name="description" />

        <input type="submit" class="btn btn-success" />
    </form>

    <script src="/webjars/bootstrap/5.3.7/js/bootstrap.min.js"></script>
</body>
</html>