<%--
  Created by IntelliJ IDEA.
  User: oucht
  Date: 2/18/2025
  Time: 10:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestion des Cours</title>
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
    <h2 class="text-center mb-4">Gestion des Cours</h2>


    <div class="card p-3">
        <form class="row g-2">
            <div class="col-md-10">
                <input class="form-control form-control-lg" type="search" placeholder="Rechercher un cours">
            </div>
            <div class="col-md-2 text-end">
                <button class="btn btn-lg btn-custom" type="submit"><i class="fas fa-search"></i> Rechercher</button>
            </div>
        </form>
    </div>


    <table class="table table-striped table-hover mt-4">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Description</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${Cours.id}</td>
            <td>${Cours.nom}</td>
            <td>${Cours.description}</td>
        </tr>
        </tbody>
    </table>


    <div class="text-center">
        <a href="coursList" class="btn btn-lg btn-custom"><i class="fas fa-plus"></i> Ajouter un nouveau cours</a>
    </div>
</div>
</body>
</html>
