/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.legourmet.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sala303b
 */
public class PedidoTableModel extends AbstractTableModel{
    
    private ArrayList<Pedido> pedidos;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Mesa> mesas;
    
    public PedidoTableModel(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public int getRowCount() {
        return pedidos.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pedido pedido = pedidos.get(rowIndex);
//        Usuario usuario = usuarios.get(rowIndex);
//        Mesa mesa = mesas.get(rowIndex);
        
         switch (columnIndex) {
            case 0: return pedido.getUsuario().getNome();
            case 1: return pedido.getMesa().getNumero_Mesa();
            case 2: return pedido.getSituacao_Pedido();
            default: return "";
        }
        
    }   
 
    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0: return "Nome";
            case 1: return "Número da mesa";
            case 2: return "Situação do pedido";
           default: return "";
        }
    }

    public Pedido getPedido(int i){
        return this.pedidos.get(i);
    }
    
    public Usuario getUsuario(int i){
        return this.usuarios.get(i);
    }
    
    public void atualizaTabela(){
        fireTableDataChanged();
    }
    
    public void addListaMesa(ArrayList<Mesa> mesa){
        this.mesas.clear();
        
        this.mesas.addAll(mesa);
        
    }
    
    public void addListaUsuario(ArrayList<Usuario> usuario){
        this.usuarios.clear();
        
        this.usuarios.addAll(usuario);
        
    }
}
