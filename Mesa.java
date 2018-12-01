/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/**
 *
 * @author veniciusgarcia
 */
public class Mesa {
    private int qtdCliente;
    private ArrayList <Item> pedidos;
    private boolean flagBalcao;
    private Garcom garcom;
    private boolean statusConta;
    private int cod;

    public Mesa(int qtdCliente, boolean flagBalcao, Garcom garcom, int cod){
        pedidos = new ArrayList();
        this.flagBalcao = flagBalcao;
        this.qtdCliente = qtdCliente;
        this.garcom  = garcom;
        this.statusConta = true;
        this.cod = cod;
    }
    /*Percorre o ArrayList<Item> pedidos, e soma o preço total(preco por Unidade * quantidade)
        de cada objeto Item dentro do Array*/
    public double totalConta(){
        double total = 0;
        Iterator it = pedidos.iterator();
        do{
            Item i = (Item)it.next();
            total = total +i.getPrecoTotal();
        }while(it.hasNext());
        return total;
    }

    //Divide o resultado do retorno da função totalConta() pela quantidade de clientes na Mesa
    public double totalContaPorCliente(){
        return totalConta()/qtdCliente;
    }

    //Estabelece um valor de 10% em cima do retorno da função totalConta(), e retorna-o
    public double calcGorjeta(){
        return totalConta()*0.1;
    }
    /*  Recebe um ArrayList<Cardapio> cardapio(o mesmo ArrayList<Cardapio> da classe Restaurante)
            ,um codigo e uma quantidade.
        Percorre o ArrayList cardapio e busca pelo codigo do parâmetro um objeto em si que tenha correspondencia
            e atribui a Item i seu preço.
        Com o objeto Item i instanciado adicionamos em ArrayList<Item> pedidos o Item i.
    */
    public void addItem(ArrayList<Cardapio> cardapio, int cod, int qtd){
        Iterator it = cardapio.iterator();
        do{
            Cardapio c = (Cardapio)it.next();
            if(c.getCod() == cod){
                Item i = new Item( cod, qtd, c.getPreco());
                pedidos.add(i);
                break;
            }
        }while(it.hasNext());
    }
    /*Recebe um código e uma quantidade, busca no ArrayList<Item> pedidos, um Item que tenha o mesmo código
        ,se encontrado, verifica se a quantidade ultrapassa a quantidade do Item em pedidos, se sim, remove Item de pedidos
        senão, atribui a preço total seu valor menos o preço por unidade * a quantidade passada no parâmetro.
    */
    public void removeItem(int cod, int qtd){
        Iterator it = pedidos.iterator();
        do{
            Item i = (Item)it.next();
            if(i.getCod() == cod){
                if(qtd>=i.getQtd()){
                    pedidos.remove(i);
                }else{
                    i.setPrecoTotal(i.getPrecoTotal()-(i.getPreco()*qtd));
                    i.setQtd(i.getQtd()-qtd);
                }
                break;
            }
        }while(it.hasNext());
    }
    /*Recebe um objeto Restaurante e um número para avaliação
        passa o resultado da função calcGorjeta() para a função totalizaDia() de garçom
        (a função totalizaDia() soma todas as gorjetas do dia, olhar em Garçom.java),
        muda o statusConta para falso, ou seja, conta fechada, instancia um objeto Date data com a data do computador,
        cria um objeto Atendimento "a" com seus respectivos parâmetros e chama a função addAtendimento(Atendimento a)
        de Restaurantte r.
    */
    public void fecharConta(Restaurante r, int aval){
        garcom.totalizaDia(calcGorjeta());
        statusConta = false;
        Date data = new Date(System.currentTimeMillis());
        Atendimento a = new Atendimento(cod, garcom.getCod(), pedidos, data, totalConta(), calcGorjeta(), aval);
        r.addAtendimento(a);
    }
    public void imprimir(){}
}
