<%@include file="common/header.jspf" %>

<body>

    <%@include file="common/navbar.jspf" %>

    <div class="container">
        <h1>
            Welcome, ${name}
        </h1>
        <a href="/list-todo" class="btn btn-success">
            Your Todo
        </a>
    </div>

</body>

<%@include file="common/footer.jspf" %>