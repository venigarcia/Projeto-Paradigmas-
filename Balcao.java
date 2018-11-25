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
public class Balcao extends Atendimento{
    protected ArrayList <Cliente> cliente;

    public Balcao(int qtdCliente, Garcom garcom){
        super(qtdCliente, garcom);
        cliente = new ArrayList();
    }
    
    /**
     *
     * @param cod
     */
    @Override
    public void fecharConta(int cod){
        super.fecharConta(cod);
        Iterator it = cliente.iterator();
        do{
            Cliente cl = (Cliente)it.next();
            if(cl.cpf == cod){
                cl.statusCliente = false;
                break;
            }
        }while(it.hasNext());       
    }
}
