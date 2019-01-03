/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.legourmet.dao;

import br.com.legourmet.model.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Caio
 */
public class ReservaDAO {
    
    public static void excluir(Reserva r) throws ClassNotFoundException,
            SQLException {

        // Busca uma conexao válida
        Connection conn = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        String sql = "DELETE FROM reservas "
                + " WHERE id_reserva  = ? ";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        PreparedStatement ps = conn.prepareStatement(sql);

        // Nas linhas abaixo faz a substituicao dos parametros informados
        //no SQL, as interrogacoes (?)
        ps.setInt(1, r.getId_reserva());

        // Dispara o comando p/ o BD
        ps.executeUpdate();

        // Fechar conexao
        conn.close();

    }

    ;
    
    public static Reserva buscar(int id) throws ClassNotFoundException,
            SQLException {

        // Se o objeto não existir no banco retorna nulo
        Reserva r = null;

        // Busca conexao válida
        Connection conn = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        String sql = "SELECT * FROM reservas "
                + " WHERE id_reservas = ? ";

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
            r = new Reserva();

            r.setId_reserva(rs.getInt("id_reserva"));
            r.setData_hora_reserva(rs.getDate("data_hora_reserva"));

        }

        // Fechar Conexao
        conn.close();

        return r;

    }

    ;
    
    public static ArrayList<Reserva> listar() throws ClassNotFoundException,
            SQLException {

        ArrayList<Reserva> lista = new ArrayList<>();

        // Busca conexao válida
        Connection conn = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        String sql = "SELECT * FROM reservas ORDER BY id_reserva ";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        PreparedStatement ps = conn.prepareStatement(sql);

        // Dispara o comando p/ o BD
        ResultSet rs = ps.executeQuery();

        // Verfica se possui registro do BD
        while (rs.next()) {

            // Cria e abastece o objeto
            Reserva r = new Reserva();

            r.setId_reserva(rs.getInt("id_reserva"));
            r.setData_hora_reserva(rs.getDate("data_hora_reserva"));

            // Acrescenta na lista de dados 
            lista.add(r);
        }

        // Fechar Conexao
        conn.close();

        return lista;
    }
    
}
