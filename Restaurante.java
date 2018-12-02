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
    
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
    }
}
