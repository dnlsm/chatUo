/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
    Esta classe irá preparar as requisições

*/
package com.chatuo.db;

import static com.chatuo.db.BDConnetion.DATETIME_FORMAT;
import com.chatuo.db.datatype.ContReg;
import com.chatuo.db.datatype.ConvReg;
import com.chatuo.db.datatype.MsgReg;
import java.util.Calendar;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Danilo
 */
public class Dados {
    /*
    private BDConnetion bdConnection;
    private Calendar lastSync;
    public Dados() throws SQLException{
        System.out.println(new SimpleDateFormat(DATETIME_FORMAT).format(Calendar.getInstance().getTime()));
        
        
        
        bdConnection = new BDConnetion();
        bdConnection.initialize();
        bdConnection.showInfo();
        bdConnection.teste();
        
        ArrayList<ConvReg> conversas = null;
        try {
            conversas = bdConnection.getConversationInfo();
            for(ConvReg conversa: conversas){
                System.out.println("-->"+conversa.getNOME());
                for(ContReg contato: conversa.getPARTICIPANTES()){
                    System.out.println(" +-->"+contato.getLOGIN_CONTATO());
                }
                System.out.println("");
            }
        } catch (ParseException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ArrayList<MsgReg> messages;
        messages = bdConnection.searchMessage("2", null, null);
        
        for(MsgReg msg: messages){
            System.out.println( "Contato: " + msg.getID_CONTATO()+
                                "\tData: " + new SimpleDateFormat(DATETIME_FORMAT).format(msg.getDATE_TIME().getTime())+
                                "\tDado: " + msg.getDADO());
        }
        
        bdConnection.storeMessage(new MsgReg(0, 0, 0, Calendar.getInstance(),"INHAÍÍN!!!!!"),
                                    conversas.get(1),
                                    conversas.get(1).getPARTICIPANTES().get(2));
        
        messages = bdConnection.searchMessage("2", null, null);
        
        for(MsgReg msg: messages){
            System.out.println( "Contato: " + msg.getID_CONTATO()+
                                "\tData: " + new SimpleDateFormat(DATETIME_FORMAT).format(msg.getDATE_TIME().getTime())+
                                "\tDado: " + msg.getDADO());
        }
        
        bdConnection.setConfigParam(
            "LastUPDATE",
            new SimpleDateFormat(DATETIME_FORMAT).format(Calendar.getInstance().getTime()));
        
        System.out.println("Last update = '"+bdConnection.getConfigParam("LastUPDATE")+"'");
        System.out.println(new SimpleDateFormat(DATETIME_FORMAT).format(Calendar.getInstance().getTime()));

    }
    private Calendar ultimaSinc;
    
    
    */
}
