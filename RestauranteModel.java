/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author veniciusgarcia
 */
public class RestauranteModel {
    private ArrayList <Cardapio> cardapio;
    private ArrayList <Atendimento> atendimento;
    private ArrayList <Mesa> mesas;
    private ArrayList <Garcom> garcons;
    
    public RestauranteModel() {
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
    public void addCardapio(int cod, String descricao, float preco){
        Cardapio c = new Cardapio(cod, descricao, preco);
        cardapio.add(c);
    }
    
     /**
     * @param qtdCliente
     * @param flagBalcao
     * @param garcom
     */
    public void addMesas(int qtdCliente, boolean flagBalcao, Garcom garcom, int cod){
        Mesa mesa = new Mesa(qtdCliente, flagBalcao, garcom, cod);
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
    
    public void addGarcons(int cod, String nome){
        Garcom garcom = new Garcom(cod, nome);
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
        arquivo.refresh();
        for(i=0; i<this.atendimento.size();i++){
            arquivo.escrever(atendimento.get(i).getCod_garcom() + "");
            arquivo.escrever(atendimento.get(i).getCod_mesa() + "");
            arquivo.escrever(atendimento.get(i).getData());
            arquivo.escrever(atendimento.get(i).getAvaliacao() + "");
            arquivo.escrever(atendimento.get(i).getGorjeta() + "");
            if(this.atendimento.get(i).getPedido().size() > 0)
                arquivo.escrever(this.atendimento.get(i).getPedido().size() + "");
            else arquivo.escrever("0");
            for(j=0; j< this.atendimento.get(i).getPedido().size(); j++){
                arquivo.escrever(atendimento.get(i).getPedido().get(j).getCod() + "");
                arquivo.escrever(atendimento.get(i).getPedido().get(j).getNome() + "");
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
        arquivo.refresh();
        for(i=0; i<this.cardapio.size();i++){
            arquivo.escrever(cardapio.get(i).getCod() + "");
            arquivo.escrever(cardapio.get(i).getDecricao() + "");
            arquivo.escrever(cardapio.get(i).getPreco() + "");
        }
    }
    
    public void gravarGarcons(){
        int i,j;
        Arquivo arquivo = new Arquivo("Garcons");
        arquivo.refresh();
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
    
    public void gerarCupon(Mesa mesa){
        Date d = new Date(System.currentTimeMillis());
        String data = new SimpleDateFormat("dd/MM/yyyy").format(d);
        Arquivo arquivo = new Arquivo("cuponsFiscais/CuponsDia(" + data + ").txt" );
        arquivo.gerarCupon(mesa, arquivo);
    }
}