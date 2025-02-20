<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Tableau de Bord</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>
<div class="container mt-4">
    <h1 class="text-center text-primary">Tableau de Bord</h1>
    <div class="row">
        <div class="col-md-4">
            <a href="AddStudent.jsp.jsp" class="btn btn-success w-100">
                <i class="fas fa-user-plus"></i> Ajouter un étudiant
            </a>
        </div>
        <div class="col-md-4">
            <a href="AddCours.jsp" class="btn btn-info w-100">
                <i class="fas fa-book"></i> Ajouter un cours
            </a>
        </div>
        <div class="col-md-4">
            <a href="ListCours.jsp.jsp" class="btn btn-primary w-100">
                <i class="fas fa-list"></i> Liste des étudiants
            </a>
        </div>
    </div>
</div>
</body>
</html>
