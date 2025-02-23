package com.brief.Servlets;

import com.brief.DAO.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/EnrollStudentServlet")
public class EnrollStudentServlet extends HttpServlet {
    private final StudentDao studentDao = new StudentDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("student_id"));
        String[] courseIds = request.getParameterValues("course_ids");

        try {
            if (courseIds != null) {
                for (String courseId : courseIds) {
                    studentDao.enrollStudentInCourse(studentId, Integer.parseInt(courseId));
                }
            }
            response.sendRedirect("StudentServlet?action=list");
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }
}