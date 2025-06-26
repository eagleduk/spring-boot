<%@include file="common/header.jspf" %>

<body>

    <%@include file="common/navbar.jspf" %>

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

</body>

<%@include file="common/footer.jspf" %>