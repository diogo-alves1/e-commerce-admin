package com.ecommerce.dao;

import com.ecommerce.model.Produkt;
import com.ecommerce.util.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduktDAO {

    public List<Produkt> findAll() {
        List<Produkt> produkte = new ArrayList<>();
        String sql = "SELECT * FROM produkt";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Produkt p = new Produkt(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("preis"),
                        rs.getInt("lagerbestand"),
                        rs.getString("kategorie")
                );
                produkte.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produkte;
    }

    public void insert(Produkt produkt) {
        String sql = "INSERT INTO produkt (name, preis, lagerbestand, kategorie) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produkt.getName());
            stmt.setDouble(2, produkt.getPreis());
            stmt.setInt(3, produkt.getLagerbestand());
            stmt.setString(4, produkt.getKategorie());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM produkt WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
