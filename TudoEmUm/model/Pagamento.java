/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.legourmet.model;

/**
 *
 * @author Caio
 */
public class Pagamento {

    private int id_pagamento;
    private Double valor_Total;
    private String forma_Pagamento;
    // Add por Caio 
    private Usuario usuario;
    private Item item;

    public Pagamento() {
    }

    public Pagamento(int id_pagamento, Double valor_Total, String forma_Pagamento, Usuario usuario, Item item) {
        this.id_pagamento = id_pagamento;
        this.valor_Total = valor_Total;
        this.forma_Pagamento = forma_Pagamento;
        this.usuario = usuario;
        this.item = item;
    }

    public int getId_pagamento() {
        return id_pagamento;
    }

    public void setId_pagamento(int id_pagamento) {
        this.id_pagamento = id_pagamento;
    }

    public Double getValor_Total() {
        return valor_Total;
    }

    public void setValor_Total(Double valor_Total) {
        this.valor_Total = valor_Total;
    }

    public String getForma_Pagamento() {
        return forma_Pagamento;
    }

    public void setForma_Pagamento(String forma_Pagamento) {
        this.forma_Pagamento = forma_Pagamento;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

}
