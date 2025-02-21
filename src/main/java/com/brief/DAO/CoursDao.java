package com.brief.DAO;

import com.brief.Model.Cours;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CoursDao {

    public void createCours(Cours cours) throws SQLException {
        String sql = "INSERT INTO courses (nom_cours, description) VALUES (?, ?)";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cours.getNom_cours());
            stmt.setString(2, cours.getDescription());
            stmt.executeUpdate();
            System.out.println("Cours created successfully");
        }
    }

    public List<Cours> getAll() throws SQLException {
        List<Cours> courses = new ArrayList<>();
        String sql = "SELECT * FROM courses";
        try (Connection conn = DbConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cours cours = new Cours();
                cours.setId(rs.getInt("id"));
                cours.setNom_cours(rs.getString("nom_cours"));
                cours.setDescription(rs.getString("description"));
                courses.add(cours);
                System.out.println(cours);
            }
        }
        return courses;
    }

    public Cours getById(int id) throws SQLException {
        Cours cours = null;
        String sql = "SELECT * FROM courses WHERE id = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    cours = new Cours();
                    cours.setId(rs.getInt("id"));
                    cours.setNom_cours(rs.getString("nom_cours"));
                    cours.setDescription(rs.getString("description"));
                    System.out.println(cours);
                }
            }
        }
        return cours;
    }

    public void update(Cours cours) throws SQLException {
        String sql = "UPDATE courses SET nom_cours = ?, description = ? WHERE id = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cours.getNom_cours());
            stmt.setString(2, cours.getDescription());
            stmt.setInt(3, cours.getId());
            stmt.executeUpdate();
            System.out.println("Cours updated successfully");
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM courses WHERE id = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Cours deleted successfully");
        }
    }
}
