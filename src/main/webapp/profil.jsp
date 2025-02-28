<%@ page import="com.brief.Model.Student" %>
<%@ page import="com.brief.Model.Cours" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%
  String user = (String) session.getAttribute("user");
  if (user == null) {
    response.sendRedirect("../webapp/login.jsp?error=Please login first");
    return;
  }
%>
<html>
<head>
    <title>profil</title>
</head>
<body>
<h1>Welcom ${user}</h1>
<form action="logout" method="post">
  <input type="submit" value="Logout">
</form>

</form>


</body>
</html>
