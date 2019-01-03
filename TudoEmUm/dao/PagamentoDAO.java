/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.legourmet.dao;

import br.com.legourmet.model.Pagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Caio
 */
public class PagamentoDAO {

    public static void inserir(Pagamento p) throws ClassNotFoundException,
            SQLException {

        // Busca uma conexao válida
        Connection conn = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        String sql = "INSERT INTO pagamentos(valor_total, forma_pagamento) VALUES(?, ?)";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        // Informo nele tb que quero buscar a chave gerada 
        //(PreparedStatement.RETURN_GENERATED_KEYS)
        PreparedStatement ps = conn.prepareStatement(sql,
                PreparedStatement.RETURN_GENERATED_KEYS);

        // Nas linhas abaixo faz a substituicao dos parametros informados
        //no SQL, as interrogacoes (?)
        ps.setDouble(1, p.getValor_Total());
        ps.setString(2, p.getForma_Pagamento());

        // Dispara o comando p/ o BD
        ps.executeUpdate();

        // Busca o id (auto-incremento) gerado pelo BD
        ResultSet rs = ps.getGeneratedKeys();

        if (rs.next()) {
            int id = rs.getInt(1);
            p.setId_pagamento(id);
        }

        // Fechar conexao
        conn.close();

    }

    ;
    
    public static void alterar(Pagamento p) throws ClassNotFoundException,
            SQLException {

        // Busca uma conexao válida
        Connection conn = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        String sql = "UPDATE pagamentos "
                + " SET valor_total = ?, "
                + " forma_pagamento = ?, "
                + " WHERE id_pagamento  = ? ";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        PreparedStatement ps = conn.prepareStatement(sql);

        // Nas linhas abaixo faz a substituicao dos parametros informados
        //no SQL, as interrogacoes (?)
        ps.setDouble(1, p.getValor_Total());
        ps.setString(2, p.getForma_Pagamento());
        ps.setInt(3, p.getId_pagamento());

        // Dispara o comando p/ o BD
        ps.executeUpdate();

        // Fechar conexao
        conn.close();

    }

    ;
    
    public static void excluir(Pagamento p) throws ClassNotFoundException,
            SQLException {

        // Busca uma conexao válida
        Connection conn = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        String sql = "DELETE FROM pagamentos "
                + " WHERE id_pagamento  = ? ";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        PreparedStatement ps = conn.prepareStatement(sql);

        // Nas linhas abaixo faz a substituicao dos parametros informados
        //no SQL, as interrogacoes (?)
        ps.setInt(1, p.getId_pagamento());

        // Dispara o comando p/ o BD
        ps.executeUpdate();

        // Fechar conexao
        conn.close();

    }

    ;
    
    public static Pagamento buscar(int id) throws ClassNotFoundException,
            SQLException {

        // Se o objeto não existir no banco retorna nulo
        Pagamento p = null;

        // Busca conexao válida
        Connection conn = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        String sql = "SELECT * FROM pagamentos "
                + " WHERE id_pagamento = ? ";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        PreparedStatement ps = conn.prepareStatement(sql);

        // Nas linhas abaixo faz a substituicao dos parametros informados
        //no SQL, as interrogacoes (?)
        ps.setInt(1, id);

        // Dispara o comando p/ o BD
        ResultSet rs = ps.executeQuery();

        // Verfica se possui registro do BD
        if (rs.next()) {

            // Cria e abastece o objeto
            //Usuario p = new Usuario();
            // Mesa p = new Mesa();
            p = new Pagamento();

            //p.setIdPedido(rs.getInt("id_pedido"));
            p.setId_pagamento(rs.getInt("id_pagamento"));
            p.setValor_Total(rs.getDouble("valor_total"));
            p.setForma_Pagamento(rs.getString("forma_pagamento"));

        }

        // Fechar Conexao
        conn.close();

        return p;

    }

    ;
    
    public static ArrayList<Pagamento> listar() throws ClassNotFoundException,
            SQLException {

        ArrayList<Pagamento> lista = new ArrayList<>();

        // Busca conexao válida
        Connection conn = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        String sql = "SELECT * FROM pagamentos ORDER BY id_pagamento ";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        PreparedStatement ps = conn.prepareStatement(sql);

        // Dispara o comando p/ o BD
        ResultSet rs = ps.executeQuery();

        // Verfica se possui registro do BD
        while (rs.next()) {

            // Cria e abastece o objeto
            Pagamento p = new Pagamento();

            //p.setId_pedido(rs.getInt("id_pedido"));
            p.setId_pagamento(rs.getInt("id_pagamento"));
            // p.setId_usuario(rs.getInt("id_usuario"));
            p.setValor_Total(rs.getDouble("valor_total"));
            p.setForma_Pagamento(rs.getString("forma_pagamento"));

            // Acrescenta na lista de dados 
            lista.add(p);
        }

        // Fechar Conexao
        conn.close();

        return lista;
    }
    
    public static ArrayList<Pagamento> listarPorNome(String pagamento) throws ClassNotFoundException,
            SQLException {

        ArrayList<Pagamento> lista = new ArrayList<>();

        // Busca conexao válida
        Connection conn = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        pagamento= "%"+pagamento+"%";
        String sql = "SELECT * FROM pagamentos WHERE n ORDER BY id_pagamento ";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        PreparedStatement ps = conn.prepareStatement(sql);

        // Dispara o comando p/ o BD
        ResultSet rs = ps.executeQuery();

        // Verfica se possui registro do BD
        while (rs.next()) {

            // Cria e abastece o objeto
            Pagamento p = new Pagamento();

            //p.setId_pedido(rs.getInt("id_pedido"));
            p.setId_pagamento(rs.getInt("id_pagamento"));
            // p.setId_usuario(rs.getInt("id_usuario"));
            p.setValor_Total(rs.getDouble("valor_total"));
            p.setForma_Pagamento(rs.getString("forma_pagamento"));

            // Acrescenta na lista de dados 
            lista.add(p);
        }

        // Fechar Conexao
        conn.close();

        return lista;
    }

}
