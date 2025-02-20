package com.brief.Servlets;

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

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    private final StudentDao studentDao = new StudentDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action == null) {
                listStudents(request, response);
            } else {
                switch (action) {
                    case "new":
                        showNewForm(request, response);
                        break;
                    case "edit":
                        showEditForm(request, response);
                        break;
                    case "delete":
                        deleteStudent(request, response);
                        break;
                    default:
                        listStudents(request, response);
                        break;
                }
            }
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if ("create".equals(action)) {
                createStudent(request, response);
            } else if ("update".equals(action)) {
                updateStudent(request, response);
            } else {
                listStudents(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }

    //  List Students
    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Student> students = studentDao.getAll();
        request.setAttribute("students", students);
        request.getRequestDispatcher("ListStudent.jsp").forward(request, response);
    }

    // Show Form for Adding a New Student
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("AddStudent.jsp").forward(request, response);
    }

    // Show Form for Editing an Existing Student
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String idParam = request.getParameter("id");

        if (idParam == null || idParam.isEmpty()) {
            response.sendRedirect("StudentServlet?action=list&error=missingId");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            response.sendRedirect("StudentServlet?action=list&error=invalidId");
            return;
        }

        Student student = studentDao.getById(id);
        if (student != null) {
            request.setAttribute("student", student);
            request.getRequestDispatcher("EditStudent.jsp").forward(request, response);
        } else {
            response.sendRedirect("StudentServlet?action=list&error=notFound");
        }
    }

    //  Create a New Student
    private void createStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String dateNaissance = request.getParameter("date_naissance");

        System.out.println("Creating Student: " + nom + ", " + prenom + ", " + email + ", " + dateNaissance);

        if (nom == null || prenom == null || email == null || dateNaissance == null ||
                nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || dateNaissance.isEmpty()) {
            response.sendRedirect("AddStudent.jsp?error=missingFields");
            return;
        }

        Student student = new Student();
        student.setNom(nom);
        student.setPrenom(prenom);
        student.setEmail(email);
        student.setDateNaissance(dateNaissance);

        studentDao.create(student);
        response.sendRedirect("StudentServlet?action=list");
    }

    //  Update an Existing Student (Fixed ID Null Issue)
    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String idParam = request.getParameter("id");

        if (idParam == null || idParam.isEmpty()) {
            System.out.println("Error: Missing Student ID!");
            response.sendRedirect("StudentServlet?action=list&error=missingId");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid Student ID!");
            response.sendRedirect("StudentServlet?action=list&error=invalidId");
            return;
        }

        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String dateNaissance = request.getParameter("date_naissance");

        System.out.println("Updating Student ID: " + id);

        if (nom == null || prenom == null || email == null || dateNaissance == null ||
                nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || dateNaissance.isEmpty()) {
            response.sendRedirect("EditStudent.jsp?id=" + id + "&error=missingFields");
            return;
        }

        Student student = new Student();
        student.setId(id);
        student.setNom(nom);
        student.setPrenom(prenom);
        student.setEmail(email);
        student.setDateNaissance(dateNaissance);

        studentDao.update(student);
        response.sendRedirect("StudentServlet?action=list");
    }

    //  Delete a Student
    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String idParam = request.getParameter("id");

        if (idParam == null || idParam.isEmpty()) {
            System.out.println("Error: Missing Student ID!");
            response.sendRedirect("StudentServlet?action=list&error=missingId");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid Student ID!");
            response.sendRedirect("StudentServlet?action=list&error=invalidId");
            return;
        }

        System.out.println("Deleting Student ID: " + id);
        studentDao.delete(id);
        response.sendRedirect("StudentServlet?action=list");
    }
}
