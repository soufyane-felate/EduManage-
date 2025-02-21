package com.brief.Servlets;

import com.brief.DAO.CoursDao;
import com.brief.Model.Cours;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/CoursServlet")
public class CoursServlet extends HttpServlet {
    private final CoursDao coursDao = new CoursDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            listCours(request, response);
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            createCours(request, response);
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }

    // Afficher la liste des cours
    private void listCours(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Cours> cours = coursDao.getAll();
        request.setAttribute("cours", cours);
        request.getRequestDispatcher("ListCours.jsp").forward(request, response);
    }

    // Ajouter un cours
    private void createCours(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String nom = request.getParameter("nom");
        String description = request.getParameter("description");

        if (nom == null || description == null || nom.isEmpty() || description.isEmpty()) {
            response.sendRedirect("AddCours.jsp?error=missingFields");
            return;
        }

        Cours cours = new Cours();
        cours.setNom_cours(nom);
        cours.setDescrption(description);
        coursDao.createCours(cours);

        response.sendRedirect("CoursServlet");
    }
}
