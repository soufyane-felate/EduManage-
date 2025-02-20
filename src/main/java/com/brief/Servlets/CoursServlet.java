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
@WebServlet("CoursServlet")
public class CoursServlet extends HttpServlet {
    private final CoursDao coursDao = new CoursDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Cours> courses = coursDao.getAll();
            request.setAttribute("cours", courses);
            request.getRequestDispatcher("AddCours.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Erreur lors de la récupération des courses", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom_cours = request.getParameter("nom");
        String description = request.getParameter("description");


        Cours cours = new Cours();
        cours.setNom_cours(nom_cours);
        cours.setDescrption(description);

        try {
            coursDao.createCours(cours);
            response.sendRedirect("Listcours");
        } catch (SQLException e) {
            throw new ServletException("Error creating cours", e);
        }
    }
}

