/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.legourmet.dao;

import br.com.legourmet.model.Item;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Caio
 */
public class ItemDAO {

    private static Connection conexao;

    public ItemDAO() {
        conexao = ConnectionFactory.getConnection();
    }

    // Insere um item no banco
    public static void inserir(Item i) throws SQLException {

        // Busca uma conexao válida
        Connection con = ConnectionFactory.getConnection();
        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        String sql = "INSERT INTO itens(img_item, nome_item, "
                + " categoria, disponivel, ingredientes,  tempo_preparo_item, valor_item) VALUES(?, ?, ?, ?, ?, ?, ?)";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        // Informo nele tb que quero buscar a chave gerada 
        //(PreparedStatement.RETURN_GENERATED_KEYS)
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, i.getImg_Item());
            ps.setString(2, i.getNome_Item());
            ps.setString(3, i.getCategoria());
            ps.setString(4, i.getDisponivel());
            ps.setString(5, i.getIngredientes());
            ps.setInt(6, i.getTempo_Preparo_Item());
            ps.setDouble(7, i.getValor_Item());

            ps.executeUpdate();

            // Busca o id (auto-incremento) gerado pelo BD
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                int id = rs.getInt(1);
                i.setId_item(id);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no acesso ao banco de dados - " + ex.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                // Fechar conexao
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão - " + ex.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        }

