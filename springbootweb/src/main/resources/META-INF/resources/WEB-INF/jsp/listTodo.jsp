<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Todo List</title>
    <link rel='stylesheet' href='/webjars/bootstrap/5.3.7/css/bootstrap.min.css'>
</head>
<body>

    <div class="container">
        <h1>
            Todos
        </h1>

        <table>
            <thead>
                <tr>
                    <th>
                        id
                    </th>
                    <th>
                        Description
                    </th>
                    <th>
                        Target Date
                    </th>
                    <th>
                        Is Done?
                    </th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${todo}" var="todo">
                    <tr>
                        <td>
                            ${todo.id}
                        </td>
                        <td>
                            ${todo.description}
                        </td>
                        <td>
                            ${todo.targetDate}
                        </td>
                        <td>
                            ${todo.done}
                        </td>
                        <td>
                            <a class="btn btn-danger" href="delete-todo?id=${todo.id}">
                                Delete
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>

        </table>

        <a href="/add-todo">
            Add Todo
        </a>

    </div>

    <script src="/webjars/bootstrap/5.3.7/js/bootstrap.min.js"></script>
</body>
</html>