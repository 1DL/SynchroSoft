/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;


import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author LuizV1
 */
public class LeitorArquivo {
    public static void lerArquivo() {

         // The name of the file to open.
        String fileName = "acessojanelas.txt";

        // This will reference one line at a time
        String line = null;
        
        

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            System.out.println("Leitura");
            while((line = bufferedReader.readLine()) != null) {
                int aux = 0;
                SynchroSoft.acessoTelas.add(Integer.parseInt(line));
                
                System.out.println(SynchroSoft.acessoTelas.get(aux));
                aux++;
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }
    
    public static void escreverArquivo() {

        // The name of the file to open.
        String fileName = "acessojanelas.txt";

        try {
            // Assume default encoding.
            FileWriter fileWriter =
                new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            System.out.println("escrita");
            int limiteJanelas = 0;
            for (Integer i : SynchroSoft.acessoTelas){
                
                bufferedWriter.write(String.valueOf(i));
                bufferedWriter.newLine();
                
                System.out.println(i);
                limiteJanelas ++;
            }
            
            if (limiteJanelas > 16) {
                JOptionPane.showMessageDialog(null, "Arquivo 'acessojanelas.txt' corrompido. \n\n"
                        + "As janelas mais acessadas serão redefinidas para o padrão.");
                SynchroSoft.acessoTelas.clear();
                for (int i = 0; i <= 15; i++) {
                    SynchroSoft.acessoTelas.add(0);
                }
                escreverArquivo();
            }

            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
}
