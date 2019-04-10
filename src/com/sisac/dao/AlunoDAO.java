package com.sisac.dao;
import com.sisac.ConnectionFactory;
import com.sisac.models.Aluno;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlunoDAO {

    public AlunoDAO() {
    }

    public void addAluno(Aluno aluno) {
        Connection conn = new ConnectionFactory().getConnection();
        String sql = String.format("INSERT INTO alunos(id, nome, endereco, cidade, " +
                "estado, telefone, data_matricula, data_limite_matricula" + " VALUES(DEFAULT, ?,?,?,?)");
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getEndereco());
            stmt.setString(4, aluno.getCidade());
            stmt.setString(5, aluno.getEstado());
            stmt.setString(6, aluno.getTelefone());
            Date dataMatricula = Date.valueOf(aluno.getDataMatricula());
            stmt.setDate(6, dataMatricula);

            // Executa statement
            stmt.execute();
            stmt.close();
            System.out.println("Aluno adicionado");
            conn.close();
         }
        catch(SQLException e) {
           e.printStackTrace();
        }
    }

    public void removeAluno(int id) {
        Connection conn = new ConnectionFactory().getConnection();
        String sql = String.format("DELETE aluno FROM alunos" +
                "WHERE aluno.id=%d", id);
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            // Executa statement
            stmt.execute();
            stmt.close();
            System.out.println("Aluno removido.");
            conn.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
