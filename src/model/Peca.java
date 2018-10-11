/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JOptionPane;

/**
 *
 * @author LuizV1
 */
public class Peca {
    private String codigoPeca;
    private String categoriaPeca;
    private String nomePeca;
    private int quantidadePeca;
    private float valorUnitario;

    public Peca() {
    }   
    
    public Peca(String codigoPeca, String nomePeca, String categoriaPeca, int quantidadePeca, String valorUnitario) {
        this.codigoPeca = codigoPeca;
        this.nomePeca = nomePeca;
        this.categoriaPeca = categoriaPeca;
        this.quantidadePeca = quantidadePeca;
        setValorUnitario(valorUnitario);
    }
    
//        private ArrayList<Peca> gerarArrayPeca (){
//
//            ArrayList<Peca> lista = new ArrayList<>();
//            Peca p = new Peca();
//            System.out.println("GerarArrayPeca "+tblListagemPeca.getRowCount());
//            
//            for (int i = 0; i< tblListagemPeca.getRowCount(); i++) {
//                p.setCodigoPeca((int)tblListagemPeca.getModel().getValueAt(i, 0));
//                p.setNomePeca((String)tblListagemPeca.getModel().getValueAt(i, 1));
//                p.setCategoriaPeca((String)tblListagemPeca.getModel().getValueAt(i, 2));
//                p.setQuantidadePeca((int)tblListagemPeca.getModel().getValueAt(i, 3));
//                p.setValorUnitario((Float)tblListagemPeca.getModel().getValueAt(i, 4));
//                lista.add(i, p);
//                JOptionPane.showMessageDialog(null,"gerarArrayPeca\n"+lista.get(i).getCodigoPeca());
//                System.out.println(lista.get(i).getNomePeca());
//                System.out.println(lista.get(i).getCategoriaPeca());
//                System.out.println(lista.get(i).getQuantidadePeca());
//                System.out.println(lista.get(i).getValorUnitario()+"\n\n");
//            }
//            System.out.println("Tamanho array"+lista.size());
//            return lista;
//        }

    public String getCodigoPeca() {
        return codigoPeca;
    }

    public void setCodigoPeca(String codigoPeca) {
        this.codigoPeca = codigoPeca;
    }

    public String getCategoriaPeca() {
        return categoriaPeca;
    }

    public void setCategoriaPeca(String categoriaPeca) {
        this.categoriaPeca = categoriaPeca;
    }

    public String getNomePeca() {
        return nomePeca;
    }

    public void setNomePeca(String nomePeca) {
        this.nomePeca = nomePeca;
    }

    public int getQuantidadePeca() {
        return quantidadePeca;
    }

    public void setQuantidadePeca(int quantidadePeca) {
        this.quantidadePeca = quantidadePeca;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(String valorUnitario) {
        valorUnitario = valorUnitario.replace(",", ".");
        try {
        this.valorUnitario = Float.parseFloat(valorUnitario);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Valor unitário inválido. Use somente números inteiros e/ou decimais.", "Erro", 0);
        }
    }
}
