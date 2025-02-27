package com.brief.DAO;

import com.brief.Model.Student;
import com.brief.Model.Cours;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDao {

    // Add or create
    public void create(Student student) throws SQLException {
        String sql = "INSERT INTO students (nom, prenom, email, date_naissance) VALUES (?, ?, ?, ?)";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getNom());
            stmt.setString(2, student.getPrenom());
            stmt.setString(3, student.getEmail());
            stmt.setDate(4, Date.valueOf(student.getDateNaissance()));
            stmt.executeUpdate();
        }
    }

    // Read or display all students
    public List<Student> getAll() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = DbConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setNom(rs.getString("nom"));
                student.setPrenom(rs.getString("prenom"));
                student.setEmail(rs.getString("email"));
                student.setDateNaissance(rs.getDate("date_naissance").toString());
                List<Cours> courses = getCoursesByStudentId(student.getId());
                student.setCourses(courses);

                students.add(student);
            }
        }
        return students;
    }

    // Read or display a student by ID
    public Student getById(int id) throws SQLException {
        Student student = null;
        String sql = "SELECT * FROM students WHERE id = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    student = new Student();
                    student.setId(rs.getInt("id"));
                    student.setNom(rs.getString("nom"));
                    student.setPrenom(rs.getString("prenom"));
                    student.setEmail(rs.getString("email"));
                    student.setDateNaissance(rs.getDate("date_naissance").toString());
                }
            }
        }
        return student;
    }

    // Update a student
    public void update(Student student) throws SQLException {
        String query = "UPDATE students SET nom = ?, prenom = ?, email = ?, date_naissance = ? WHERE id = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, student.getNom());
            stmt.setString(2, student.getPrenom());
            stmt.setString(3, student.getEmail());
            stmt.setDate(4, Date.valueOf(student.getDateNaissance()));
            stmt.setInt(5, student.getId());
            stmt.executeUpdate();
        }
    }

    // Delete a student by ID
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM students WHERE id = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // Enroll a student in a course
    public void enrollStudentInCourse(int studentId, int courseId) throws SQLException {
        String sql = "INSERT INTO enrollments (student_id, course_id, date_inscription) VALUES (?, ?, ?)";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            stmt.setInt(2, courseId);
            stmt.setDate(3, new java.sql.Date(System.currentTimeMillis())); // Current date
            stmt.executeUpdate();
        }
    }

    public List<Cours> getCoursesByStudentId(int studentId) throws SQLException {
        List<Cours> courses = new ArrayList<>();
        String sql = "SELECT c.* FROM courses c JOIN enrollments e ON c.id = e.course_id WHERE e.student_id = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Cours cours = new Cours();
                    cours.setId(rs.getInt("id"));
                    cours.setNom_cours(rs.getString("nom_cours"));
                    cours.setDescription(rs.getString("description"));
                    courses.add(cours);
                }
            }
        }
        return courses;
    }

    public List<Student> getAllStudentsWithCourses() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT s.id, s.nom, s.prenom, s.email, s.date_naissance, c.id AS course_id, c.nom_cours, c.description " +
                "FROM students s " +
                "LEFT JOIN enrollments e ON s.id = e.student_id " +
                "LEFT JOIN courses c ON e.course_id = c.id";
        try (Connection conn = DbConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            Map<Integer, Student> studentMap = new HashMap<>();
            while (rs.next()) {
                int studentId = rs.getInt("id");
                Student student = studentMap.get(studentId);
                if (student == null) {
                    student = new Student();
                    student.setId(studentId);
                    student.setNom(rs.getString("nom"));
                    student.setPrenom(rs.getString("prenom"));
                    student.setEmail(rs.getString("email"));
                    student.setDateNaissance(rs.getDate("date_naissance").toString());
                    student.setCourses(new ArrayList<>());
                    studentMap.put(studentId, student);
                    students.add(student);
                }

                int courseId = rs.getInt("course_id");
                if (courseId > 0) {
                    Cours cours = new Cours();
                    cours.setId(courseId);
                    cours.setNom_cours(rs.getString("nom_cours"));
                    cours.setDescription(rs.getString("description"));
                    student.getCourses().add(cours);
                }
            }
        }
        return students;
    }



}