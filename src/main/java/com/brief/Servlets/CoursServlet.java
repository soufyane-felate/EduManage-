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
        String action = request.getParameter("action");

        try {
            if (action == null || action.equals("list")) {
                List<Cours> coursList = coursDao.getAll();
                request.setAttribute("coursList", coursList);
                request.getRequestDispatcher("ListCours.jsp").forward(request, response);
                System.out.println(coursList);
            } else if (action.equals("edit")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Cours cours = coursDao.getById(id);
                request.setAttribute("cours", cours);
                request.getRequestDispatcher("EditCours.jsp").forward(request, response);
            } else if (action.equals("delete")) {
                int id = Integer.parseInt(request.getParameter("id"));
                coursDao.delete(id);
                response.sendRedirect("CoursServlet?action=list");
            }
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action.equals("create")) {
                String nom_cours = request.getParameter("nom_cours");
                String description = request.getParameter("description");

                Cours cours = new Cours();
                cours.setNom_cours(nom_cours);
                cours.setDescription(description);

                coursDao.createCours(cours);
                response.sendRedirect("CoursServlet?action=list");
            } else if (action.equals("update")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String nom_cours = request.getParameter("nom_cours");
                String description = request.getParameter("description");

                Cours cours = new Cours(id, nom_cours, description);
                coursDao.update(cours);
                response.sendRedirect("CoursServlet?action=list");
            }
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }
}