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
    
    public void gerarCupon(Atendimento atendimento, Arquivo arquivo){ //mesa, cuponsFiscais/c
        try {
            if (!this.arquivo.exists()) {
                this.arquivo.createNewFile();
            }
            FileWriter fw = new FileWriter(this.arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("                    Restaurante Goût Suché             \n");
            bw.write("                Rua criada, 101 - Bairro chique        \n");
            bw.write("                  São Luís - MA CEP 65000-00           \n");
            bw.write("CNPJ: 83.998.340/0001-80                               \n");
            bw.write("IE: 000.000.000.000                                    \n");
            bw.write("IM: 0.000.000-0                                        \n");
            bw.write("______________________________________________________________\n");
            bw.write(atendimento.getData() + "   CCF: 000000                              COO:1234\n\n");
            bw.write("                         CUPOM FISCAL                  \n\n");
            bw.write("ITEM   COD    DESC             QTD     VL.UNIT(R$)   TOTAL(R$)\n");
            for(int i=0;i < atendimento.getPedido().size(); i++){
                bw.write(i + "      " + atendimento.getPedido().get(i).getCod() + "   " + atendimento.getPedido().get(i).getNome() + " ");
                bw.write(atendimento.getPedido().get(i).getQtd() + "   X    " + String.format("%.2f",atendimento.getPedido().get(i).getPreco()) + "         " + String.format("%.2f", atendimento.getPedido().get(i).getPrecoTotal()) + "\n");
            }
            bw.write("______________________________________________________________\n");
            bw.write("Gorjeta                                                R$" + String.format("%.2f",atendimento.getGorjeta())+"\n");
            bw.write("______________________________________________________________\n");
            bw.write("Total                                                 R$"+ String.format("%.2f",atendimento.getTotal()) +"\n");
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