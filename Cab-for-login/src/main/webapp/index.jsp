<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>
    <form action="/login" method="POST">
        <label for="fullName">Full Name:</label>
        <input type="text" id="fullName" name="fullName" required><br><br>
        <label for="pwd">Password:</label>
        <input type="password" id="pwd" name="pwd" required><br><br>
        <input type="submit" value="Login">
    </form>
    <br>
    <a href="register.jsp">Register</a>
</body>
</html>
