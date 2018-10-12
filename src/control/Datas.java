/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Date;

/**
 *
 * @author LuizV1
 */
public class Datas {
    private static byte dia;
    private static byte mes;
    private static int ano;
    
    public static String converterParaBrasileira (String data) {
        dia = Byte.parseByte(data.substring(8, 10));        
        mes = Byte.parseByte(data.substring(5, 7));
        ano = Integer.parseInt(data.substring(0, 4));
        return dia+"/"+mes+"/"+ano;
    }
    
    public static String converterParaAmericana (String data) {
        dia = Byte.parseByte(data.substring(0, 2));
        mes = Byte.parseByte(data.substring(3, 5));
        ano = Integer.parseInt(data.substring(6,10));
        return ano+"-"+mes+"-"+dia;
    }

        
}
