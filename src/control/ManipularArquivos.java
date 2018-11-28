/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.Desktop;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;

/**
 *
 * @author LuizV1
 */
public class ManipularArquivos {

    /**
     * Recebe o arquivo de relatório/descrição a ser salvo com o cadastro de
     * serviço. Cria um socket que irá enviar os dados do arquivo e o seu
     * respectivo nome. Para esse método funcionar, o servidor ou o computador
     * em que a aplicação de banco de dados deve estar com uma aplicação que
     * também cria um socket e escuta por requisições. O arquivo enviado será
     * renomeado com o código do serviço + o próprio nome do arquivo, e será
     * salvo no diretório C:\Synchro Relatorios\, no computador servidor.
     *
     * @param nomeArquivo O nome do arquivo a ser salvo.
     * @param diretorioArquivo O diretório do arquivo no computador cliente, a
     * ser salvo.
     * @param CodigoServico O código do serviço que terá o arquivo relacionado.
     * @throws IOException Joga uma excessão de erro de I/O
     */
    public static void enviarArquivoServico(String nomeArquivo, String diretorioArquivo, String CodigoServico) throws IOException {
        /*
        Instancia um socket. O construtor recebe 2 parâmetros, o IP do computador
        que está executando o banco de dados, e a porta a ser utilizada pelo socket.
        Esse IP será o mesmo utilizado na tela de login do sistema, sendo o mesmo
        IP do banco de dados.
        
        A porta socket 5005 é arbitrária. Pode ser trocada por qualquer valor, 
        desde que seja acima das portas exclusivas do sistema. Se alterada, 
        O aplicativo que irá escutar requisições também precisa ter o socket trocado.
         */

        Socket sock = new Socket(dao.Conexao.getServerName(), 5005);

        /*
        Preparação do arquivo. Um objeto File é instanciado, o construtor recebe 
        um parâmetro, que é o diretório do arquivo presente no computador cliente.
         */
        File arquivo = new File(diretorioArquivo);
        /*
        Um array de byes é criado, que irá representar o tamanho total do arquivo
        a ser transferido pela rede.
         */
        byte[] mybytearray = new byte[(int) arquivo.length()];
        /*
        Um objeto do tipo FileInputStream é instanciado, é um wrapper para o arquivo,
        como se estivesse preparando-o.
         */
        FileInputStream fis = new FileInputStream(arquivo);
        /*
        Objeto do tipo BufferedInputStream é instanciado com o objeto do tipo
        FileInputStream. Adiciona funcionalidades adicionais para o processamento
        do arquivo.
         */
        BufferedInputStream bis = new BufferedInputStream(fis);

        /*
        Objeto do tipo DataInputStream é criado. Esse será o objeto que irá
        carregar o nome do arquivo e seus respectivos dados pela rede.
         */
        DataInputStream dis = new DataInputStream(bis);

        /*
        Leitura de todos os bytes a ser transferido.
         */
        dis.readFully(mybytearray, 0, mybytearray.length);

        /*
        Objeto do tipo OutputStream é instanciado e o socket é inicializado. 
         */
        OutputStream os = sock.getOutputStream();

        /*
        Aqui o arquivo é enviado com seu nome e dados para o destino.
         */
        DataOutputStream dos = new DataOutputStream(os);
        /*
        Aqui o arquivo será renomeado para o código do serviço + o próprio nome.
         */
        dos.writeUTF(CodigoServico + "-" + arquivo.getName());
        dos.writeLong(mybytearray.length);
        dos.write(mybytearray, 0, mybytearray.length);
        dos.flush();

        /*
        O arquivo é escrito no computador destino.
         */
        os.write(mybytearray, 0, mybytearray.length);
        os.flush();

        /*
        Fechamento do socket.
         */
        os.close();
        dos.close();
        sock.close();

        JOptionPane.showMessageDialog(null, "O arquivo " + nomeArquivo + " foi salvo em \n"
                + "\\\\" + dao.Conexao.getServerName() + "\\Synchro Relatorios\\" + CodigoServico + "-" + nomeArquivo, "Arquivo enviado com sucesso", 1);

        //deletarArquivo(diretorioArquivoServico);
    }

