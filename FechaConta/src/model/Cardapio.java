/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author veniciusgarcia
 */
public class Cardapio {
    private int cod;
    private String descricao;
    private float preco;
    
    public Cardapio(int cod, String descricao, float preco){
        this.cod = cod;
        this.descricao = descricao;
        this.preco = preco;
    }
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDecricao() {
        return descricao;
    }

    public void setDecricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
}
