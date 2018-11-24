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
    protected String nome;
    protected int cod;
    protected double gorjeta;
    
    public Garcom(String nome){
        this.nome = nome;
        gorjeta = 0;
    }
}
