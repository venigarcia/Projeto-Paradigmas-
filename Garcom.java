/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

/**
 *
 * @author veniciusgarcia
 */
public class Garcom {
    private int cod;
    private String nome;
    private double gorjetaTotal;

    public Garcom(int cod, String nome) {
        this.cod = cod;
        this.nome = nome;
        gorjetaTotal = 0;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getGorjetaTotal() {
        return gorjetaTotal;
    }

    public void setGorjetaTotal(double gorjetaTotal) {
        this.gorjetaTotal = gorjetaTotal;
    }

    public double totalizaDia(double gorjeta){
        gorjetaTotal = gorjetaTotal+gorjeta;
        return gorjetaTotal;
    }
}
