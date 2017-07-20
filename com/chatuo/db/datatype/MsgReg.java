/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatuo.db.datatype;

import java.util.Calendar;
/**
 *
 * @author Danilo
 */
public class MsgReg {
    private int         ID_DADO;
    private int         ID_CONVERSA;
    private int         ID_CONTATO;
    private Calendar    DATE_TIME;
    private String      DADO;

    public ContReg getContato() {
        return contato;
    }

    public void setContato(ContReg contato) {
        this.contato = contato;
    }
    
    private ContReg     contato;
    
    public MsgReg(int ID_DADO, int ID_CONVERSA, int ID_CONTATO, Calendar DATE_TIME, String DADO){
        this.ID_DADO        = ID_DADO;
        this.ID_CONVERSA    = ID_CONVERSA;
        this.ID_CONTATO     = ID_CONTATO;
        this.DATE_TIME      = DATE_TIME;
        this.DADO           = DADO;
        
    }
    
    public int getID_DADO() {
        return ID_DADO;
    }

    public void setID_DADO(int ID_DADO) {
        this.ID_DADO = ID_DADO;
    }

    public int getID_CONVERSA() {
        return ID_CONVERSA;
    }

    public void setID_CONVERSA(int ID_CONVERSA) {
        this.ID_CONVERSA = ID_CONVERSA;
    }

    public int getID_CONTATO() {
        return ID_CONTATO;
    }

    public void setID_CONTATO(int ID_CONTATO) {
        this.ID_CONTATO = ID_CONTATO;
    }

    public Calendar getDATE_TIME() {
        return DATE_TIME;
    }

    public void setDATE_TIME(Calendar DATE_TIME) {
        this.DATE_TIME = DATE_TIME;
    }

    public String getDADO() {
        return DADO;
    }

    public void setDADO(String DADO) {
        this.DADO = DADO;
    }
    
}
