<form action="StudentServlet?action=update" method="post">
    <input type="hidden" name="id" value="<%= request.getAttribute("id") %>">
    Nom: <input type="text" name="nom" value="<%= request.getAttribute("nom") %>" required><br>
    Prenom: <input type="text" name="prenom" value="<%= request.getAttribute("prenom") %>" required><br>
    Email: <input type="email" name="email" value="<%= request.getAttribute("email") %>" required><br>
    Date de Naissance: <input type="date" name="date_naissance" value="<%= request.getAttribute("dateNaissance") %>" required><br>
    <input type="submit" value="Update Student">
</form>
