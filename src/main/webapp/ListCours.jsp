<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.brief.Model.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Cours</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2 class="text-center mb-4">Liste des Cours</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Description</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="cours" items="${coursList}">
            <tr>
                <td>${cours.id}</td>
                <td>${cours.nom_cours}</td>
                <td>${cours.description}</td>
                <td>
                    <a href="CoursServlet?action=edit&id=${cours.id}" class="btn btn-sm btn-primary">Modifier</a>
                    <a href="CoursServlet?action=delete&id=${cours.id}" class="btn btn-sm btn-danger">Supprimer</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="AddCours.jsp" class="btn btn-success">Ajouter un Cours</a>
</div>
</body>
</html>