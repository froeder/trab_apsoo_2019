package com.sisac;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection conn = new ConnectionFactory().getConnection();

        System.out.println("Conexao aberta");
        try {
            conn.close();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }

        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + s);
    }
}
