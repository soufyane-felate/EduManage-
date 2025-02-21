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
import java.util.List;

@WebServlet("/addCours")
public class listCoursServlet extends HttpServlet {
    private final CoursDao coursDao = new CoursDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Cours> coursList = coursDao.getAll();
            request.setAttribute("coursList", coursList);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database error", e);
        }
        request.getRequestDispatcher("listCours.jsp").forward(request, response);

    }
}
