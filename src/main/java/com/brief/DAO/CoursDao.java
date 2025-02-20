package com.brief.DAO;



import com.brief.Model.Cours;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CoursDao {

    public void createCours(Cours cours) throws SQLException {
        String sql = "INSERT INTO  courses (nom_cours, descrption) VALUES (?, ?)";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cours.getNom_cours());
            stmt.setString(2, cours.getDescrption());
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
                cours.setNom_cours(rs.getString("nom_cours"));
                cours.setDescrption(rs.getString("descrption"));
                courses.add(cours);
            }
        }


        return courses;
    }
public Cours getByID( int id)throws SQLException {
    Cours cours = null;
    String sql = "SELECT * FROM courses WHERE nom_cours = ?";
    try (Connection conn = DbConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                cours = new Cours();
                cours.setNom_cours(rs.getString("nom_cours"));
                cours.setDescrption(rs.getString("descrption"));

            }
        }
    }
    return cours;
}
public void update(Cours cours) throws SQLException {
    String query = "UPDATE courses SET nom_cours = ?, descrption = ? WHERE id = ?";
    try (Connection conn = DbConnection.getConnection();
    PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1, cours.getNom_cours());
        stmt.setString(2, cours.getDescrption());
        stmt.setInt(3, cours.getId());
        stmt.executeUpdate();
    }
}
public void delete(int id) throws SQLException {
        String sql = "DELETE FROM courses WHERE id = ?";
        try (Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
}
public void deleteAll() throws SQLException {
        String sql = "DELETE FROM courses";
        try (Connection conn = DbConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                delete(rs.getInt("id"));

            }
        }
}
}