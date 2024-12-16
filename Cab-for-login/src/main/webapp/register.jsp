<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
</head>
<body>
    <h2>Registration</h2>
    <form action="/registerlogin" method="POST">
        <label for="fullName">Full Name:</label>
        <input type="text" id="fullName" name="fullName" required><br><br>
        <label for="pwd">Password:</label>
        <input type="password" id="pwd" name="pwd" required><br><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>
        <label for="phoneNumber">Phone Number:</label>
        <input type="text" id="phoneNumber" name="phoneNumber" required><br><br>
        <input type="submit" value="Register">
    </form>
    <br>
    <a href="/">Login</a>
</body>
</html>
