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
public class Mesa {
    private int id_mesa;
    private boolean disponivel;
    private int numero_Mesa;

    public Mesa() {
    }

    public Mesa(int id_mesa, boolean disponivel, int numero_Mesa) {
        this.id_mesa = id_mesa;
        this.disponivel = disponivel;
        this.numero_Mesa = numero_Mesa;
    }

    public int getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(int id_mesa) {
        this.id_mesa = id_mesa;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public int getNumero_Mesa() {
        return numero_Mesa;
    }

    public void setNumero_Mesa(int numero_Mesa) {
        this.numero_Mesa = numero_Mesa;
    }
    
    
}
