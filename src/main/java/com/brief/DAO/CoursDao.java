package com.brief.DAO;



import com.brief.Model.Cours;
import com.mysql.cj.x.protobuf.MysqlxCrud;

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

}