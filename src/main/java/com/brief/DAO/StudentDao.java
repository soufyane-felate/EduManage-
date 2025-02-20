package com.brief.DAO;

import com.brief.Model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    // Delete all students
    public void deleteAll() throws SQLException {
        String query = "DELETE FROM students";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.executeUpdate();
        }
    }
}