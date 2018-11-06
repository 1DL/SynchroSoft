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
    
    public static String maxLenghtCategoriaProduto(String str) {
        String valor = "";
        if (str.length() > 50) {
            valor = str.substring(0, 50);
            str = valor;
        }
        return str;
    }
    
    public static String maxLenghtData(String str) {
        String valor = "";
        if (str.length() > 10) {
            valor = str.substring(0, 10);
            str = valor;
        }
        return str;
    }

    public static String maxLenghtLogin(String str) {
        String valor = "";
        if (str.length() > 30) {
            valor = str.substring(0, 30);
            str = valor;
        }
        return str;
    }

    public static String maxLenghtSenha(String str) {
        String valor = "";
        if (str.length() > 8) {
            valor = str.substring(0, 8);
            str = valor;
        }
        return str;
    }

    public static String maxLenghtFuncionario(String str) {
        String valor = "";
        if (str.length() > 10) {
            valor = str.substring(0, 10);
            str = valor;
        }
        return str;
    }

    public static String maxLenghtServico(String str) {
        String valor = "";
        if (str.length() > 9) {
            valor = str.substring(0, 9);
            str = valor;
        }
        return str;
    }

    public static String maxLenghtCep(String str) {
        String valor = "";
        if (str.length() > 8) {
            valor = str.substring(0, 8);
            str = valor;
        }
        return str;
    }

    public static String maxLenghtCPFCNPJ(String str, boolean cpfOuCnpj) {
        str = str.replaceAll("[^0-9]", "");
        if (cpfOuCnpj) {
            String valor = "";
            if (str.length() > 11) {
                valor = str.substring(0, 11);
                str = valor;
            }
            
            return str;
        } else {
            String valor = "";
            if (str.length() > 14) {
                valor = str.substring(0, 14);
                valor = valor.replace("-", "");
                str = valor;
            }
            return str;
        }

    }

    public static String maxLenghtNomeRazao(String str) {
        String valor = "";
        if (str.length() > 100) {
            valor = str.substring(0, 100);
            str = valor;
        }
        return str;
    }

    public static String maxLenghtTelefone(String str) {
        str = str.replaceAll("[^0-9]", "");
        String valor = "";
        if (str.length() > 10) {
            valor = str.substring(0, 10);
            str = valor;
        }
        return str;
    }

    public static String maxLenghtNrLogradouro(String str) {
        String valor = "";
        if (str.length() > 10) {
            valor = str.substring(0, 10);
            str = valor;
        }
        return str;
    }

    public static String maxLenghtCelularRamal(String str, boolean celOuRamal) {
        str = str.replaceAll("[^0-9]", "");
        if (celOuRamal) {
            String valor = "";
            if (str.length() > 11) {
                valor = str.substring(0, 11);
                str = valor;
            }
            return str;
        } else {
            String valor = "";
            if (str.length() > 5) {
                valor = str.substring(0, 5);
                str = valor;
            }
            return str;
        }

    }

    public static String maxLenghtCodigoPeca(String str) {
        String valor = "";
        if (str.length() > 30) {
            valor = str.substring(0, 30);
            str = valor;
        }
        return str;
    }

    public static String maxLenghtNomePeca(String str) {
        String valor = "";
        if (str.length() > 40) {
            valor = str.substring(0, 40);
            str = valor;
        }
        return str;
    }
    
    public static String maxLenghtQuantidadePeca(String str) {
        str = str.replaceAll("[^0-9]", ""); 
        String valor = "";
            if(str.length() > 8){
	        valor = str.substring(0,8);
                str = valor;
            }
	    return str;
    }
    
    public static String maxLenghtValorPeca(String str) {
         String valor = "";
            if(str.length() > 7){
	        valor = str.substring(0,7);
                str = valor;
            }
	    return str;
    }
    
    public static String maxLenghtMaoDeObra(String str) {
         String valor = "";
            if(str.length() > 8){
	        valor = str.substring(0,8);
                str = valor;
            }
	    return str;
    }
    
    public static String maxLenghtSalario(String str) {
         String valor = "";
            if(str.length() > 13){
	        valor = str.substring(0,13);
                str = valor;
            }
	    return str;
    }
    
    public static String maxLenghtCargo(String str) {
         String valor = "";
            if(str.length() > 80){
	        valor = str.substring(0,80);
                str = valor;
            }
	    return str;
    }
    
    public static String maxLenghtHoraMensal(String str) {
         String valor = "";
            if(str.length() > 5){
	        valor = str.substring(0,5);
                str = valor;
            }
	    return str;
    }
    
    public static String maxLenghtEndereco(String str) {
         String valor = "";
            if(str.length() > 8){
	        valor = str.substring(0,8);
                str = valor;
            }
	    return str;
    }
    
    public static String maxLenghtLogradouro(String str) {
         String valor = "";
            if(str.length() > 100){
	        valor = str.substring(0,100);
                str = valor;
            }
	    return str;
    }
    
    public static String maxLenghtCidade(String str) {
         String valor = "";
            if(str.length() > 50){
	        valor = str.substring(0,50);
                str = valor;
            }
	    return str;
    }
    
    public static String maxLenghtEstado(String str) {
         String valor = "";
            if(str.length() > 2){
	        valor = str.substring(0,2);
                str = valor;
            }
	    return str;
    }
    
    
    
    public static String maxLenghtBairro(String str) {
         String valor = "";
            if(str.length() > 50){
	        valor = str.substring(0,50);
                str = valor;
            }
	    return str;
    }
    
    public static String maxLenghtValorDespesa(String str) {
         String valor = "";
            if(str.length() > 7){
	        valor = str.substring(0,7);
                str = valor;
            }
	    return str;
    }
    
    public static String maxLenghtDescricaoDespesa(String str) {
         String valor = "";
            if(str.length() > 4000){
	        valor = str.substring(0,4000);
                str = valor;
            }
	    return str;
    }

}
