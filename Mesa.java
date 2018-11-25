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
public class Mesa extends Atendimento{
    protected int cod;
    public Mesa(int qtdCliente, Garcom garcom, int cod){
        super(qtdCliente, garcom);
        this.cod = cod; 
    }
    
    /**
     *
     * @param nome
     * @param qtd
     * @param preco
     */
    public void addItemPedido(String nome, int qtd, int preco){
        int cod = (int)Math.random()*10;
        super.addItemPedido(nome, qtd, preco, cod);
    }

    /**
     *
     * @param cod
     */
    @Override
    public void fecharConta(int cod){
        super.fecharConta(cod);
        statusConta = false;
    }
}
