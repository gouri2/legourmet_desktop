/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.legourmet.dao;

import br.com.legourmet.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Caio
 */
public class UsuarioDAO {
    
// Adicionado por Gourangui 16/12/18 23:20
    private Connection conn;

    public UsuarioDAO() {
        conn = ConnectionFactory.getConnection();
    }

    public static void inserir(Usuario u) throws ClassNotFoundException,
            SQLException {

        // Busca uma conexao válida
        Connection conn = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        String sql = "INSERT INTO usuarios(nome, "
                + " login, senha, perfil, data_ultimo_acesso, bloqueado) VALUES(?, ?, ?, ?, ?, ?)";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        // Informo nele tb que quero buscar a chave gerada 
        //(PreparedStatement.RETURN_GENERATED_KEYS)
        PreparedStatement ps = conn.prepareStatement(sql,
                PreparedStatement.RETURN_GENERATED_KEYS);

        //Timestamp tipo Date .getTime()
        //TimeInMillis tipo calendar
//        Timestamp dataAux = new Timestamp(
//        u.getData_UltimoAcesso().getTime());
        
        // Nas linhas abaixo faz a substituicao dos parametros informados
        //no SQL, as interrogacoes (?)
        ps.setString(1, u.getNome());
        // Comentado por Gourangui 16/12/18
        //ps.setString(2, u.getTelefone());
        //ps.setString(3, u.getEmail());
        ps.setString(2, u.getLogin()); //por Gourangui 16/12/18
        ps.setString(3, u.getSenha());
        ps.setString(4, u.getPerfil());
        Timestamp dataAux = new Timestamp(u.getData_UltimoAcesso().getTimeInMillis());
        ps.setTimestamp(5, dataAux);
//        ps.setTimestamp(5, dataAux);
        // Alterado por Gourangui 16/12/18
        ps.setBoolean(6, u.isSituacao_bloqueado());

        // Dispara o comando p/ o BD
        ps.executeUpdate();

        // Busca o id (auto-incremento) gerado pelo BD
        ResultSet rs = ps.getGeneratedKeys();

        if (rs.next()) {
            int id = rs.getInt(1);
            u.setIdUsuario(id);
        }

        // Fechar conexao
        conn.close();

    }

    
    public static void alterar(Usuario u) throws ClassNotFoundException,
            SQLException {

        // Busca uma conexao válida
        Connection conn = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        String sql = "UPDATE usuarios "
                + " SET nome = ?, "
                + " login = ?, "
                + " senha = ?, "
                + " perfil = ? "
                + " data_ultimo_acesso = ? "
                + " bloqueado = ? "
                + " WHERE id_usuario  = ? ";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        PreparedStatement ps = conn.prepareStatement(sql);

        // Nas linhas abaixo faz a substituicao dos parametros informados
        //no SQL, as interrogacoes (?)
        ps.setString(1, u.getNome());
        // Alterado por Gourangui 16/12/18
        //ps.setString(2, u.getTelefone());
        //ps.setString(3, u.getEmail());
        ps.setString(2, u.getLogin());//por Gourangui 16/12/18
        ps.setString(3, u.getSenha());
        ps.setString(4, u.getPerfil());
//        ps.setDate(5, u.getData_UltimoAcesso()); 
        Timestamp dataAux = new Timestamp(u.getData_UltimoAcesso().getTimeInMillis());
        ps.setTimestamp(5, dataAux);
        ps.setBoolean(6, u.isSituacao_bloqueado());
        ps.setInt(7, u.getIdUsuario());

        // Dispara o comando p/ o BD
        ps.executeUpdate();

        // Fechar conexao
        conn.close();

    }

   
    
    public static void excluir(Usuario u) throws ClassNotFoundException,
            SQLException {

        // Busca uma conexao válida
        Connection conn = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        String sql = "DELETE FROM usuarios "
                + " WHERE id_usuario  = ? ";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        PreparedStatement ps = conn.prepareStatement(sql);

        // Nas linhas abaixo faz a substituicao dos parametros informados
        //no SQL, as interrogacoes (?)
        ps.setInt(1, u.getIdUsuario());

        // Dispara o comando p/ o BD
        ps.executeUpdate();

        // Fechar conexao
        conn.close();

    }

    ;
    
