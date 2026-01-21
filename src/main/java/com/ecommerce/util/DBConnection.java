package com.ecommerce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável pela ligação à base de dados PostgreSQL
 */
public class DBConnection {

    private static final String URL =
            "jdbc:postgresql://localhost:5434/ecommerce_db";
    private static final String USER = "ecommerce_user";
    private static final String PASSWORD = "ecommerce";

    /**
     * Cria e devolve uma ligação à base de dados
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}