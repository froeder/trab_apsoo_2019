package br.ufms.facom.sisac.dao;
import br.ufms.facom.sisac.ConnectionFactory;
import br.ufms.facom.sisac.models.Aluno;
import br.ufms.facom.sisac.models.Pagamento;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class PagamentoDAO {

    public PagamentoDAO() {

    }

    public void addPagamento(Pagamento pagamento) {
        Connection con = new ConnectionFactory().getConnection();

        String sql = String.format("INSERT INTO tb_pagamentos (id, valor, data, tipo) VALUES(NULL,?,?,?);");
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setDouble(1, pagamento.getAluno().getValorMensalidade());
            Date data = Date.valueOf(pagamento.getData());
            stmt.setDate(2, data);
            stmt.setString(3, pagamento.getTipo());

            // Executa statement
            stmt.execute();
            stmt.close();

            System.out.println("Pagamento adicionado");
            con.close();
         }
        catch(SQLException e) {
           e.printStackTrace();
        }
    }

    public void removePagamento(int id) {
        Connection con = new ConnectionFactory().getConnection();
        String sql = String.format("DELETE FROM tb_pagamentos " +
                "WHERE id=%d", id);
        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            // Executa statement
            stmt.execute();
            stmt.close();
            System.out.println("Pagamento removido.");
            con.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePagamento(Pagamento pagamento) {
        Connection con = new ConnectionFactory().getConnection();
        String sql = String.format("UPDATE tb_pagamentos SET valor=?, data=?, tipo=? " + "WHERE id=%d", pagamento.getId());
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setDouble(1, pagamento.getAluno().getValorMensalidade());
            Date data = Date.valueOf(pagamento.getData());
            stmt.setDate(2, data);
            stmt.setString(3, pagamento.getTipo());

            // Executa statement
            stmt.execute();
            stmt.close();
            System.out.println("Pagamento atualizado");
            con.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Pagamento> fetchPagamentos(Aluno aluno) {
        Connection con = new ConnectionFactory().getConnection();
        String query = "SELECT * FROM tb_pagamentos;";
        ArrayList<Pagamento> tb_pagamentos = new ArrayList<>();

        try {
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            Pagamento a;
            while(rs.next()) {
                int id = rs.getInt("id");
                double valor = rs.getDouble("valor");
                Date data = rs.getDate("data");
                LocalDate dataAux = data.toLocalDate();
                String tipo = rs.getString("tipo");

                a = new Pagamento(aluno);

                a.setId(id);
                a.setData(dataAux);
                a.setTipo(tipo);

                tb_pagamentos.add(a);
            }
            // Executa statement
            stmt.execute();
            stmt.close();
            con.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }

        return tb_pagamentos;
    }
}
