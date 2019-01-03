/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.legourmet.model;

import java.sql.Blob;
import java.sql.Date;

/**
 *
 * @author Caio
 */
public class Item {
    private int id_item;
    private String img_Item;
//    private Blob img_Item;
    private String nome_Item;
    private String categoria;
    //private boolean disponivel;
    private String disponivel;
    private String ingredientes;
    private double valor_Item;
    private int tempo_Preparo_Item;
//    private String tempo_Preparo_Item;

    public Item() {
    }

    public Item(int id_item, String img_Item, String nome_Item, String categoria, String disponivel, String ingredientes, double valor_Item, int tempo_Preparo_Item) {
        this.id_item = id_item;
        this.img_Item = img_Item;
        this.nome_Item = nome_Item;
        this.categoria = categoria;
        this.disponivel = disponivel;
        this.ingredientes = ingredientes;
        this.tempo_Preparo_Item = tempo_Preparo_Item;
        this.valor_Item = valor_Item;
    }

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public String getImg_Item() {
        return img_Item;
    }

    public void setImg_Item(String img_Item) {
        this.img_Item = img_Item;
    }

    public String getNome_Item() {
        return nome_Item;
    }

    public void setNome_Item(String nome_Item) {
        this.nome_Item = nome_Item;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(String disponivel) {
        this.disponivel = disponivel;
    }


    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public double getValor_Item() {
        return valor_Item;
    }

    public void setValor_Item(double valor_Item) {
        this.valor_Item = valor_Item;
    }
    
    public int getTempo_Preparo_Item() {
        return tempo_Preparo_Item;
    }

    public void setTempo_Preparo_Item(int tempo_Preparo_Item) {
        this.tempo_Preparo_Item = tempo_Preparo_Item;
    }
    
//    public String getTempo_Preparo_Item() {
//        return tempo_Preparo_Item;
//    }
//
//    public void setTempo_Preparo_Item(String tempo_Preparo_Item) {
//        this.tempo_Preparo_Item = tempo_Preparo_Item;
//    }

    
    
}
