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
public class Reserva {
    
    private int id_reserva;
    private Date data_hora_reserva;

    public Reserva() {
    }

    public Reserva(int id_reserva, Date data_hora_reserva) {
        this.id_reserva = id_reserva;
        this.data_hora_reserva = data_hora_reserva;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Date getData_hora_reserva() {
        return data_hora_reserva;
    }

    public void setData_hora_reserva(Date data_hora_reserva) {
        this.data_hora_reserva = data_hora_reserva;
    }
    
    
    
}
