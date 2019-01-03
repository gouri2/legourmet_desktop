/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.legourmet.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sala303b
 */
public class UsuarioTableModel extends AbstractTableModel{
    
     private ArrayList<Usuario> usuarios;
    
    public UsuarioTableModel(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    Usuario usuario = new Usuario();
    String email = usuario.getEmail();
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario usuario = usuarios.get(rowIndex);
         switch (columnIndex) {
            case 0: return usuario.getNome();
            case 1: return usuario.getEmail() + " - " +usuario.getLogin();
            case 2: return usuario.getPerfil();
            case 3:
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    return sdf.format(usuario.getData_UltimoAcesso());
                } catch (Exception ex) {
                    return null;
                }
            case 4: return usuario.isSituacao_bloqueado();
            default: return "";
        }
        
    }   
 
    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0: return "Nome";
            case 1: return "Email/Login";
            case 2: return "Perfil";
            case 3: return "Último acesso";
            case 4: return "Situação";
            default: return "";
        }
    }

    public Usuario getUsuario(int i){
        return this.usuarios.get(i);
    }
    
    public void atualizaTabela(){
        fireTableDataChanged();
    }
    
    
}
