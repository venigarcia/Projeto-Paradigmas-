/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author veniciusgarcia
 */
public class Atendimento {
    protected ArrayList <Pedido> pedido;
    protected Garcom garcom;
    protected int qtdCliente;
    protected boolean statusConta;
    
    public Atendimento(int qtdCliente, Garcom garcom){
        pedido = new ArrayList();
        this.qtdCliente = qtdCliente;
        this.garcom = garcom;
        statusConta = true;
    }
    private double totalConta(){
        double total = 0;
        Iterator it = pedido.iterator();
        do{
            Pedido p = (Pedido)it.next();
            total = total +p.preco;
        }while(it.hasNext());
        return total;
    }
    private double totalContaPorCliente(){
        double totalCliente;
        totalCliente = totalConta()/qtdCliente;
        return totalCliente;
    }
    private double gorjetaGarcom(){
        double gorjeta;
        gorjeta = totalConta()*0.10;
        garcom.gorjeta = gorjeta;
        return gorjeta;
    }
    private void addItemPedido(String nome, int qtd, int preco){
        Pedido p = new Pedido(nome, qtd, preco, cod);
        pedido.add(p);        
    }
    private void removeItemPedido(String nome){
        boolean remove = false;
        Iterator it = pedido.iterator();
        do{
            Pedido p = (Pedido)it.next();
            if(p.nome.equals(nome)){
                pedido.remove(p);
                remove = true;
            }
        }while(!remove && it.hasNext());
    }
    private void imprimirConta(){
        Iterator it = pedido.iterator();
        do{
            Pedido p = (Pedido)it.next();
            System.out.println("Pedido: "+p.nome);
            System.out.println("Preco: "+p.preco);
        }while(it.hasNext());
        System.out.println("Valor total da conta: " + totalConta());
        System.out.println("Valor total da conta por Cliente: " + totalContaPorCliente());
    }
    private void fecharConta(){
        System.out.println("Gorjeta Garcom: "+gorjetaGarcom());
        statusConta = false;
    }
}
