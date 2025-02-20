<%@ page import="com.brief.Model.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Liste des Étudiants</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h1 class="text-primary">Liste des Étudiants</h1>
        <a href="AddStudent.jsp" class="btn btn-success">Ajouter un étudiant</a>
    </div>

    <div class="table-responsive">
        <table class="table table-striped table-hover shadow-sm">
            <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Email</th>
                <th>Date de Naissance</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <% List<Student> students = (List<Student>) request.getAttribute("students"); %>
            <% if (students != null && !students.isEmpty()) { %>
            <% for (Student student : students) { %>
            <tr>
                <td><%= student.getId() %></td>
                <td><%= student.getNom() %></td>
                <td><%= student.getPrenom() %></td>
                <td><%= student.getEmail() %></td>
                <td><%= student.getDateNaissance() %></td>
                <td>
                    <a href="StudentServlet?action=edit&id=<%= student.getId() %>" class="btn btn-warning btn-sm">
                        <i class="fas fa-edit"></i>
                    </a>
                    <a href="StudentServlet?action=delete&id=<%= student.getId() %>"
                       class="btn btn-danger btn-sm"
                       onclick="return confirm('Êtes-vous sûr de vouloir supprimer cet étudiant ?')">
                        <i class="fas fa-trash"></i>
                    </a>
                </td>
            </tr>
            <% } %>
            <% } else { %>
            <tr>
                <td colspan="6" class="text-center text-muted">Aucun etudiant trouvé</td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
