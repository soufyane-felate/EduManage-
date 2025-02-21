<%@ page import="com.brief.Model.Student" %>
<%@ page import="com.brief.Model.Cours" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .sidebar {
            height: 100vh;
            background-color: #343a40;
            color: white;
            padding: 20px;
        }
        .sidebar a {
            color: white;
            text-decoration: none;
            display: block;
            padding: 10px;
            margin: 5px 0;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .sidebar a:hover {
            background-color: #495057;
        }
        .main-content {
            padding: 20px;
        }
        .card {
            margin-bottom: 20px;
            border: none;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .table thead {
            background-color: #343a40;
            color: white;
        }
        .table-hover tbody tr:hover {
            background-color: #f1f1f1;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-3 sidebar">
            <h3>Dashboard</h3>
            <a href="AddStudent.jsp"  data-bs-target="#addStudentModal">
                <i class="fas fa-user-plus"></i> Add Student
            </a>
            <a href="AddCours.jsp"  data-bs-target="#addCourseModal">
                <i class="fas fa-book"></i> Add Course
            </a>
            <a href="#listStudents">
                <i class="fas fa-users"></i> List Students
            </a>
        </div>

        <!-- Main Content -->
        <div class="col-md-9 main-content">
            <h2>List of Students with Courses</h2>
            <div class="card">
                <div class="card-body">
                    <table class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Date of Birth</th>
                            <th>Courses</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List<Student> students = (List<Student>) request.getAttribute("students");
                            if (students != null && !students.isEmpty()) {
                                for (Student student : students) {
                        %>
                        <tr>
                            <td><%= student.getId() %></td>
                            <td><%= student.getNom() %> <%= student.getPrenom() %></td>
                            <td><%= student.getEmail() %></td>
                            <td><%= student.getDateNaissance() %></td>
                            <td>

                                <span class="badge bg-primary"></span>
                                <%
                                    }
                                } else {
                                %>
                                <span class="badge bg-secondary">No Courses</span>
                                <%
                                    }
                                %>
                            </td>
                            <td>
                                <a href="#" class="btn btn-sm btn-warning">Edit</a>
                                <a href="#" class="btn btn-sm btn-danger">Delete</a>
                            </td>
                        </tr>

                        <tr>
                            <td colspan="6" class="text-center">No students found.</td>
                        </tr>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>




<!-- Bootstrap 5 JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>