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
