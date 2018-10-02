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
public class Opcoes {
    private static String login ="";
    private static String ip ="";
    private static String porta ="";
    private static String SID ="";
    private static String usuarioDB ="";
    private static String senhaDB ="";
    
    static int qtdOpcoes = 6;

    public static String getLogin() {
        return login;
    }

    public static void setLogin(String aLogin) {
        login = aLogin;
    }

    public static String getIp() {
        return ip;
    }

    public static void setIp(String aIp) {
        ip = aIp;
    }

    public static String getPorta() {
        return porta;
    }

    public static void setPorta(String aPorta) {
        porta = aPorta;
    }

    public static String getSID() {
        return SID;
    }

    public static void setSID(String aSID) {
        SID = aSID;
    }

    public static String getUsuarioDB() {
        return usuarioDB;
    }

    public static void setUsuarioDB(String aUsuarioDB) {
        usuarioDB = aUsuarioDB;
    }

    public static String getSenhaDB() {
        return senhaDB;
    }

    public static void setSenhaDB(String aSenhaDB) {
        senhaDB = aSenhaDB;
    }
    
    
}
