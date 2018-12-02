/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Gabriel Marques
 */
public class Arquivo {
     private final File arquivo;
    
    Arquivo(String nome){
        this.arquivo = new File(nome + ".txt");
    }
    public void escrever(String texto){ 
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
    public void ler(){
        try{
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()) {
                String linha = br.readLine();
                System.out.println(linha);
            }
            br.close();
            fr.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public File getArquivo() {
        return arquivo;
    }
    
}
