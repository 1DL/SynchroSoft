/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author LuizV1
 */
public class Datas {
    private static byte dia;
    private static byte mes;
    private static int ano;
    
    public static String converterParaBrasileira (String data) {
        String diaSTR, mesSTR, anoSTR;
        dia = Byte.parseByte(data.substring(8, 10));        
        mes = Byte.parseByte(data.substring(5, 7));
        ano = Integer.parseInt(data.substring(0, 4));
        
        if (dia < 10) {
            diaSTR = "0" + dia;
        } else {
            diaSTR = ""+dia;
        }
        if (mes <10) {
            mesSTR = "0" + mes;
        } else {
            mesSTR = ""+mes;
        }
        if (ano<10) {
            anoSTR = "000" + ano;
        } else if (ano < 100) {
            anoSTR = "00" + ano;
        } else if (ano < 1000) {
            anoSTR = "0" + ano;
        } else {
            anoSTR = ""+ano;
        }
        
        
        return diaSTR+"/"+mesSTR+"/"+anoSTR;
    }
    
    public static String converterParaAmericana (String data) {
        String diaSTR, mesSTR, anoSTR;
        
        dia = Byte.parseByte(data.substring(0, 2));
        mes = Byte.parseByte(data.substring(3, 5));
        ano = Integer.parseInt(data.substring(6,10));
        
        if (dia < 10) {
            diaSTR = "0" + dia;
        } else {
            diaSTR = ""+dia;
        }
        if (mes <10) {
            mesSTR = "0" + mes;
        } else {
            mesSTR = ""+mes;
        }
        if (ano<10) {
            anoSTR = "000" + ano;
        } else if (ano < 100) {
            anoSTR = "00" + ano;
        } else if (ano < 1000) {
            anoSTR = "0" + ano;
        } else {
            anoSTR = ""+ano;
        }
        
        return anoSTR+"-"+mesSTR+"-"+diaSTR;
    }
    
    public static String getDiaHoje(){
        return converterParaBrasileira("" + new Date(Calendar.getInstance().getTimeInMillis()));
    }

        
}
