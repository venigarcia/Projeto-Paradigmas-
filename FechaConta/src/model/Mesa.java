/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.text.SimpleDateFormat;
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
        Iterator it = getPedidos().iterator();
        do{
            Item i = (Item)it.next();
            total = total +i.getPrecoTotal();
        }while(it.hasNext());
        return total;
    }

    //Divide o resultado do retorno da função totalConta() pela quantidade de clientes na Mesa
    public double totalContaPorCliente(){
        return totalConta()/getQtdCliente();
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
                Item i = new Item( cod, qtd, c.getPreco(), c.getDecricao());
                getPedidos().add(i);
                break;
            }
        }while(it.hasNext());
    }
    /*Recebe um código e uma quantidade, busca no ArrayList<Item> pedidos, um Item que tenha o mesmo código
        ,se encontrado, verifica se a quantidade ultrapassa a quantidade do Item em pedidos, se sim, remove Item de pedidos
        senão, atribui a preço total seu valor menos o preço por unidade * a quantidade passada no parâmetro.
    */
    public void removeItem(int cod, int qtd){
        Iterator it = getPedidos().iterator();
        do{
            Item i = (Item)it.next();
            if(i.getCod() == cod){
                if(qtd>=i.getQtd()){
                    getPedidos().remove(i);
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
    public Atendimento fecharConta(RestauranteModel r, int aval){
        getGarcom().totalizaDia(calcGorjeta());
        setStatusConta(false);
        Date d = new Date(System.currentTimeMillis());
        String data = new SimpleDateFormat("dd/MM/yyyy").format(d);
        Atendimento a = new Atendimento(getCod(), getGarcom().getCod(), getPedidos(), data, totalConta(), calcGorjeta(), aval);
        r.addAtendimento(a);
        return a;
    }
    
    public void imprimir(){}

    /**
     * @return the qtdCliente
     */
    public int getQtdCliente() {
        return qtdCliente;
    }

    /**
     * @param qtdCliente the qtdCliente to set
     */
    public void setQtdCliente(int qtdCliente) {
        this.qtdCliente = qtdCliente;
    }

    /**
     * @return the pedidos
     */
    public ArrayList <Item> getPedidos() {
        return pedidos;
    }

    /**
     * @param pedidos the pedidos to set
     */
    public void setPedidos(ArrayList <Item> pedidos) {
        this.pedidos = pedidos;
    }

    /**
     * @return the flagBalcao
     */
    public boolean isFlagBalcao() {
        return flagBalcao;
    }

    /**
     * @param flagBalcao the flagBalcao to set
     */
    public void setFlagBalcao(boolean flagBalcao) {
        this.flagBalcao = flagBalcao;
    }

    /**
     * @return the garcom
     */
    public Garcom getGarcom() {
        return garcom;
    }

    /**
     * @param garcom the garcom to set
     */
    public void setGarcom(Garcom garcom) {
        this.garcom = garcom;
    }

    /**
     * @return the statusConta
     */
    public boolean isStatusConta() {
        return statusConta;
    }

    /**
     * @param statusConta the statusConta to set
     */
    public void setStatusConta(boolean statusConta) {
        this.statusConta = statusConta;
    }

    /**
     * @return the cod
     */
    public int getCod() {
        return cod;
    }

    /**
     * @param cod the cod to set
     */
    public void setCod(int cod) {
        this.cod = cod;
    }
}