    // Método para autenticação de login - Gourangui 16/12/18 23:03
    public Usuario getUsuarioByLoginAndSenha(String login, String senha) {
        // Busca uma conexao válida
        Connection conn = ConnectionFactory.getConnection();
        
        String sql = "SELECT * FROM usuarios WHERE login = ? AND senha = ?";
        Usuario usuario = null;

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                usuario = new Usuario();
                usuario.setNome(rs.getString("nome")); 
                usuario.setLogin(rs.getString("login")); 
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            try {
                this.conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
        return usuario;
    }
    
    public static Usuario buscar(int id) throws ClassNotFoundException,
            SQLException {

        // Se o objeto não existir no banco retorna nulo
        Usuario u = null;

        // Busca conexao válida
        Connection conn = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        String sql = "SELECT * FROM usuarios "
                + " WHERE id_usuario = ? ";

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
            u = new Usuario();

            u.setIdUsuario(rs.getInt("id_usuario"));
            u.setNome(rs.getString("nome"));
            u.setLogin(rs.getString("login"));//por Gourangui 16/12/18
            // Alterado por Gourangui 16/12/18
            //u.setTelefone(rs.getString("telefone"));
            //u.setEmail(rs.getString("email"));
            u.setSenha(rs.getString("senha"));
            u.setPerfil(rs.getString("perfil"));
            Timestamp dataAux = new Timestamp(u.getData_UltimoAcesso().getTimeInMillis());
            ps.setTimestamp(5, dataAux);
//            u.setData_UltimoAcesso(rs.getDate("data_ultimo_acesso"));
            u.setSituacao_bloqueado(rs.getBoolean("bloqueado")); //Adicionado por Gourangui 16/12/18
            
        }

        // Fechar Conexao
        conn.close();

        return u;

    }

    public static ArrayList<Usuario> listar() throws ClassNotFoundException,
            SQLException {

        ArrayList<Usuario> lista = new ArrayList<>();

        // Busca conexao válida
        Connection conn = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        String sql = "SELECT * FROM usuarios ORDER BY nome ";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        PreparedStatement ps = conn.prepareStatement(sql);

        // Dispara o comando p/ o BD
        ResultSet rs = ps.executeQuery();

        // Verfica se possui registro do BD
        while (rs.next()) {

            // Cria e abastece o objeto
            Usuario u = new Usuario();

            u.setIdUsuario(rs.getInt("id_usuario"));
            u.setNome(rs.getString("nome"));
            u.setLogin(rs.getString("login"));//por Gourangui 16/12/18
            //u.setTelefone(rs.getString("telefone")); por Gourangui 16/12/18
            u.setEmail(rs.getString("email")); //por Gourangui 16/12/18
            u.setPerfil(rs.getString("perfil"));
            Timestamp dataAux = new Timestamp(u.getData_UltimoAcesso().getTimeInMillis());
            ps.setTimestamp(5, dataAux);
//            u.setData_UltimoAcesso(rs.getDate("data_ultimo_acesso")); //por Gourangui 16/12/18
            u.setSituacao_bloqueado(rs.getBoolean("bloqueado"));//por Gourangui 16/12/18

            // Acrescenta na lista de dados 
            lista.add(u);
        }

        // Fechar Conexao
        conn.close();

        return lista;
    }
    
    public static ArrayList<Usuario> listarPorNome(String usuario) throws ClassNotFoundException,
            SQLException {

        ArrayList<Usuario> lista = new ArrayList<>();

        // Busca conexao válida
        Connection conn = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        usuario = "%"+usuario+"%";
        String sql = "SELECT * FROM usuarios WHERE nome LIKE ? ORDER BY nome ";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, usuario);

        // Dispara o comando p/ o BD
        ResultSet rs = ps.executeQuery();

        // Verfica se possui registro do BD
        while (rs.next()) {

            // Cria e abastece o objeto
            Usuario u = new Usuario();

            u.setIdUsuario(rs.getInt("id_usuario"));
            u.setNome(rs.getString("nome"));
            u.setLogin(rs.getString("login"));//por Gourangui 16/12/18
            //u.setTelefone(rs.getString("telefone")); por Gourangui 16/12/18
            u.setEmail(rs.getString("email")); //por Gourangui 16/12/18
            u.setPerfil(rs.getString("perfil"));
            Timestamp dataAux = new Timestamp(u.getData_UltimoAcesso().getTimeInMillis());
            ps.setTimestamp(5, dataAux);
//            u.setData_UltimoAcesso(rs.getDate("data_ultimo_acesso")); //por Gourangui 16/12/18
            u.setSituacao_bloqueado(rs.getBoolean("bloqueado"));//por Gourangui 16/12/18

            // Acrescenta na lista de dados 
            lista.add(u);
        }

        // Fechar Conexao
        conn.close();

