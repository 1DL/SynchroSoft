/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.swing.JFrame;
import java.sql.Connection;
import view.FrmPrincipal;
/**
 *
 * @author LuizV1
 */
public class Programa {
    public static JFrame principal;
    public static Connection con;
    public static void main(String[] args) {
        principal = new FrmPrincipal();
        principal.setVisible(true);
    }
}
