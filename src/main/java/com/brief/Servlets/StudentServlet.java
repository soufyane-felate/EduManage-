package com.brief.Servlets;

import com.brief.DAO.StudentDao;
import com.brief.Model.Student;
import java.sql.SQLException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ListStudent")
public class StudentServlet extends HttpServlet {
    private final StudentDao studentDao = new StudentDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Student> students = studentDao.getAll();
            request.setAttribute("students", students);
            request.getRequestDispatcher("AddStudent.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error retrieving students", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String dateNaissance = request.getParameter("date_naissance");

        if (nom == null || prenom == null || email == null || dateNaissance == null ||
                nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || dateNaissance.isEmpty()) {
            request.setAttribute("error", "Tous les champs sont obligatoires.");
            request.getRequestDispatcher("students.jsp").forward(request, response);
            return;
        }

        Student student = new Student();
        student.setNom(nom);
        student.setPrenom(prenom);
        student.setEmail(email);
        student.setDateNaissance(dateNaissance);

        try {
            studentDao.create(student);
            response.sendRedirect("ListStudent");
        } catch (SQLException e) {
            throw new ServletException("Error creating student", e);
        }
    }
}
