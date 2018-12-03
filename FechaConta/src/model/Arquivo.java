/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Gabriel Marques
 */
public class Arquivo {
     private final File arquivo;
    
    Arquivo(String nome){
        this.arquivo = new File(nome + ".txt");
    }
    
    public void refresh(){
        try {
            if (this.arquivo.exists()) {
                this.arquivo.delete();
                this.arquivo.createNewFile();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void gerarCupon(Mesa mesa, Arquivo arquivo){ //mesa, cuponsFiscais/c
        try {
            if (!this.arquivo.exists()) {
                this.arquivo.createNewFile();
            }
            FileWriter fw = new FileWriter(this.arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Codigo da mesa: " + mesa.getCod());
            bw.write("Garcon: " + mesa.getGarcom().getNome());
            bw.write("Numero de clientes: " + mesa.getQtdCliente());
            for(int i=0;i < mesa.getPedidos().size(); i++){
                bw.write("Pedido numero " + i+1);
                bw.write("Codigo: " + mesa.getPedidos().get(i).getCod());
                bw.write("Nome: " + mesa.getPedidos().get(i).getNome());
                bw.write("Preco: R$" + mesa.getPedidos().get(i).getPreco());
                bw.write("Quantidade: " + mesa.getPedidos().get(i).getQtd());
                bw.write("Total: R$" + mesa.getPedidos().get(i).getPrecoTotal());
            }
            bw.newLine();
            bw.close();
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    public void escrever(String texto){ //escreve no arquivo
        try {
            if (!this.arquivo.exists()) {
                this.arquivo.createNewFile();
            }
            FileWriter fw = new FileWriter(this.arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(texto);
            bw.newLine();
            bw.close();
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public ArrayList<Atendimento> lerAtendimentos(){
        int i, j;
        ArrayList<Item> pedido = new ArrayList();
        String data;
        
        ArrayList<Atendimento> atendimentos = new ArrayList();
        try{
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()) {
                String linha = br.readLine();
                float cod_garcom = Float.parseFloat(linha);

                linha = br.readLine();
                float cod_mesa = Float.parseFloat(linha);

                linha = br.readLine();
                data = linha;

                linha = br.readLine();
                float avaliacao = Float.parseFloat(linha);

                linha = br.readLine();
                float gorjeta = Float.parseFloat(linha);

                linha = br.readLine();
                j =  Integer.parseInt(linha);
                for(i=0;i< j; i++){
                    linha = br.readLine();
                    float cod = Float.parseFloat(linha);
                    
                    linha = br.readLine();
                    String nome = linha;
                    
                    linha = br.readLine();
                    float preco = Float.parseFloat(linha);
                    
                    linha = br.readLine();
                    float qtd = Float.parseFloat(linha);

                    linha = br.readLine();
                    float precoTotal = Float.parseFloat(linha);
                    
                    Item item = new Item( (int) cod,  (int)qtd,  (int)preco, nome);
                    pedido.add(item);
                    
                }
                linha = br.readLine();
                float total = Float.parseFloat(linha);
                
                Atendimento atendimento = new Atendimento((int) cod_mesa, (int)cod_garcom, pedido,data, (double) total, (double) gorjeta, (int)avaliacao);
                atendimentos.add(atendimento);
            }
            br.close();
            fr.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return atendimentos;
    }
    
    public ArrayList<Cardapio> lerCardapio(){
        
        ArrayList<Cardapio> cardapios = new ArrayList();
        try{
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()) {
                String linha = br.readLine();
                float cod = Float.parseFloat(linha);
                
                linha = br.readLine();
                String descricao = linha;
                
                linha = br.readLine();
                float preco = Float.parseFloat(linha);
                
                Cardapio cardapio = new Cardapio((int) cod, descricao, (int) preco);
                cardapios.add(cardapio);
            }
            br.close();
            fr.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return cardapios;
    }
    public ArrayList<Garcom> lerGarcons(){
        ArrayList<Garcom> garcons = new ArrayList();
        try{
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()) {
                String linha = br.readLine();
                float cod = Float.parseFloat(linha);
                
                linha = br.readLine();
                String nome = linha;
                
                Garcom garcom = new Garcom((int) cod, nome);
                
                linha = br.readLine();
                garcom.setGorjetaTotal(Float.parseFloat(linha));
                
                garcons.add(garcom);
            }
            br.close();
            fr.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return garcons;
    }

    public File getArquivo() {
        return arquivo;
    }
    
}