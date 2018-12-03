/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

/**
 *
 * @author Luiz
 */
public class Usuario {

    private String codigoFuncionario;
    private String login;
    private String senha;

    public Usuario() {

    }

    public Usuario(String codigoFuncionario, String login, String senha) {
        this.codigoFuncionario = codigoFuncionario;
        this.login = login;
        this.setSenhaHashMd5(senha);
    }

    public String getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setSenhaHashMd5(String senha) {
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(senha.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) {
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            }
            this.senha =  hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível encriptografar a senha.", "Erro - Senha encriptografada", 0);
        }
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
