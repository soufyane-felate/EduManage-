<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f4f4f4;
        }
        .login-container {
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .error {
            color: red;
        }
    </style>
</head>
<body>
<div class="login-container">
    <h2>Login</h2>

    <% if (request.getParameter("error") != null) { %>
    <p class="error">Invalid username or password</p>
    <% } %>

    <form action="dashbord.jsp" method="post">
        <label>Username:</label>
        <input type="text" name="username" required>
        <br><br>

        <label>Password:</label>
        <input type="password" name="password" required>
        <br><br>

        <button type="submit">Login</button>
    </form>
</div>
</body>
</html>
