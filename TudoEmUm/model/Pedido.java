/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.legourmet.model;

import java.sql.Date;

/**
 *
 * @author Caio
 */
public class Pedido {
    private int id_mesa; // add por Caio
    private int id_usuario; // add por Caio
    private int id_pedido;
    private String qrcode;
    private Date data_HoraPedido;
    private String situacao_Pedido;
    private Double valor_Pedido;
    private String tempo_EsperaPedido;
    private Mesa mesa; // add por Caio
    private Usuario usuario; // add por Caio

    public Pedido() {
    }

    public Pedido(int id_mesa, int id_usuario, int id_pedido, String qrcode, Date data_HoraPedido, String situacao_Pedido, Double valor_Pedido, String tempo_EsperaPedido, Mesa mesa, Usuario usuario) {
        this.id_mesa = id_mesa;
        this.id_usuario = id_usuario;
        this.id_pedido = id_pedido;
        this.qrcode = qrcode;
        this.data_HoraPedido = data_HoraPedido;
        this.situacao_Pedido = situacao_Pedido;
        this.valor_Pedido = valor_Pedido;
        this.tempo_EsperaPedido = tempo_EsperaPedido;
        this.mesa = mesa;
        this.usuario = usuario;
    }

    public int getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(int id_mesa) {
        this.id_mesa = id_mesa;
    }
    
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public Date getData_HoraPedido() {
        return data_HoraPedido;
    }

    public void setData_HoraPedido(Date data_HoraPedido) {
        this.data_HoraPedido = data_HoraPedido;
    }

    public String getSituacao_Pedido() {
        return situacao_Pedido;
    }

    public void setSituacao_Pedido(String situacao_Pedido) {
        this.situacao_Pedido = situacao_Pedido;
    }

    public Double getValor_Pedido() {
        return valor_Pedido;
    }

    public void setValor_Pedido(Double valor_Pedido) {
        this.valor_Pedido = valor_Pedido;
    }

    public String getTempo_EsperaPedido() {
        return tempo_EsperaPedido;
    }

    public void setTempo_EsperaPedido(String tempo_EsperaPedido) {
        this.tempo_EsperaPedido = tempo_EsperaPedido;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