        // Nas linhas abaixo faz a substituicao dos parametros informados
        //no SQL, as interrogacoes (?)
        // Dispara o comando p/ o BD
        //conexao.close();
    }

    
    
    public static void alterar(Item i) throws ClassNotFoundException,
            SQLException {

        // Busca uma conexao válida
        Connection conexao = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        String sql = "UPDATE itens "
                + " SET img_item = ?, "
                + " nome_item = ?, "
                + " categoria = ?, "
                + " disponivel = ?, "
                + " ingredientes = ? "
                + " tempo_preparo_item = ? "
                + " valor_item = ? "
                + " WHERE id_usuario  = ? ";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        PreparedStatement ps = conexao.prepareStatement(sql);

        //Calendar c = Calendar.getInstance();
        // Nas linhas abaixo faz a substituicao dos parametros informados
        //no SQL, as interrogacoes (?)
        ps.setString(1, i.getImg_Item());
        ps.setString(2, i.getNome_Item());
        ps.setString(3, i.getCategoria());
        ps.setString(4, i.getDisponivel());
        ps.setString(5, i.getIngredientes());
        ps.setInt(6, i.getTempo_Preparo_Item());
        ps.setDouble(7, i.getValor_Item());
        ps.setInt(7, i.getId_item());

        // Dispara o comando p/ o BD
        ps.executeUpdate();

        // Fechar conexao
        conexao.close();

    }

    ;
    
    public static void excluir(Item i) throws ClassNotFoundException,
            SQLException {

        // Busca uma conexao válida
        Connection conexao = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        String sql = "DELETE FROM itens "
                + " WHERE id_item  = ? ";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        PreparedStatement ps = conexao.prepareStatement(sql);

        // Nas linhas abaixo faz a substituicao dos parametros informados
        //no SQL, as interrogacoes (?)
        ps.setInt(1, i.getId_item());

        // Dispara o comando p/ o BD
        ps.executeUpdate();

        // Fechar conexao
        conexao.close();

    }

    ;
    
    public static Item buscarId(int id) throws ClassNotFoundException,
            SQLException {

        // Se o objeto não existir no banco retorna nulo
        Item i = null;

        // Busca conexao válida
        Connection conexao = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        String sql = "SELECT * FROM itens "
                + " WHERE id_item = ? ";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        PreparedStatement ps = conexao.prepareStatement(sql);

        // Nas linhas abaixo faz a substituicao dos parametros informados
        //no SQL, as interrogacoes (?)
        ps.setInt(1, id);

        // Dispara o comando p/ o BD
        ResultSet rs = ps.executeQuery();

        // Verfica se possui registro do BD
        if (rs.next()) {

            // Cria e abastece o objeto
            i = new Item();

            i.setId_item(rs.getInt("id_item"));
            i.setImg_Item(rs.getString("img_item"));
            i.setNome_Item(rs.getString("nome_item"));
            i.setCategoria(rs.getString("categoria"));
            i.setDisponivel(rs.getString("disponivel"));
            i.setIngredientes(rs.getString("ingredientes"));
            i.setValor_Item(rs.getDouble("valor_item"));
            i.setTempo_Preparo_Item(rs.getInt("tempo_preparo_item"));

        }

        // Fechar Conexao
        conexao.close();

        return i;

    }

    ;
    
    public static ArrayList<Item> listar() throws ClassNotFoundException,
            SQLException {

        ArrayList<Item> lista = new ArrayList<>();

        // Busca conexao válida
        Connection conexao = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        String sql = "SELECT * FROM itens ORDER BY id_item ";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        PreparedStatement ps = conexao.prepareStatement(sql);

        // Dispara o comando p/ o BD
        ResultSet rs = ps.executeQuery();

        // Verfica se possui registro do BD
        while (rs.next()) {

            // Cria e abastece o objeto
            Item i = new Item();

            i.setImg_Item(rs.getString("img_item"));
            i.setNome_Item(rs.getString("nome_item"));
            i.setCategoria(rs.getString("categoria"));
            i.setDisponivel(rs.getString("disponivel"));
            i.setIngredientes(rs.getString("ingredientes"));
            i.setValor_Item(rs.getDouble("valor_item"));
            i.setTempo_Preparo_Item(rs.getInt("tempo_preparo_item"));

            // Acrescenta na lista de dados 
            lista.add(i);
        }

        // Fechar Conexao
        conexao.close();

        return lista;
    }

    public static ArrayList<Item> listarPorCategoria(String categoria) throws ClassNotFoundException,
            SQLException {

        ArrayList<Item> lista = new ArrayList<>();

        // Busca conexao válida
        Connection conexao = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        categoria = "%" + categoria + "%";
        String sql = "SELECT * FROM itens WHERE categoria LIKE ? ORDER BY id_item ";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, categoria);

        // Dispara o comando p/ o BD
        ResultSet rs = ps.executeQuery();

        // Verfica se possui registro do BD
        while (rs.next()) {

            // Cria e abastece o objeto
            Item i = new Item();

//            i.setImg_Item(rs.getBlob("img_item"));
            i.setImg_Item(rs.getString("img_item"));
            i.setNome_Item(rs.getString("nome_item"));
            i.setCategoria(rs.getString("categoria"));
            i.setDisponivel(rs.getString("disponivel"));
            i.setIngredientes(rs.getString("ingredientes"));
            i.setValor_Item(rs.getDouble("valor_item"));
//            i.setTempo_Preparo_Item(rs.getString("tempo_preparo_item"));
            i.setTempo_Preparo_Item(rs.getInt("tempo_preparo_item"));

            // Acrescenta na lista de dados 
            lista.add(i);
        }

        // Fechar Conexao
        conexao.close();

        return lista;
    }

    public static ArrayList<Item> listarPorItem(String item) throws ClassNotFoundException,
            SQLException {

        ArrayList<Item> lista = new ArrayList<>();

        // Busca conexao válida
        Connection conexao = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        item = "%" + item + "%";
        String sql = "SELECT * FROM itens WHERE item LIKE ? ORDER BY id_item ";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, item);

        // Dispara o comando p/ o BD
        ResultSet rs = ps.executeQuery();

        // Verfica se possui registro do BD
        while (rs.next()) {

            // Cria e abastece o objeto
            Item i = new Item();

//            i.setImg_Item(rs.getBlob("img_item"));
            i.setImg_Item(rs.getString("img_item"));
            i.setNome_Item(rs.getString("nome_item"));
            i.setCategoria(rs.getString("categoria"));
            i.setDisponivel(rs.getString("disponivel"));
            i.setIngredientes(rs.getString("ingredientes"));
            i.setValor_Item(rs.getDouble("valor_item"));
//            i.setTempo_Preparo_Item(rs.getString("tempo_preparo_item"));
            i.setTempo_Preparo_Item(rs.getInt("tempo_preparo_item"));

            // Acrescenta na lista de dados 
            lista.add(i);
        }

        // Fechar Conexao
        conexao.close();

        return lista;
    }

    public static ArrayList<Item> listarPorDisponibilidade(String disponivel) throws ClassNotFoundException,
            SQLException {

        ArrayList<Item> lista = new ArrayList<>();

        // Busca conexao válida
        Connection conexao = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        disponivel = "%" + disponivel + "%";
        String sql = "SELECT * FROM itens WHERE disponivel LIKE ? ORDER BY id_item ";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, disponivel);

        // Dispara o comando p/ o BD
        ResultSet rs = ps.executeQuery();

        // Verfica se possui registro do BD
        while (rs.next()) {

            // Cria e abastece o objeto
            Item i = new Item();

//            i.setImg_Item(rs.getBlob("img_item"));
            i.setImg_Item(rs.getString("img_item"));
            i.setNome_Item(rs.getString("nome_item"));
            i.setCategoria(rs.getString("categoria"));
            i.setDisponivel(rs.getString("disponivel"));
            i.setIngredientes(rs.getString("ingredientes"));
            i.setValor_Item(rs.getDouble("valor_item"));
//            i.setTempo_Preparo_Item(rs.getString("tempo_preparo_item"));
            i.setTempo_Preparo_Item(rs.getInt("tempo_preparo_item"));

            // Acrescenta na lista de dados 
            lista.add(i);
        }

        // Fechar Conexao
        conexao.close();

        return lista;
    }

    public static ArrayList<String> buscarCategorias() throws ClassNotFoundException, SQLException {
        // Busca conexao válida
        Connection conexao = ConnectionFactory.getConnection();

        ArrayList<String> bgData;
        bgData = new ArrayList<String>();
        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        String sql = "SELECT categoria FROM bd_legourmet.itens IF EXISTS";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        PreparedStatement ps = conexao.prepareStatement(sql);

        // Nas linhas abaixo faz a substituicao dos parametros informados
        //no SQL, as interrogacoes (?)
//        ps.setInt(1, id);
//
//        // Dispara o comando p/ o BD
        ResultSet rs = ps.executeQuery("SELECT * FROM itens");

        while (rs.next()) {
            bgData.add(rs.getString("categoria"));

            //choiceCategoria4.addItem(bgData.toString());
        }
//        // Verfica se possui registro do BD
//        if (rs.next()) {
//
//            // Cria e abastece o objeto
//            i = new Item();
//
//            i.setId_item(rs.getInt("id_item"));
//            i.setImg_Item(rs.getString("img_item"));
//            i.setNome_Item(rs.getString("nome_item"));
//            i.setCategoria(rs.getString("categoria"));
//            i.setDisponivel(rs.getString("disponivel"));
//            i.setIngredientes(rs.getString("ingredientes"));
//            i.setValor_Item(rs.getDouble("valor_item"));
//            i.setTempo_Preparo_Item(rs.getInt("tempo_preparo_item"));
//
//        }
//
//        // Fechar Conexao
        conexao.close();
//
        return bgData;
    }

}
