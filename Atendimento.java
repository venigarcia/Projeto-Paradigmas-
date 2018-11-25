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
    public double totalConta(int cod){
        double total = 0;
        Iterator it = pedido.iterator();
        do{
            Pedido p = (Pedido)it.next();
            if(p.codResponsavel == cod)
                total = total +p.preco;
        }while(it.hasNext());
        return total;
    }
    public double totalContaPorCliente(int cod){
        double totalCliente;
        totalCliente = totalConta(cod)/qtdCliente;
        return totalCliente;
    }
    public double gorjetaGarcom(int cod){
        double gorjeta;
        gorjeta = totalConta(cod)*0.10;
        garcom.gorjeta = gorjeta;
        return gorjeta;
    }
    public void addItemPedido(String nome, int qtd, int preco, int cod){
        Pedido p = new Pedido(nome, qtd, preco, cod);
        pedido.add(p);        
    }
    public void removeItemPedido(String nome, int cod){
        boolean remove = false;
        Iterator it = pedido.iterator();
        do{
            Pedido p = (Pedido)it.next();
            if(p.nome.equals(nome)&& p.codResponsavel==cod){
                pedido.remove(p);
                remove = true;
            }
        }while(!remove && it.hasNext());
    }
    public void imprimirConta(int cod){
        Iterator it = pedido.iterator();
        do{
            Pedido p = (Pedido)it.next();
            System.out.println("Pedido: "+p.nome);
            System.out.println("Preco: "+p.preco);
        }while(it.hasNext());
        System.out.println("Valor total da conta: " + totalConta(cod));
        System.out.println("Valor total da conta por Cliente: " + totalContaPorCliente(cod));
    }
    public void fecharConta(int cod){
        System.out.println("Gorjeta Garcom: "+gorjetaGarcom(cod));
    }
    public void totalizarConta(int cod){
        
    }
}
