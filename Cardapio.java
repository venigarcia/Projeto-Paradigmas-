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
public class Cardapio {
    private int cod;
    private String descricao;
    private int preco;
    public Cardapio(int cod, String descricao, int preco){
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

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }
}
