/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Luiz
 */
public class Usuario {
    
    private String codigoFuncionario;
    private String login;
    private String senha;
    
    public Usuario()
    {
        
    }

    public Usuario(String codigoFuncionario, String login, String senha) {
        this.codigoFuncionario = codigoFuncionario;
        this.login = login;
        this.senha = senha;
    }
    
   

    public String getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(String codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
    
}
