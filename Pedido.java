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
public class Pedido {
    protected String nome;
    protected int qtd;
    protected double preco;
    protected int codResponsavel;
    
    public Pedido(String nome, int qtd, double preco, int cod){
        this.nome = nome;
        this.qtd = qtd;
        this.preco = qtd * preco;
        codResponsavel = cod;
    }
    
    
}
