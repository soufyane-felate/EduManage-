<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.brief.Model.Student" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Student</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">Edit Student</h2>
    <form action="StudentServlet?action=update" method="post">
        <input type="hidden" name="id" value="${student.id}">
        <div class="mb-3">
            <label for="nom" class="form-label">Nom:</label>
            <input type="text" class="form-control" id="nom" name="nom" value="${student.nom}" required>
        </div>
        <div class="mb-3">
            <label for="prenom" class="form-label">Prenom:</label>
            <input type="text" class="form-control" id="prenom" name="prenom" value="${student.prenom}" required>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email:</label>
            <input type="email" class="form-control" id="email" name="email" value="${student.email}" required>
        </div>
        <div class="mb-3">
            <label for="date_naissance" class="form-label">Date de Naissance:</label>
            <input type="date" class="form-control" id="date_naissance" name="date_naissance" value="${student.dateNaissance}" required>
        </div>
        <button type="submit" class="btn btn-primary">Update Student</button>
        <a href="StudentServlet?action=list" class="btn btn-secondary">Cancel</a>
    </form>
</div>
</body>
</html>