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
public class Item {
    private int cod;
    private int qtd;
    private int preco;
    private int precoTotal;

    public Item(int cod, int qtd, int preco){
        this.cod = cod;
        this.qtd = qtd;
        this.preco = preco;
        precoTotal = this.preco * this.qtd;
    }

    public int getCod() {
        return cod;
    }

    public int getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(int precoTotal) {
        this.precoTotal = precoTotal;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

}