        return lista;
    }
    
    public static ArrayList<Usuario> listarPorLogin(String usuario) throws ClassNotFoundException,
            SQLException {

        ArrayList<Usuario> lista = new ArrayList<>();

        // Busca conexao válida
        Connection conn = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        usuario = "%"+usuario+"%";
        String sql = "SELECT * FROM usuarios WHERE login LIKE ? ORDER BY login ";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, usuario);

        // Dispara o comando p/ o BD
        ResultSet rs = ps.executeQuery();

        // Verfica se possui registro do BD
        while (rs.next()) {

            // Cria e abastece o objeto
            Usuario u = new Usuario();

            u.setIdUsuario(rs.getInt("id_usuario"));
            u.setNome(rs.getString("nome"));
            u.setLogin(rs.getString("login"));//por Gourangui 16/12/18
            //u.setTelefone(rs.getString("telefone")); por Gourangui 16/12/18
            u.setEmail(rs.getString("email")); //por Gourangui 16/12/18
            u.setPerfil(rs.getString("perfil"));
            Timestamp dataAux = new Timestamp(u.getData_UltimoAcesso().getTimeInMillis());
            ps.setTimestamp(5, dataAux);
//            u.setData_UltimoAcesso(rs.getDate("data_ultimo_acesso")); //por Gourangui 16/12/18
            u.setSituacao_bloqueado(rs.getBoolean("bloqueado"));//por Gourangui 16/12/18

            // Acrescenta na lista de dados 
            lista.add(u);
        }

        // Fechar Conexao
        conn.close();

        return lista;
    }
 
    public static ArrayList<Usuario> listarPorSituacao(String usuario) throws ClassNotFoundException,
            SQLException {

        ArrayList<Usuario> lista = new ArrayList<>();

        // Busca conexao válida
        Connection conn = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        usuario = "%"+usuario+"%";
        String sql = "SELECT * FROM usuarios WHERE bloqueado LIKE ? ORDER BY nome ";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, usuario);

        // Dispara o comando p/ o BD
        ResultSet rs = ps.executeQuery();

        // Verfica se possui registro do BD
        while (rs.next()) {

            // Cria e abastece o objeto
            Usuario u = new Usuario();

            u.setIdUsuario(rs.getInt("id_usuario"));
            u.setNome(rs.getString("nome"));
            u.setLogin(rs.getString("login"));//por Gourangui 16/12/18
            //u.setTelefone(rs.getString("telefone")); por Gourangui 16/12/18
            u.setEmail(rs.getString("email")); //por Gourangui 16/12/18
            u.setPerfil(rs.getString("perfil"));
            Timestamp dataAux = new Timestamp(u.getData_UltimoAcesso().getTimeInMillis());
            ps.setTimestamp(5, dataAux);
//            u.setData_UltimoAcesso(rs.getDate("data_ultimo_acesso")); //por Gourangui 16/12/18
            u.setSituacao_bloqueado(rs.getBoolean("bloqueado"));//por Gourangui 16/12/18

            // Acrescenta na lista de dados 
            lista.add(u);
        }

        // Fechar Conexao
        conn.close();

        return lista;
    }
    
    public static ArrayList<Usuario> listarPorPerfil(String usuario) throws ClassNotFoundException,
            SQLException {

        ArrayList<Usuario> lista = new ArrayList<>();

        // Busca conexao válida
        Connection conn = ConnectionFactory.getConnection();

        // SQL que serah executado no BD. Deve estar de acordo com o que
        //foi declarado no BD.
        // As interrogações serão posteriormente substituidas pelos
        //seus respectivos valores
        usuario = "%"+usuario+"%";
        String sql = "SELECT * FROM usuarios WHERE perfil LIKE ? ORDER BY nome ";

        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, usuario);

        // Dispara o comando p/ o BD
        ResultSet rs = ps.executeQuery();

        // Verfica se possui registro do BD
        while (rs.next()) {

            // Cria e abastece o objeto
            Usuario u = new Usuario();

            u.setIdUsuario(rs.getInt("id_usuario"));
            u.setNome(rs.getString("nome"));
            u.setLogin(rs.getString("login"));//por Gourangui 16/12/18
            //u.setTelefone(rs.getString("telefone")); por Gourangui 16/12/18
            u.setEmail(rs.getString("email")); //por Gourangui 16/12/18
            u.setPerfil(rs.getString("perfil"));
            Timestamp dataAux = new Timestamp(u.getData_UltimoAcesso().getTimeInMillis());
            ps.setTimestamp(5, dataAux);
//            u.setData_UltimoAcesso(rs.getDate("data_ultimo_acesso")); //por Gourangui 16/12/18
            u.setSituacao_bloqueado(rs.getBoolean("bloqueado"));//por Gourangui 16/12/18

            // Acrescenta na lista de dados 
            lista.add(u);
        }

        // Fechar Conexao
        conn.close();

        return lista;
    }
    
}
