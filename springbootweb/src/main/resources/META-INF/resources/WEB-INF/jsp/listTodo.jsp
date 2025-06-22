<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Todo</title>
    <link rel='stylesheet' href='/webjars/bootstrap/5.3.7/css/bootstrap.min.css'>
</head>
<body>
    <div>
        Welcome, ${name}
    </div>
    <hr />
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
                    Traget Date
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
                </tr>
            </c:forEach>
        </tbody>

    </table>

    <script src="/webjars/bootstrap/5.3.7/js/bootstrap.min.js"></script>
</body>
</html>