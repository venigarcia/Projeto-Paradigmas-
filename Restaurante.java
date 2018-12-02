/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
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
            arquivo.escrever("///////////////////////////////////////////");
            arquivo.escrever("Atendimento " + i+1 + "\n");
            arquivo.escrever("Codigo do garcom: "+ atendimento.get(i).getCod_garcom());
            arquivo.escrever("Codigo da mesa: "+ atendimento.get(i).getCod_mesa());
            arquivo.escrever("Data: "+ atendimento.get(i).getData().toString());
            arquivo.escrever("Avaliacao: "+ atendimento.get(i).getAvaliacao());
            arquivo.escrever("Gorgeta: "+ atendimento.get(i).getGorjeta() + "\n");
            for(j=0; j< this.atendimento.get(i).getPedido().size(); j++){
                arquivo.escrever("Pedido numero "+ j+1);
                arquivo.escrever("Codigo do Pedido: "+ atendimento.get(i).getPedido().get(j).getCod());
                arquivo.escrever("Preco: "+ atendimento.get(i).getPedido().get(j).getPreco());
                arquivo.escrever("Quantidade: "+ atendimento.get(i).getPedido().get(j).getQtd());
                arquivo.escrever("Preco total: "+ atendimento.get(i).getPedido().get(j).getPrecoTotal());
                arquivo.escrever("\n");
            }
            arquivo.escrever("Total da conta: "+ atendimento.get(i).getTotal());
        }
    }
    
    public void gravarCardapio(){
        int i,j;
        Arquivo arquivo = new Arquivo("Cardapio");
        for(i=0; i<this.cardapio.size();i++){
            arquivo.escrever("///////////////////////////////////////////");
            arquivo.escrever("cardapio " + i+1 + "\n");
            arquivo.escrever("Codigo do cardapio: "+ cardapio.get(i).getCod());
            arquivo.escrever("Descricao: "+ cardapio.get(i).getDecricao());
            arquivo.escrever("Preco : "+ cardapio.get(i).getPreco());
        }
    }
    
    public void gravarGarcons(){
        int i,j;
        Arquivo arquivo = new Arquivo("Garcons");
        for(i=0; i<this.garcons.size();i++){
            arquivo.escrever("///////////////////////////////////////////");
            arquivo.escrever("Garcon " + i+1 + "\n");
            arquivo.escrever("Codigo do garcon: "+ garcons.get(i).getCod());
            arquivo.escrever("Nome: "+ garcons.get(i).getNome());
            arquivo.escrever("Gorgeta total : "+ garcons.get(i).getGorjetaTotal());
        }
    }
    
    public void lerAtendimentos(){
        Arquivo arquivo = new Arquivo("Atendimentos");
        arquivo.ler();
    }
    public void lerCardapio(){
        Arquivo arquivo = new Arquivo("Cardapio");
        arquivo.ler();
    }
    public void lerGarcons(){
        Arquivo arquivo = new Arquivo("Garcons");
        arquivo.ler();
    }
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        //TODO code application logic here
    }

}
