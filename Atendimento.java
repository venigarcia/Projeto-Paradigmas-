/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author veniciusgarcia
 */
public class Atendimento {
    private int cod_mesa;
    private int cod_garcom;
    private ArrayList <Item> pedido;
    private Date data;
    private double total;
    private double gorjeta;
    private int avaliacao;

    public Atendimento(int cod_mesa, int cod_garcom, ArrayList<Item> pedido, Date data, double total, double gorjeta, int avaliacao) {
        this.cod_mesa = cod_mesa;
        this.cod_garcom = cod_garcom;
        this.pedido = pedido;
        this.data = data;
        this.total = total;
        this.gorjeta = gorjeta;
        this.avaliacao = avaliacao;
    }

    public int getCod_mesa() {
        return cod_mesa;
    }

    public void setCod_mesa(int cod_mesa) {
        this.cod_mesa = cod_mesa;
    }

    public int getCod_garcom() {
        return cod_garcom;
    }

    public void setCod_garcom(int cod_garcom) {
        this.cod_garcom = cod_garcom;
    }

    public ArrayList<Item> getPedido() {
        return pedido;
    }

    public void setPedido(ArrayList<Item> pedido) {
        this.pedido = pedido;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getGorjeta() {
        return gorjeta;
    }

    public void setGorjeta(double gorjeta) {
        this.gorjeta = gorjeta;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

}
