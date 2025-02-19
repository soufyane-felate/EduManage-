<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Étudiants</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
    <style>
        body {
            background-color: #f4f7f9;
        }

        .container {
            margin-top: 50px;
        }

        .card {
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }

        .table {
            margin-top: 20px;
        }

        .table thead {
            background-color: #343a40;
            color: white;
        }

        .btn-custom {
            background-color: #198754;
            color: white;
            transition: 0.3s;
        }

        .btn-custom:hover {
            background-color: #145c38;
        }
    </style>
</head>
<body>

<div class="container">
    <h2 class="text-center mb-4">Liste des Étudiants</h2>

    <div class="card">
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Email</th>
                <th>Date de naissance</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${student.id}</td>
                <td>${student.nom}</td>
                <td>${student.prenom}</td>
                <td>${student.email}</td>
                <td>${student.date_naissance}</td>
            </tr>
            </tbody>
        </table>
    </div>

    <div class="text-center mt-3">
        <a href="student" class="btn btn-lg btn-custom"><i class="fas fa-plus"></i> Ajouter un étudiant</a>
    </div>
</div>
</body>
</html>
