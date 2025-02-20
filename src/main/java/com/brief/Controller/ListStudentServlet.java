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
import java.util.List;

@WebServlet("/listStudents")
public class ListStudentServlet extends HttpServlet {
    private final StudentDao studentDao = new StudentDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Student> students = studentDao.getAll();
            request.setAttribute("students", students);
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
        request.getRequestDispatcher("ListStudent.jsp").forward(request, response);
    }
}
