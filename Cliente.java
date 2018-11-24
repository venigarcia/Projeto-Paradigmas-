/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

/**
 *
 * @author veniciusgarcia
 */
public class Cliente {
    protected int cpf;
    protected boolean statusCliente; 
    
    public Cliente(int cpf){
        statusCliente = true;
        this.cpf = cpf;
    }
}