    /* 
    public static Path copiarArquivoComCodServ(String nomeArquivo, String diretorioArquivo, String CodigoServico) throws IOException {
        Path origem = Paths.get(diretorioArquivo);
        Path destino = Paths.get("C:\\xyz\\"+CodigoServico+"-"+nomeArquivo);
        
            Path temp = Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);

            if (temp != null) {
                System.out.println("File renamed and moved successfully");
                return destino;
            } else {
                System.out.println("Failed to move the file");
                return null;
            }

    }*/
 /*
    public static void deletarArquivo(String diretorio) throws IOException {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ManipularArquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        Files.deleteIfExists(Paths.get(diretorio));
    }*/
    public static void copiarArquivoNoServidor(String nomeArquivo, String diretorioArquivo, String CodigoServico) throws IOException {
        Socket socket = null;
        String host = dao.Conexao.getServerName();

        socket = new Socket(host, 5005);

        File file = new File(diretorioArquivo);
        // Get the size of the file
        long length = file.length();
        byte[] bytes = new byte[16 * 1024];
        InputStream in = new FileInputStream(file);
        OutputStream out = socket.getOutputStream();

        int count;
        while ((count = in.read(bytes)) > 0) {
            out.write(bytes, 0, count);
        }

        out.close();
        in.close();
        socket.close();
        //        try {
//        Path source = Paths.get(diretorioOrigem);
//        SmbFile newFile = new SmbFile("smb://192.168.100.200/Synchro Relatorios/teste.txt", new NtlmPasswordAuthentication(null, "Luiz", "desk"));
//        try (OutputStream out = newFile.getOutputStream()) {
//            Files.copy(source, out);
//        }
//        
//        } catch (IOException ex) {
//            System.err.print(ex);
//        }
//        
//        
//        try {
//            
//            System.setProperty("jcifs.smb.client.username", "Luiz");
//		//Lê a senha 
//		System.setProperty("jcifs.smb.client.password", "desk");  
//            
//            InputStream in = new FileInputStream(new File(diretorioOrigem));
//            NtlmPasswordAuthentication authentication = new NtlmPasswordAuthentication("Luiz:desk"); // replace with actual values
//            SmbFile file = new SmbFile("file://192.168.100.200/Synchro Relatorios/teste.txt", authentication); // note the different format
//            OutputStream out = file.getOutputStream();
//
//            // Transfer bytes from in to out
//            byte[] buf = new byte[1024];
//            int len;
//            while ((len = in.read(buf)) > 0) {
//                out.write(buf, 0, len);
//            }
//            in.close();
//            out.close();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ManipularArquivos.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(ManipularArquivos.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        
//        Path origem = Paths.get(diretorioOrigem);
//        extensaoArquivo = "txt";
//        Path destino = Paths.get("\\\\192.168.100.200\\Synchro Relatorios\\" + CodigoServico + "." + extensaoArquivo);
//        try {
//            Path temp = Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);
//
//            if (temp != null) {
//                System.out.println("File renamed and moved successfully");
//            } else {
//                System.out.println("Failed to move the file");
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(ManipularArquivos.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public static void lerArquivoJanelas() {
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
            escreverArquivoJanelas();
        } catch (IOException ex) {
            System.out.println("Erro ao ler o arquivo '" + fileName + "'");
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }

    public static void lerArquivoConfiguracoes() throws IOException {
        String fileName = "configuracoes.txt";
        String line = null;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            System.out.println("Leitura Configurações");

            /*
            Limite de Configuracao é uma variável flag para contar as linhas do arquivo de texto.
            Ela representa quantas opções de configuração o sistema possui atualmente, por isso deve ser
            igual a quantidade de dados de configuração que o sistema possui. Caso seja diferente,
            chama o metodo que reseta o arquivo reconstruindo para as configurações padrão.
            linha irá receber o conteudo atual da linha do arquivo sendo lido.
            Opcao irá receber somente o texto que equivale a opcao da linha.
             */
            int limiteConfiguracao = 0;
            String linha;
            String opcao;

            /*
            Laço que percorre todas as linhas do arquivo de texto.
            Enquanto a linha não for nula, continua avançando
            das linhas de cima para baixo do arquivo de texto.
             */
            try {
                while ((line = bufferedReader.readLine()) != null) {
                    /*Switch Case para determinar qual é a opção para ser armazenada no sistema.
                    É feito um processamento com substring para remover todo o texto da linha
                    até encontrar um caractere "=". Também remove o sinal de igual.
                    Logo em seguida, o trim é chamado para remover qualquer espaço em branco.
                     */
                    switch (limiteConfiguracao) {
                        case 0:
                            linha = line;
                            opcao = linha.substring(linha.indexOf("=") + 1);
                            opcao.trim();
                            Opcoes.setLogin(opcao);
                            break;
                        case 1:
                            linha = line;
                            opcao = linha.substring(linha.indexOf("=") + 1);
                            opcao.trim();
                            Opcoes.setIp(opcao);
                            break;
                        case 2:
                            linha = line;
                            opcao = linha.substring(linha.indexOf("=") + 1);
                            opcao.trim();
                            Opcoes.setPorta(opcao);
                            break;
                        case 3:
                            linha = line;
                            opcao = linha.substring(linha.indexOf("=") + 1);
                            opcao.trim();
                            Opcoes.setSID(opcao);
                            break;
                        case 4:
                            linha = line;
                            opcao = linha.substring(linha.indexOf("=") + 1);
                            opcao.trim();
                            Opcoes.setUsuarioDB(opcao);
                            break;
                        case 5:
                            linha = line;
                            opcao = linha.substring(linha.indexOf("=") + 1);
                            opcao.trim();
                            Opcoes.setSenhaDB(opcao);
                            break;
                    }

                    limiteConfiguracao++;
                }
            } catch (Exception ex) {
                resetarConfiguracoes();
            }

            if (limiteConfiguracao != Opcoes.qtdOpcoes) {
                resetarConfiguracoes();
            }

            bufferedReader.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Não foi possível abrir o arquivo '" + fileName + "'");
            resetarConfiguracoes();
        } catch (IOException ex) {
            System.out.println("Erro ao ler o arquivo '" + fileName + "'");
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }

    public static void escreverArquivoJanelas() {

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

    public static void escreverArquivoConfiguracoes() throws IOException {

        String fileName = "configuracoes.txt";

        try {

            FileWriter fileWriter = new FileWriter(fileName);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            System.out.println("escrita configuracoes");
            int limiteConfiguracao = 0;
            String linha;

            linha = "Login=" + Opcoes.getLogin();
            bufferedWriter.write(linha);
            bufferedWriter.newLine();
            limiteConfiguracao++;
            linha = "IP=" + Opcoes.getIp();
            bufferedWriter.write(linha);
            bufferedWriter.newLine();
            limiteConfiguracao++;
            linha = "Porta=" + Opcoes.getPorta();
            bufferedWriter.write(linha);
            bufferedWriter.newLine();
            limiteConfiguracao++;
            linha = "SID=" + Opcoes.getSID();
            bufferedWriter.write(linha);
            bufferedWriter.newLine();
            limiteConfiguracao++;
            linha = "UsuárioDB=" + Opcoes.getUsuarioDB();
            bufferedWriter.write(linha);
            bufferedWriter.newLine();
            limiteConfiguracao++;
            linha = "SenhaDB=" + Opcoes.getSenhaDB();
            bufferedWriter.write(linha);
            bufferedWriter.newLine();
            limiteConfiguracao++;

            System.out.println(linha);

            if (limiteConfiguracao != Opcoes.qtdOpcoes) {
                resetarConfiguracoes();
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

        JOptionPane.showMessageDialog(null, "Arquivo 'acessojanelas.txt' corrompido ou não foi encontrado. \n\n"
                + "O arquivo será reconstruído, e as janelas mais acessadas serão redefinidas para valores padrões.");
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
        escreverArquivoJanelas();
    }

    public static void resetarConfiguracoes() throws IOException {
        JOptionPane.showMessageDialog(null, "Arquivo 'configuracoes.txt' corrompido ou não foi encontrado. \n\n"
                + "O arquivo será reconstruído, e as configuracões serão redefinidas para valores padrãoes.");
        Opcoes.setLogin("");
        Opcoes.setIp("127.0.0.1");
        Opcoes.setPorta("1521");
        Opcoes.setSID("XE");
        Opcoes.setUsuarioDB("system");
        Opcoes.setSenhaDB("system");
        escreverArquivoConfiguracoes();
    }

    public static void lerEAbrirArquivoServidor(String nomeArquivo) {
        try {
            Socket socket = new Socket(control.Opcoes.getIp(), 5006);

            //Send the message to the server
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            String stringEnviada = nomeArquivo;
            bw.write(stringEnviada);
            bw.flush();
            System.out.println("Message sent to the server : " + stringEnviada);

            os.close();
            osw.close();
            bw.close();
            socket.close();

            //Fim envio do nome do arquivo//
            //começo do download do arquivo//
            int bytesRead;
            int current = 0;

            ServerSocket serverSocket = new ServerSocket(5007);

            String pastaPadrao = "C:/Synchro Relatorios Recebidos";

            Path diretorioPasta = Paths.get(pastaPadrao);

            if (!Files.exists(diretorioPasta)) {
                Files.createDirectory(diretorioPasta);
                /*atualizarLogAtividadeRecebimento("Diretório para salvar arquivos não encontrada.\n"
                    + "Foi criado um novo diretório: C:\\Synchro Relatorios");*/
            }

            //atualizarLogAtividadeRecebimento("Esperando recebimento de arquivo...");
            Socket clientSocket = null;
            clientSocket = serverSocket.accept();

            //atualizarLogAtividadeRecebimento("Socket conectado. IP do cliente: " + clientSocket.getInetAddress());
            InputStream in = clientSocket.getInputStream();

            DataInputStream clientData = new DataInputStream(in);

            String fileName = clientData.readUTF();

            //Verificação se o arquivo a ser salvo já existe
            String pastaArquivoExistente = "C:/Synchro Relatorios Recebidos/" + fileName;

            Path diretorioArquivoExistente = Paths.get(pastaArquivoExistente);

            if (Files.exists(diretorioArquivoExistente)) {
                System.out.println("Arquivo recebido duplicado.");
                Files.delete(diretorioArquivoExistente);
                System.out.println("Arquivo já existente removido.");
            }

            //atualizarLogAtividadeRecebimento("Nome do arquivo a ser salvo: " + fileName);
            OutputStream output = new FileOutputStream("C:\\Synchro Relatorios Recebidos\\" + fileName);
            long size = clientData.readLong();
            byte[] buffer = new byte[1024];
            while (size > 0 && (bytesRead = clientData.read(buffer, 0, (int) Math.min(buffer.length, size))) != -1) {
                output.write(buffer, 0, bytesRead);
                size -= bytesRead;
            }
            // Closing the FileOutputStream handle
            serverSocket.close();
            clientSocket.close();
            in.close();
            clientData.close();
            output.close();

            /*atualizarLogAtividadeRecebimento("Arquivo recebido e salvo com sucesso em:\n"
                    + "C:\\Synchro Relatorios\\" + fileName);*/
            //código para abrir o arquivo
            File file = new File(pastaArquivoExistente);

            //verifica se Desktop é compatível no OS
            if (!Desktop.isDesktopSupported()) {
                System.out.println("Desktop is not supported");
                return;
            }
            //abre o arquivo
            Desktop desktop = Desktop.getDesktop();
            if (file.exists()) {
                desktop.open(file);
            }

        } catch (IOException ex) {
            
        } catch (Exception ex) {

        }

    }

}