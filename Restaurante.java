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

    public Restaurante() {
        cardapio = new ArrayList();
        atendimento = new ArrayList();
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
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
    }

}
