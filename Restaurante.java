/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;
import java.util.ArrayList;
/**
 *
 * @author veniciusgarcia
 */
public class Restaurante {
    private ArrayList <Cardapio> cardapio;
    private ArrayList <Atendimento> atendimento;
    private ArrayList <Mesa> mesas;
    private ArrayList <Garcom> garcons;
    
    public Restaurante() {
        cardapio = new ArrayList();
        atendimento = new ArrayList();
        mesas = new ArrayList();
        garcons = new ArrayList();
    }

    public ArrayList<Cardapio> getCardapio() {
        return cardapio;
    }

    public void setCardapio(ArrayList<Cardapio> cardapio) {
        this.cardapio = cardapio;
    }

    public ArrayList<Atendimento> getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(ArrayList<Atendimento> atendimento) {
        this.atendimento = atendimento;
    }

    /*Recebe um objeto Atendimento "a",
        ATENÇÃO essa função só é chamada quando o objeto mesa realiza a operação fecharConta()
    */
    public void addAtendimento(Atendimento a){
        atendimento.add(a);
    }
    /*Recebe os dados necessários para criação de um objeto Cardapio
        Essa função pode ser chamada através da classe Restaurante,
        pois não cabe a nenhuma outra a inserção de objetos Cardapio no
        ArrayList<Cardapio> senão Restaurante
    */
    public void addCardapio(int cod, String descricao, int preco){
        Cardapio c = new Cardapio(cod, descricao, preco);
        cardapio.add(c);
    }
    
     /**
     * @param qtdCliente
     * @param flagBalcao
     * @param garcom
     */
    public void addMesas(int qtdCliente, boolean flagBalcao, Garcom garcom){
        Mesa mesa = new Mesa(qtdCliente, flagBalcao, garcom, mesas.size());
        mesas.add(mesa);
    }
    public ArrayList <Mesa> getMesas() {
        return mesas;
    }

    /**
     * @param mesas the mesas to set
     */
    public void setMesas(ArrayList <Mesa> mesas) {
        this.mesas = mesas;
    }
    
    public void addGarcons(String nome){
        Garcom garcom = new Garcom(garcons.size(), nome);
        garcons.add(garcom);
    }
     /**
     * @return the garcons
     */
    public ArrayList <Garcom> getGarcons() {
        return garcons;
    }

    /**
     * @param garcons the garcons to set
     */
    public void setGarcons(ArrayList <Garcom> garcons) {
        this.garcons = garcons;
    }
    
    public void gravarAtendimentos(){
        int i,j;
        Arquivo arquivo = new Arquivo("Atendimentos");
        for(i=0; i<this.atendimento.size();i++){
            arquivo.escrever(atendimento.get(i).getCod_garcom() + "");
            arquivo.escrever(atendimento.get(i).getCod_mesa() + "");
            arquivo.escrever(atendimento.get(i).getData().toString()+ "");
            arquivo.escrever(atendimento.get(i).getAvaliacao() + "");
            arquivo.escrever(atendimento.get(i).getGorjeta() + "");
            if(this.atendimento.get(i).getPedido().size() > 0)
                arquivo.escrever(this.atendimento.get(i).getPedido().size() + "");
            else arquivo.escrever("0");
            for(j=0; j< this.atendimento.get(i).getPedido().size(); j++){
                arquivo.escrever(atendimento.get(i).getPedido().get(j).getCod() + "");
                arquivo.escrever(atendimento.get(i).getPedido().get(j).getPreco() + "");
                arquivo.escrever(atendimento.get(i).getPedido().get(j).getQtd() + "");
                arquivo.escrever(atendimento.get(i).getPedido().get(j).getPrecoTotal() + "");
            }
            arquivo.escrever(atendimento.get(i).getTotal() + "");
        }
    }
    
    public void gravarCardapio(){
        int i,j;
        Arquivo arquivo = new Arquivo("Cardapio");
        for(i=0; i<this.cardapio.size();i++){
            arquivo.escrever(cardapio.get(i).getCod() + "");
            arquivo.escrever(cardapio.get(i).getDecricao() + "");
            arquivo.escrever(cardapio.get(i).getPreco() + "");
        }
    }
    
    public void gravarGarcons(){
        int i,j;
        Arquivo arquivo = new Arquivo("Garcons");
        for(i=0; i<this.garcons.size();i++){
            arquivo.escrever(garcons.get(i).getCod() + ""); //codigo
            arquivo.escrever(garcons.get(i).getNome() + ""); // nome
            arquivo.escrever(garcons.get(i).getGorjetaTotal() + ""); // gorgeta total
        }
    }
    
    public void resgatarAtendimentos(){
        Arquivo arquivo = new Arquivo("Atendimentos");
        atendimento = arquivo.lerAtendimentos();
    }
    
    public void resgatarCardapio(){
        Arquivo arquivo = new Arquivo("Cardapio");
        cardapio = arquivo.lerCardapio();
    }
    
    public void resgatarGarcons(){
        Arquivo arquivo = new Arquivo("Garcons");
        garcons = arquivo.lerGarcons();
    }
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        //criando um restaurante para testes
        
        
//        Restaurante restaurante = new Restaurante();
//        ArrayList <Item> pedido = new ArrayList();
//        pedido.add(new Item(42, 4, 5));
//        pedido.add(new Item(23, 6, 2));
//        pedido.add(new Item(12, 1, 25));
//        Date data = new Date();
//        Atendimento atendimento = new Atendimento(1,1, pedido, data, 1000, 10, 9);
//        restaurante.addGarcons("joao");
//        restaurante.addCardapio(0, "feijao delicioso", 10);
//        restaurante.addAtendimento(atendimento);
        
        
        
        //gravando no arquivo
        
        
//        restaurante.gravarAtendimentos();
//        restaurante.gravarCardapio();
//        restaurante.gravarGarcons();

        
        //resgatando variaveis do arquivo ja gravado
        
        
//        restaurante.resgatarAtendimentos();
//        restaurante.resgatarCardapio();
//        restaurante.resgatarGarcons();
        
        
        //testando as variaveis resgatadas
        
        
//        System.out.println("total do atendimento: " + restaurante.getAtendimento().get(0).getTotal());
//        System.out.println("descricao do cardapio: " + restaurante.getCardapio().get(0).getDecricao());
//        System.out.println("nome do garcon: " + restaurante.getGarcons().get(0).getNome());
    
    }
}
