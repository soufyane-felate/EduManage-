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
@WebServlet("/cours")
public class AddCoursServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nom_cours = request.getParameter("name");
        String description = request.getParameter("description");
        Cours cours = new Cours();
        cours.setNom_cours(nom_cours);
        cours.setDescrption(description);
        Cours coursDao = new Cours();

        response.sendRedirect("listStudents");
    }

    }



