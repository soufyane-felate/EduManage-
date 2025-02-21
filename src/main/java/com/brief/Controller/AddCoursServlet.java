package com.brief.Controller;

import com.brief.DAO.CoursDao;
import com.brief.Model.Cours;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addCours")
public class AddCoursServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nomCours = request.getParameter("nom_cours");
        String description = request.getParameter("description");

        Cours cours = new Cours(nomCours, description);
        CoursDao coursDao = new CoursDao();

        try {
            coursDao.createCours(cours);
            response.sendRedirect("listCours");
            System.out.println(cours);
        } catch (SQLException e) {
            throw new ServletException("Erreur lors de l'ajout du cours", e);
        }
    }
}
