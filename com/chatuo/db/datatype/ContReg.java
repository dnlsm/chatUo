/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatuo.db.datatype;

/**
 *
 * @author Danilo
 */
public class ContReg {
        private int ID_CONTATO;
        private String LOGIN_CONTATO;
        private String FOTO;

    public ContReg(int ID_CONTATO, String LOGIN_CONTATO, String FOTO){
        this.ID_CONTATO     = ID_CONTATO;
        this.LOGIN_CONTATO  = LOGIN_CONTATO;
        this.FOTO           = FOTO;
    }
        
    public int getID_CONTATO() {
        return ID_CONTATO;
    }

    public void setID_CONTATO(int ID_CONTATO) {
        this.ID_CONTATO = ID_CONTATO;
    }

    public String getLOGIN_CONTATO() {
        return LOGIN_CONTATO;
    }

    public void setLOGIN_CONTATO(String LOGIN_CONTATO) {
        this.LOGIN_CONTATO = LOGIN_CONTATO;
    }

    public String getFOTO() {
        return FOTO;
    }

    public void setFOTO(String FOTO) {
        this.FOTO = FOTO;
    }
}
