
<%@include file="common/header.jspf" %>

<body>

    <%@include file="common/navbar.jspf" %>

    <div class="container">
        <h1>
            Todos
        </h1>

        <table class="table">
            <thead>
                <tr>
                    <th>
                        id
                    </th>
                    <th>
                        Description
                    </th>
                    <th>
                        User
                    </th>
                    <th>
                        Target Date
                    </th>
                    <th>
                        Is Done?
                    </th>
                    <th>
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
                            ${todo.username}
                        </td>
                        <td>
                            ${todo.targetDate}
                        </td>
                        <td>
                            ${todo.done}
                        </td>
                        <td>
                            <a class="btn btn-warning" href="update-todo?id=${todo.id}">
                                Update
                            </a>
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

</body>

<%@include file="common/footer.jspf" %>