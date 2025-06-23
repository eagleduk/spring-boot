<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel='stylesheet' href='/webjars/bootstrap/5.3.7/css/bootstrap.min.css'>
</head>
<body>
    <div class="container">
        <form method="POST">
            <div>
                <label>
                    Name:
                </label>
                <input type="text" name="name" />
            </div>
            <div>
                <label>
                    Password:
                </label>
                <input type="password" name="password" />
            </div>
            <input type="submit" class="btn btn-success"/>
        </form>
        <div>
            ${error}
        </div>
    </div>
    <script src="/webjars/bootstrap/5.3.7/js/bootstrap.min.js"></script>
</body>
</html>