package com.brief.Controller;

import com.brief.DAO.StudentDao;
import com.brief.Model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String dateNaissance = request.getParameter("date_naissance");



        Student student = new Student();
        student.setNom(nom);
        student.setPrenom(prenom);
        student.setEmail(email);
        student.setDateNaissance(dateNaissance);

        StudentDao studentDao = new StudentDao();
        try {
            studentDao.create(student);
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
        response.sendRedirect("listStudents");  // Redirect to student list
    }
}
