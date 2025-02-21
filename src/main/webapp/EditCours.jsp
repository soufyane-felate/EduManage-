<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modifier un Cours</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2 class="text-center mb-4">Modifier un Cours</h2>
    <form action="CoursServlet" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="${cours.id}">
        <div class="mb-3">
            <label for="nom_cours" class="form-label">Nom du Cours</label>
            <input type="text" class="form-control" id="nom_cours" name="nom_cours" value="${cours.nom_cours}" required>
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Description</label>
            <textarea class="form-control" id="description" name="description" required>${cours.description}</textarea>
        </div>
        <button type="submit" class="btn btn-primary">Mettre à jour</button>
    </form>
</div>
</body>
</html>