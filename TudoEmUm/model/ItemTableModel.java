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
public class ItemTableModel extends AbstractTableModel{
    
       private ArrayList<Item> itens;
    
    public ItemTableModel(ArrayList<Item> itens) {
        this.itens = itens;
    }

    @Override
    public int getRowCount() {
        return itens.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Item item = itens.get(rowIndex);
        switch (columnIndex) {
            case 0: return item.getId_item();
            case 1: return item.getCategoria();
            case 2: return item.getNome_Item();
            case 3: return item.getDisponivel();
            case 4: return item.getTempo_Preparo_Item();
            default: return "";
        }
        
    }   
 
    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0: return "Código Item";
            case 1: return "Categoria";
            case 2: return "Nome Item";
            case 3: return "Disponível";
            case 4: return "Tempo de Preparo (Estimativa)";
            default: return "";
        }
    }

    public Item getItem(int i){
        return this.itens.get(i);
    }
    
    public void atualizaTabela(){
        fireTableDataChanged();
    }
    
    
}
