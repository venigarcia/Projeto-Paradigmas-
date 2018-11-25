/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

/**
 *
 * @author Val
 */
import java.util.ArrayList;
import java.util.Iterator;
public class Restaurante {

    /**
     * @param args the command line arguments
     */
    protected Balcao balcao;
    protected ArrayList <Mesa> mesa;
    
    public Restaurante(){
        mesa = new ArrayList();        
    }
    
    public void emitirRelatorioContaAberta(){
        Iterator itCliente = balcao.cliente.iterator();
        Iterator itPedido = balcao.pedido.iterator();
        Iterator itMesa = mesa.iterator();        
        Cliente cl = (Cliente) itCliente.next();
        do{
            if(cl.statusCliente){
                Pedido p = (Pedido)itPedido.next();
                do{
                    if(p.codResponsavel == cl.cpf)
                        System.out.println("CPF CLIENTE "+ cl.cpf +" Pedido"+ p.nome + p.preco);
                }while(itPedido.hasNext());
            }
        }while(itCliente.hasNext());
        
        do{
            Mesa  m =(Mesa)itMesa.next();           
            if(m.statusConta){
                Iterator itPedidoMesa = m.pedido.iterator();
                do{
                    Pedido p =(Pedido)itPedidoMesa.next();
                    System.out.println("COD Mesa "+ m.cod +" Pedido"+ p.nome + p.preco);
                }while(itPedidoMesa.hasNext());                
                System.out.println();
            }
        }while(itMesa.hasNext());
    }
    
    public void emitirTotalApuradoDia(){
        Iterator itCliente = balcao.cliente.iterator();
        Iterator itPedido = balcao.pedido.iterator();
        Iterator itMesa = mesa.iterator();        
        Cliente cl = (Cliente) itCliente.next();
        do{
            if(!cl.statusCliente){
                Pedido p = (Pedido)itPedido.next();
                do{
                    if(p.codResponsavel == cl.cpf)
                        System.out.println("CPF CLIENTE "+ cl.cpf +" Pedido"+ p.nome + p.preco);
                }while(itPedido.hasNext());
            }
        }while(itCliente.hasNext());
        
        do{
            Mesa  m =(Mesa)itMesa.next();           
            if(!m.statusConta){
                Iterator itPedidoMesa = m.pedido.iterator();
                do{
                    Pedido p =(Pedido)itPedidoMesa.next();
                    System.out.println("COD Mesa "+ m.cod +" Pedido"+ p.nome + p.preco);
                }while(itPedidoMesa.hasNext());                
                System.out.println();
            }
        }while(itMesa.hasNext());
        
    }
    public void emitirRelatorioDeGorjeta(){
        Iterator itMesa = mesa.iterator();
        do{
            Mesa  m =(Mesa)itMesa.next();           
            if(!m.statusConta){        
                System.out.println("Cod Mesa: "+ m.cod + " Garçom"+ m.garcom.nome + "Gorjeta" + m.garcom.gorjeta);
            }
        }while(itMesa.hasNext());
        System.out.println("Garçom: "+ balcao.garcom.nome + " Gorjeta: "+balcao.garcom.gorjeta);
    }
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
