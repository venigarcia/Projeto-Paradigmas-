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
    public Mesa(int qtdCliente, Garcom garcom){
        super(qtdCliente, garcom);
    }
    
    private void addItemPedido(String nome, int qtd, int preco){
        int cod = (int)Math.random()*10;
        addItemPedido()
    }
}
