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

@WebServlet("/listCours")
public class listCoursServlet extends HttpServlet {

        private final CoursDao coursDao = new CoursDao();

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            try {
                List<Cours> coursList = coursDao.getAll();
                request.setAttribute("coursList", coursList);
                request.getRequestDispatcher("ListCours.jsp").forward(request, response);
                System.out.println(coursList);
            } catch (SQLException e) {
                throw new ServletException("Erreur lors de la récupération des cours", e);
            }
        }


}
