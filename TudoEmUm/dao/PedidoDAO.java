/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.legourmet.dao;

import br.com.legourmet.model.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Caio
 */
public class PedidoDAO {

    public static void inserir(Pedido p) throws ClassNotFoundException,
            SQLException {

        // Busca uma conexao válida
        Connection conn = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        String sql = "INSERT INTO pedidos(qrcode, data_hora_pedido, "
                + " situacao_pedido, valor_pedido, tempo_espera_pedido) VALUES(?, ?, ?, ?, ?)";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        // Informo nele tb que quero buscar a chave gerada 
        //(PreparedStatement.RETURN_GENERATED_KEYS)
        PreparedStatement ps = conn.prepareStatement(sql,
                PreparedStatement.RETURN_GENERATED_KEYS);

        // Nas linhas abaixo faz a substituicao dos parametros informados
        //no SQL, as interrogacoes (?)
        ps.setString(1, p.getQrcode());
        ps.setDate(2, p.getData_HoraPedido());
        ps.setString(3, p.getSituacao_Pedido());
        ps.setDouble(4, p.getValor_Pedido());
        ps.setString(5, p.getTempo_EsperaPedido());

        // Dispara o comando p/ o BD
        ps.executeUpdate();

        // Busca o id (auto-incremento) gerado pelo BD
        ResultSet rs = ps.getGeneratedKeys();

        if (rs.next()) {
            int id = rs.getInt(1);
            p.setId_pedido(id);
        }

        // Fechar conexao
        conn.close();

    }

    ;
    
    public static void alterar(Pedido p) throws ClassNotFoundException,
            SQLException {

        // Busca uma conexao válida
        Connection conn = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        String sql = "UPDATE pedidos "
                + " SET qrcode = ?, "
                + " data_hora_pedido = ?, "
                + " situacao_pedido = ?, "
                + " valor_pedido = ?, "
                + " tempo_espera_pedido = ? "
                + " WHERE id_pedido  = ? ";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        PreparedStatement ps = conn.prepareStatement(sql);

        // Nas linhas abaixo faz a substituicao dos parametros informados
        //no SQL, as interrogacoes (?)
        ps.setString(1, p.getQrcode());
        ps.setDate(2, p.getData_HoraPedido());
        ps.setString(3, p.getSituacao_Pedido());
        ps.setDouble(4, p.getValor_Pedido());
        ps.setString(5, p.getTempo_EsperaPedido());
        ps.setInt(6, p.getId_pedido());

        // Dispara o comando p/ o BD
        ps.executeUpdate();

        // Fechar conexao
        conn.close();

    }

    ;
    
    public static void excluir(Pedido p) throws ClassNotFoundException,
            SQLException {

        // Busca uma conexao válida
        Connection conn = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        String sql = "DELETE FROM pedidos "
                + " WHERE id_pedido  = ? ";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        PreparedStatement ps = conn.prepareStatement(sql);

        // Nas linhas abaixo faz a substituicao dos parametros informados
        //no SQL, as interrogacoes (?)
        ps.setInt(1, p.getId_pedido());

        // Dispara o comando p/ o BD
        ps.executeUpdate();

        // Fechar conexao
        conn.close();

    }

    public static Pedido buscar(int id) throws ClassNotFoundException,
            SQLException {

        // Se o objeto não existir no banco retorna nulo
        Pedido p = null;

        // Busca conexao válida
        Connection conn = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        String sql = "SELECT * FROM pedidos "
                + " WHERE id_pedido = ? ";

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
            p = new Pedido();

            p.setId_pedido(rs.getInt("id_pedido"));
            //p.setIdMesa(rs.getInt("id_mesa"));
            //p.setIdUsuario(rs.getInt("id_usuario"));
            p.setQrcode(rs.getString("qrcode"));
            p.setData_HoraPedido(rs.getDate("data_hora_pedido"));
            p.setSituacao_Pedido(rs.getString("situacao_Pedido"));
            p.setValor_Pedido(rs.getDouble("valor_pedido"));
            p.setTempo_EsperaPedido(rs.getString("tempo_espera_pedido"));

        }

        // Fechar Conexao
        conn.close();

        return p;

    }

    ;
    
    public static ArrayList<Pedido> listar() throws ClassNotFoundException,
            SQLException {

        ArrayList<Pedido> lista = new ArrayList<>();

        // Busca conexao válida
        Connection conn = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        String sql = "SELECT * FROM pedidos ORDER BY id_pedido ";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        PreparedStatement ps = conn.prepareStatement(sql);

        // Dispara o comando p/ o BD
        ResultSet rs = ps.executeQuery();

        // Verfica se possui registro do BD
        while (rs.next()) {

            // Cria e abastece o objeto
            Pedido p = new Pedido();

            p.setId_pedido(rs.getInt("id_pedido"));
            p.setId_pedido(rs.getInt("id_pedido"));
            p.setId_mesa(rs.getInt("id_mesa"));
            p.setId_usuario(rs.getInt("id_usuario"));
            p.setData_HoraPedido(rs.getDate("data_hora_pedido"));
            p.setSituacao_Pedido(rs.getString("situacao_pedido"));
            p.setValor_Pedido(rs.getDouble("valor_pedido"));
            p.setTempo_EsperaPedido(rs.getString("tempo_espera_pedido"));

            // Acrescenta na lista de dados 
            lista.add(p);
        }

        // Fechar Conexao
        conn.close();

        return lista;
    }
    
    public static ArrayList<Pedido> listarPorSituacao(String pedido) throws ClassNotFoundException,
            SQLException {

        ArrayList<Pedido> lista = new ArrayList<>();

        // Busca conexao válida
        Connection conn = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        pedido = "%"+pedido+"%";
        String sql = "SELECT * FROM pedidos WHERE situacao_pedido ORDER BY situacao_pedido ";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        PreparedStatement ps = conn.prepareStatement(sql);

        // Dispara o comando p/ o BD
        ResultSet rs = ps.executeQuery();

        // Verfica se possui registro do BD
        while (rs.next()) {

            // Cria e abastece o objeto
            Pedido p = new Pedido();

            p.setId_pedido(rs.getInt("id_pedido"));
            p.setId_mesa(rs.getInt("id_mesa"));
            p.setId_usuario(rs.getInt("id_usuario"));
            p.setData_HoraPedido(rs.getDate("data_hora_pedido"));
            p.setSituacao_Pedido(rs.getString("situacao_pedido"));
            p.setValor_Pedido(rs.getDouble("valor_pedido"));
            p.setTempo_EsperaPedido(rs.getString("tempo_espera_pedido"));

            // Acrescenta na lista de dados 
            lista.add(p);
        }

        // Fechar Conexao
        conn.close();

        return lista;
    }
}
