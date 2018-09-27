/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.Frame;

/**
 *
 * @author LuizV1
 */
public class Janelas {

    public Janelas(String nome, int acesso) {
        this.nome = nome;
        this.acesso = acesso;
    }
    
    static int qtdJanelas = 18;
    private String nome;
    private int acesso;
    
    public static void fecharTodasJanelas(){
        for (Frame fr : Frame.getFrames()) {
                fr.dispose();
            }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAcesso() {
        return acesso;
    }

    public void setAcesso(int acesso) {
        this.acesso = acesso;
    }

    public int getQtdJanelas() {
        return qtdJanelas;
    }

    
    
    
    

    

    

    
}
