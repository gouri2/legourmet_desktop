/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.legourmet.dao;

import br.com.legourmet.model.Mesa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Caio
 */
public class MesaDAO {

    public static void inserir(Mesa m) throws ClassNotFoundException,
            SQLException {

        // Busca uma conexao válida
        Connection conn = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        String sql = "INSERT INTO mesas(disponivel, numero_mesa) VALUES(?, ?)";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        // Informo nele tb que quero buscar a chave gerada 
        //(PreparedStatement.RETURN_GENERATED_KEYS)
        PreparedStatement ps = conn.prepareStatement(sql,
                PreparedStatement.RETURN_GENERATED_KEYS);

        // Nas linhas abaixo faz a substituicao dos parametros informados
        //no SQL, as interrogacoes (?)
        ps.setBoolean(1, m.isDisponivel());
        ps.setInt(2, m.getNumero_Mesa());

        // Dispara o comando p/ o BD
        ps.executeUpdate();

        // Busca o id (auto-incremento) gerado pelo BD
        ResultSet rs = ps.getGeneratedKeys();

        if (rs.next()) {
            int id = rs.getInt(1);
            m.setId_mesa(id);
        }

        // Fechar conexao
        conn.close();

    } 
    
    public static void alterar(Mesa m) throws ClassNotFoundException,
            SQLException {

        // Busca uma conexao válida
        Connection conn = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        String sql = "UPDATE mesas "
                + " SET disponivel = ?, "
                + " numero_mesa = ?, "
                + " WHERE id_mesa  = ? ";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        PreparedStatement ps = conn.prepareStatement(sql);

        // Nas linhas abaixo faz a substituicao dos parametros informados
        //no SQL, as interrogacoes (?)
        ps.setBoolean(1, m.isDisponivel());
        ps.setInt(2, m.getNumero_Mesa());
        ps.setInt(3, m.getId_mesa());

        // Dispara o comando p/ o BD
        ps.executeUpdate();

        // Fechar conexao
        conn.close();

    }

    ;
    
    public static void excluir(Mesa m) throws ClassNotFoundException,
            SQLException {

        // Busca uma conexao válida
        Connection conn = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        String sql = "DELETE FROM mesas "
                + " WHERE id_mesa  = ? ";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        PreparedStatement ps = conn.prepareStatement(sql);

        // Nas linhas abaixo faz a substituicao dos parametros informados
        //no SQL, as interrogacoes (?)
        ps.setInt(1, m.getId_mesa());

        // Dispara o comando p/ o BD
        ps.executeUpdate();

        // Fechar conexao
        conn.close();

    }

    ;
    
    public static Mesa buscar(int id) throws ClassNotFoundException,
            SQLException {

        // Se o objeto não existir no banco retorna nulo
        Mesa m = null;

        // Busca conexao válida
        Connection conn = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        String sql = "SELECT * FROM mesas "
                + " WHERE id_mesa = ? ";

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
            m = new Mesa();

            m.setId_mesa(rs.getInt("id_mesa"));
            m.setDisponivel(rs.getBoolean("diponivel"));
            m.setNumero_Mesa(rs.getInt("numero_mesa"));

        }

        // Fechar Conexao
        conn.close();

        return m;

    }

    ;
    
    public static ArrayList<Mesa> listar() throws ClassNotFoundException,
            SQLException {

        ArrayList<Mesa> lista = new ArrayList<>();

        // Busca conexao válida
        Connection conn = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        String sql = "SELECT * FROM mesas ORDER BY id_mesa ";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        PreparedStatement ps = conn.prepareStatement(sql);

        // Dispara o comando p/ o BD
        ResultSet rs = ps.executeQuery();

        // Verfica se possui registro do BD
        while (rs.next()) {

            // Cria e abastece o objeto
            Mesa m = new Mesa();

            m.setId_mesa(rs.getInt("id_mesa"));
            m.setDisponivel(rs.getBoolean("diponivel"));
            m.setNumero_Mesa(rs.getInt("numero_mesa"));

            // Acrescenta na lista de dados 
            lista.add(m);
        }

        // Fechar Conexao
        conn.close();

        return lista;
    }
    
    public static ArrayList<Mesa> listarPorNumero(String mesa) throws ClassNotFoundException,
            SQLException {

        ArrayList<Mesa> lista = new ArrayList<>();

        // Busca conexao válida
        Connection conn = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        mesa = "%"+mesa+"%";
        String sql = "SELECT * FROM mesas WHERE numero_mesa ORDER BY id_mesa ";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        PreparedStatement ps = conn.prepareStatement(sql);

        // Dispara o comando p/ o BD
        ResultSet rs = ps.executeQuery();

        // Verfica se possui registro do BD
        while (rs.next()) {

            // Cria e abastece o objeto
            Mesa m = new Mesa();

            m.setId_mesa(rs.getInt("id_mesa"));
            m.setDisponivel(rs.getBoolean("diponivel"));
            m.setNumero_Mesa(rs.getInt("numero_mesa"));

            // Acrescenta na lista de dados 
            lista.add(m);
        }

        // Fechar Conexao
        conn.close();

        return lista;
    }
}
