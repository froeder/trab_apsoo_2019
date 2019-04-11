package com.sisac.dao;
import com.sisac.ConnectionFactory;
import com.sisac.models.Aluno;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

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

    public void updateAluno(int id) {
        Connection conn = new ConnectionFactory().getConnection();
        String sql = String.format("UPDATE alunos SET(id, nome, endereco, cidade, " +
                "estado, telefone, data_matricula, data_limite_matricula" + " VALUES(DEFAULT, ?,?,?,?)" +
                "WHERE id=%s", id);
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            // Executa statement
            stmt.execute();
            stmt.close();
            System.out.println("Aluno atualizado");
            conn.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList fetchAlunoByName(String nome) {
        Connection conn = new ConnectionFactory().getConnection();
        String query = String.format("SELECT aluno.nome, aluno.endereco, aluno.cidade, aluno.estado, aluno.telefone" +
                "aluno.data_matricula, aluno.data_limite_matricula FROM alunos " +
                "WHERE aluno.nome LIKE '%%s'", nome);
        ArrayList alunos = new ArrayList<Aluno>();

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            Aluno a;
            while(rs.next()) {
                int id = rs.getInt("id");
                String nomeAluno = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String cidade = rs.getString("cidade");
                String estado = rs.getString("estado");
                String telefone = rs.getString("telefone");
                Date dataMatricula = rs.getDate("data_matricula");
                Date dataLimiteMatricula = rs.getDate("data_limite_matricula");

                LocalDate dataMatriculaAlt = dataMatricula.toLocalDate();
                LocalDate dataLimiteMatriculaAlt = dataLimiteMatricula.toLocalDate();

                a = new Aluno();

                a.setId(id);
                a.setNome(nomeAluno);
                a.setEndereco(endereco);
                a.setCidade(cidade);
                a.setEstado(estado);
                a.setTelefone(telefone);
                a.setDataMatricula(dataMatriculaAlt);
                a.setDataLimiteMatricula(dataLimiteMatriculaAlt);

                alunos.add(a);
            }
            // Executa statement
            stmt.execute();
            stmt.close();
            conn.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }

        return alunos;
    }
}
