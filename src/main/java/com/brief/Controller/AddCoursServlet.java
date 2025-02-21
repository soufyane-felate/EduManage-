package com.brief.Controller;

import com.brief.DAO.CoursDao;
import com.brief.DAO.StudentDao;
import com.brief.Model.Cours;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/AddCours")
public class AddCoursServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nom_cours = request.getParameter("nom");
        String description = request.getParameter("description");
        Cours cours = new Cours();
        cours.setNom_cours(nom_cours);
        cours.setDescrption(description);

        CoursDao coursDao = new CoursDao();
        try {
            coursDao.createCours(cours);
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }


        response.sendRedirect("coursList");
    }

    }



