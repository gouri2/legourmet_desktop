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
public class PagamentoTableModel extends AbstractTableModel{
    
    private ArrayList<Pagamento> pagamentos;
    private ArrayList<Usuario> usuarios;
    
    public PagamentoTableModel(ArrayList<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    @Override
    public int getRowCount() {
        return pagamentos.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pagamento pagamento = pagamentos.get(rowIndex);
        Usuario usuario = usuarios.get(rowIndex);
        switch (columnIndex) {
            case 0: return pagamento.getUsuario().getData_UltimoAcesso();
            case 1: return pagamento.getUsuario().getNome();
            case 2: return pagamento.getUsuario().getEmail();
            case 3: return pagamento.getValor_Total();
            case 4: return pagamento.getForma_Pagamento();
            default: return "";
        }
        
    }   
 
    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0: return "Data de último acesso";
            case 1: return "Nome do Usuário";
            case 2: return "Email";            
            case 3: return "Valor Total";
            case 4: return "Forma do Pagamento";
            default: return "";
        }
    }

    public Pagamento getPagamento(int i){
        return this.pagamentos.get(i);
    }
    
    public void atualizaTabela(){
        fireTableDataChanged();
    }
    
    public void addListaNova(ArrayList<Usuario> listaNova){
        this.usuarios.clear();
        
        this.usuarios.addAll(listaNova);
    }
}
