/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author LuizV1
 */
public class TextSize {
    public static String maxLenghtLogin (String str) {
         String valor = "";
            if(str.length() > 100){
	        valor = str.substring(0,100);
                str = valor;
            }
	    return str;
    }
    
    public static String maxLenghtSenha (String str) {
         String valor = "";
            if(str.length() > 8){
	        valor = str.substring(0,8);
                str = valor;
            }
	    return str;
    }
    public static String maxLenghtFuncionario (String str) {
         String valor = "";
            if(str.length() > 10){
	        valor = str.substring(0,10);
                str = valor;
            }
	    return str;
    }
    
    public static String maxLenghtServico (String str) {
         String valor = "";
            if(str.length() > 10){
	        valor = str.substring(0,10);
                str = valor;
            }
	    return str;
    }
   
    
    public static String maxLenghtCep(String str) {
         String valor = "";
            if(str.length() > 8){
	        valor = str.substring(0,8);
                str = valor;
            }
	    return str;
    }
    
    public static String maxLenghtCPFCNPJ (String str, boolean cpfOuCnpj) {
        if (cpfOuCnpj) {
         String valor = "";
            if(str.length() > 11){
	        valor = str.substring(0,11);
                str = valor;
            }
	    return str;   
        } else {
            String valor = "";
            if(str.length() > 14){
	        valor = str.substring(0,14);
                str = valor;
            }
	    return str;
        }
         
    }
    
    public static String maxLenghtNomeRazao(String str) {
         String valor = "";
            if(str.length() > 100){
	        valor = str.substring(0,100);
                str = valor;
            }
	    return str;
    }
    
    public static String maxLenghtTelefone(String str) {
         String valor = "";
            if(str.length() > 10){
	        valor = str.substring(0,10);
                str = valor;
            }
	    return str;
    }
    
    public static String maxLenghtNrLogradouro(String str) {
         String valor = "";
            if(str.length() > 10){
	        valor = str.substring(0,10);
                str = valor;
            }
	    return str;
    }
    
    public static String maxLenghtCelularRamal (String str, boolean celOuRamal) {
        if (celOuRamal) {
         String valor = "";
            if(str.length() > 11){
	        valor = str.substring(0,11);
                str = valor;
            }
	    return str;   
        } else {
            String valor = "";
            if(str.length() > 5){
	        valor = str.substring(0,5);
                str = valor;
            }
	    return str;
        }
         
    }
    
}
