/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatuo.db.datatype;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Danilo
 */
public class ConvReg {
        private int                 ID_CONVERSA;
        private String              NOME;
        private Calendar            CRIACAO;
        private ArrayList<ContReg>  PARTICIPANTES;

    public ConvReg(int ID_CONVERSA, String NOME, Calendar CRIACAO){
        this.ID_CONVERSA    = ID_CONVERSA;
        this.NOME           = NOME;
        this.CRIACAO        = CRIACAO;
        this.PARTICIPANTES  = new ArrayList<>();
    }    
        
    public int getID_CONVERSA() {
        return ID_CONVERSA;
    }

    public void setID_CONVERSA(int ID_CONVERSA) {
        this.ID_CONVERSA = ID_CONVERSA;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public Calendar getCRIACAO() {
        return CRIACAO;
    }

    public void setCRIACAO(Calendar CRIACAO) {
        this.CRIACAO = CRIACAO;
    }

    public ArrayList<ContReg> getPARTICIPANTES() {
        return PARTICIPANTES;
    }

    public void setPARTICIPANTES(ArrayList<ContReg> PARTICIPANTES) {
        this.PARTICIPANTES = PARTICIPANTES;
    }

        
}
