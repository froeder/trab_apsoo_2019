package br.ufms.facom.sisac.dao;
import br.ufms.facom.sisac.ConnectionFactory;
import br.ufms.facom.sisac.models.Aluno;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class AlunoDAO {

    public AlunoDAO() {

    }

    public void addAluno(Aluno aluno) {
        Connection con = new ConnectionFactory().getConnection();

        String sql = String.format("INSERT INTO tb_alunos (id, nome, endereco, estado, cidade, telefone, data_matricula, data_limite_matricula) VALUES(NULL,?,?,?,?,?,?,?);");
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEndereco());
            stmt.setString(3, aluno.getEstado());
            stmt.setString(4, aluno.getCidade());
            stmt.setString(5, aluno.getTelefone());
            Date dataMatricula = Date.valueOf(aluno.getDataMatricula());
            stmt.setDate(6, dataMatricula);
            Date dataLimiteMatricula = Date.valueOf(aluno.getDataLimiteMatricula());
            stmt.setDate(7, dataLimiteMatricula);

            // Executa statement
            stmt.execute();
            stmt.close();

            System.out.println("Aluno adicionado");
            con.close();
         }
        catch(SQLException e) {
           e.printStackTrace();
        }
    }

    public void removeAluno(int id) {
        Connection con = new ConnectionFactory().getConnection();
        String sql = String.format("DELETE FROM tb_alunos " +
                "WHERE id=%d", id);
        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            // Executa statement
            stmt.execute();
            stmt.close();
            System.out.println("Aluno removido.");
            con.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAluno(Aluno aluno) {
        Connection con = new ConnectionFactory().getConnection();
        String sql = String.format("UPDATE tb_alunos SET nome=?, endereco=?, estado=?, " +
                "cidade=?, telefone=?, data_matricula=?, data_limite_matricula=? " +
                "WHERE id=%d", aluno.getId());
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEndereco());
            stmt.setString(3, aluno.getEstado());
            stmt.setString(4, aluno.getCidade());
            stmt.setString(5, aluno.getTelefone());
            stmt.setDate(6, Date.valueOf(aluno.getDataMatricula()));
            stmt.setDate(7, Date.valueOf(aluno.getDataLimiteMatricula()));

            // Executa statement
            stmt.execute();
            stmt.close();
            System.out.println("Aluno atualizado");
            con.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Aluno> fetchAlunoByName(String nome) {
        Connection con = new ConnectionFactory().getConnection();
        String query = "SELECT * FROM tb_alunos " +
                "WHERE nome LIKE '" + nome + "%'";
        ArrayList<Aluno> tb_alunos = new ArrayList<>();

        try {
            PreparedStatement stmt = con.prepareStatement(query);
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

                tb_alunos.add(a);
            }
            // Executa statement
            stmt.execute();
            stmt.close();
            con.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }

        return tb_alunos;
    }
}
