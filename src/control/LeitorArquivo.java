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
        //Nome do arquivo a ser acessado, presente na pasta raíz do projeto.
        String fileName = "acessojanelas.txt";
        //Variável que receberá os dados de uma linha inteira do arquivo de texto.
        String line = null;
        try {
            // FileReader lê os arquivos com o encoding padrão.
            FileReader fileReader = new FileReader(fileName);
            // Embrulhando o FileReader com o BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            System.out.println("Leitura");

            /*
            Limite de Janelas é uma variável flag para contar as linhas do arquivo de texto.
            Ela representa quantas janelas o sistema possui atualmente, por isso deve ser
            igual a quantidade de janelas que o sistema possui. Caso seja diferente, 
             */
            int limiteJanelas = 0;

            /*
            Laço que percorre todas as linhas do arquivo de texto.
            Enquanto a linha não for nula, continua avançando
            das linhas de cima para baixo do arquivo de texto.
             */
            try {
                while ((line = bufferedReader.readLine()) != null) {
                    Janelas jan = new Janelas(line.substring(0, 3), Integer.parseInt(line.substring(4)));
                    Janelas.acessoTelas.add(jan);
                    System.out.println("" + Janelas.acessoTelas.get(limiteJanelas).getNome() + " " + Janelas.acessoTelas.get(limiteJanelas).getAcesso());
                    limiteJanelas++;
                }
            } catch (Exception ex) {
                resetarAcessoJanelas();
            }
            /*
            Caso o limite de janelas seja diferente do atual do sistema,
            o método de resetAcessoJanelas é chamado.
             */
            if (limiteJanelas != Janelas.qtdJanelas) {
                resetarAcessoJanelas();
            }
            //Fechando o arquivo.
            bufferedReader.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Não foi possível abrir o arquivo '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Erro ao ler o arquivo '" + fileName + "'");
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }

    public static void escreverArquivo() {

        String fileName = "acessojanelas.txt";

        try {

            FileWriter fileWriter = new FileWriter(fileName);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            /*
            Laço para escrever linha a linha no arquivo de texto.
            O método .write() não pula a linha.
            É preciso invocar o .newLine() para pular a linha.
             */
            System.out.println("escrita");
            int limiteJanelas = 0;
            for (Janelas jan : Janelas.acessoTelas) {

                String linha = jan.getNome() + " " + jan.getAcesso();
                bufferedWriter.write(linha);
                bufferedWriter.newLine();

                System.out.println(linha);
                limiteJanelas++;
            }
            if (limiteJanelas != Janelas.qtdJanelas) {
                resetarAcessoJanelas();
            }

            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println("Erro ao escrever no arquivo '" + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }

    /*
    resetarAcessoJanelas reconstroi o arquivo de texto com as linhas
    na quantidade correta de janelas do sistema.
    A quantidade de acesso a cada janela, entretanto, é zerada.
     */
    public static void resetarAcessoJanelas() {

        JOptionPane.showMessageDialog(null, "Arquivo 'acessojanelas.txt' corrompido. \n\n"
                + "As janelas mais acessadas serão redefinidas para o padrão.");
        //Limpa o array controlador de acesso de telas.
        Janelas.acessoTelas.clear();

        /*
        Laço para re-construir o array controlador de acesso de telas.
        Possui um if que verifica se o contador é menor que 9, para assim, 
        atribuir o padrão de nome de janelas JXX Y, sendo JXX
        STRING representando a janela, por ex, J08, e Y, a quantidade de acessos
        dessa janela, por exemplo, J08 25.
        Como o arquivo foi corrompito, a quantidade de acessos será zerada.
         */
        for (int i = 0; i < Janelas.qtdJanelas; i++) {
            if (i < 10) {
                Janelas jan = new Janelas("J0" + i, 0);
                Janelas.acessoTelas.add(jan);
            } else {
                Janelas jan = new Janelas("J" + i, 0);
                Janelas.acessoTelas.add(jan);
            }
        }
        escreverArquivo();
    }
}
