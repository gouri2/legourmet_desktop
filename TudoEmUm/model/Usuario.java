/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.legourmet.model;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author Caio
 */
public class Usuario {
    
    // ATRIBUTOS -------------
    private int idUsuario;
    private String perfil;
    private String nome;
    //private String telefone; removi pois nosso sistema n precisa - Gourangui 16/12/18 22:50
    private String email; //removi pois nosso sistema n precisa - Gourangui 16/12/18 22:50
    private String login; // Adicionado por Gourangui 16/12/18 23:05
    private String senha;
    
    private boolean situacao_bloqueado;
    private Calendar data_UltimoAcesso;
    
    // CONSTRUTORES -------------
    public Usuario() {
    }

    public Usuario(int idUsuario, String perfil, String nome, String email, String login, String senha, boolean situacao_bloqueado, Calendar data_UltimoAcesso) {
        this.idUsuario = idUsuario;
        this.perfil = perfil;
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.situacao_bloqueado = situacao_bloqueado;
        this.data_UltimoAcesso = data_UltimoAcesso;
    }

// por Caio ----------- comentado por Gourangui 16/12/18 23:05
//    public Usuario(int idUsuario, String nome, String telefone, String email, String senha, String perfil, Date data_UltimoAcesso, boolean bloqueado) {
//        this.idUsuario = idUsuario;
//        this.nome = nome;
//        this.telefone = telefone;
//        this.email = email;
//        this.senha = senha;
//        this.perfil = perfil;
//        this.data_UltimoAcesso = data_UltimoAcesso;
//        this.bloqueado = bloqueado;
//    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isSituacao_bloqueado() {
        return situacao_bloqueado;
    }

    public void setSituacao_bloqueado(boolean situacao_bloqueado) {
        this.situacao_bloqueado = situacao_bloqueado;
    }

    public Calendar getData_UltimoAcesso() {
        return data_UltimoAcesso;
    }

    public void setData_UltimoAcesso(Calendar data_UltimoAcesso) {
        this.data_UltimoAcesso = data_UltimoAcesso;
    }
    
}
