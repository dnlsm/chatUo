/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
    Esta classe se encarrega de fazer a conexão com o banco local e verificar se
todas as tabelas existem.
*/
package com.chatuo.db;

import com.chatuo.db.datatype.ContReg;
import com.chatuo.db.datatype.ConvReg;
import com.chatuo.db.datatype.MsgReg;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danilo
 */
public class BDConnetion {
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
    private Connection connection;
    private ArrayList<String> tables;
    
    private String[] A;
    
    public BDConnetion(){
        tables = new ArrayList<>();
    }
    
    public boolean isConnected(){
        return !(connection == null);
    }
    
    public void initialize() throws SQLException{
        if (this.connect()){
            Statement statement = connection.createStatement();
            ResultSet result;
            
            result = statement.executeQuery(
                    "SELECT * FROM sqlite_master WHERE type='table';");

            tables.clear();
            
            while ( result.next() ){
                tables.add(result.getString(2));
            }
            
            createTables(statement);
            statement.close();
            this.disconnect();
        }
    }
    
    private boolean createTables(Statement statement){
        System.out.println("Criando Tabelas");
        try{
                if (findTable("CONFIGURACAO")==false){
                    statement.executeUpdate(
                            "CREATE TABLE CONFIGURACAO(\n" +
                            "PARAM              VARCHAR(20)     NOT NULL    PRIMARY KEY,\n"+
                            "VALUE              BLOB);");  
                }
                if (findTable("CONTATO")==false){
                    statement.executeUpdate(
                            "CREATE TABLE CONTATO(\n" +
                            "ID_CONTATO         INTEGER	NOT NULL	PRIMARY KEY,\n"+
                            "LOGIN_CONTATO      VARCHAR(20)	NOT NULL	UNIQUE,\n"+
                            "FOTO               VARCHAR(50));");  
                }
                if (findTable("CONVERSA_INFO")==false){
                    statement.executeUpdate(
                            "CREATE TABLE CONVERSA_INFO(\n" +
                            "ID_CONVERSA	INTEGER		NOT NULL    PRIMARY KEY,\n"+
                            "NOME           VARCHAR(20)     NOT NULL,\n"+
                            "CRIACAO        DATETIME        NOT NULL);");  
                }
                if (findTable("CONVERSA")==false){
                    statement.executeUpdate(
                            "CREATE TABLE CONVERSA(\n" +
                            "ID_CONVERSA	INTEGER		NOT NULL,\n"+
                            "ID_CONTATO	INTEGER		NOT NULL,\n"+
                            "PRIMARY KEY(ID_CONVERSA,ID_CONTATO),\n"+
                            "FOREIGN KEY(ID_CONVERSA)	REFERENCES CONVERSA_INFO(ID_CONVERSA),\n"+
                            "FOREIGN KEY(ID_CONTATO)	REFERENCES CONTATO(ID_CONTATO));");  
                }

                if (findTable("DADOS")==false){
                    statement.executeUpdate(
                            "CREATE TABLE DADOS(\n" +
                            "ID_DADO            INTEGER		NOT NULL        PRIMARY KEY AUTOINCREMENT,\n" +
                            "ID_CONVERSA	INTEGER		NOT NULL,\n" +
                            "ID_CONTATO         INTEGER		NOT NULL,\n" +
                            "DATA_HORA          DATETIME        NOT NULL,\n" +
                            "DADO		VARCHAR(255)	NOT NULL,\n" +
                            "FOREIGN KEY(ID_CONVERSA)	REFERENCES CONVERSA(ID_CONVERSA),\n"+
                            "FOREIGN KEY(ID_CONTATO)	REFERENCES CONTATO(ID_CONTATO));");  
                }
        } catch (SQLException ex) {
            System.err.println("ERRO AO CRIAR TABELAS");
            Logger.getLogger(BDConnetion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    private boolean connect(){
        try {
            if (!this.isConnected()){
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection("jdbc:sqlite:data.db");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BDConnetion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDConnetion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public void disconnect(){
        try {
            connection.close();
            connection = null;
        } catch (SQLException ex) {
            Logger.getLogger(BDConnetion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void showInfo() throws SQLException{
        if (connect()){
            Statement statement = null;
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(BDConnetion.class.getName()).log(Level.SEVERE, null, ex);
            }
            ResultSet result = statement.executeQuery("SELECT * FROM sqlite_master WHERE type='table';");
            while (result.next()){
                System.out.println("*------------------------*");
                System.out.println(result.getString(1)+"//"+result.getString(2)+
                        "//"+result.getString(3)+"//"+result.getString(4));
                System.out.println(result.getString(5));
            }
            statement.close();
            disconnect();
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATETIME_FORMAT);
        String s = dateFormat.format(Calendar.getInstance().getTime());
        System.out.println(s+"|End info");
    }
    
    public void teste(){
        if(connect()){
            try {
                Statement statement = connection.createStatement();
                new Teste().test(statement);
                statement.close();
                disconnect();
            } catch (SQLException ex) {
                Logger.getLogger(BDConnetion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private boolean findTable(String TableName){
        for(String Element: tables){
            if (TableName.equals(Element)) return true;
        }
        return false;
    }
     
    public ArrayList<MsgReg> searchMessage(int chatID, Calendar fromDateTime, Calendar toDateTime) throws SQLException{
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATETIME_FORMAT);
        
        String dateInterval = "";
        if (fromDateTime != null){
              String fromDT = dateFormat.format(fromDateTime.getTime());
              dateInterval = dateInterval.concat("DATA_HORA >= '".concat(fromDT).concat("'"));
        }
        if (toDateTime != null){
            if (!dateInterval.equals("")) dateInterval = dateInterval.concat(" AND ");
            String toDT     = dateFormat.format(toDateTime.getTime());
            dateInterval = dateInterval.concat("DATA_HORA <= '".concat(toDT).concat("'"));
        }
        if (!dateInterval.equals("")) dateInterval = "AND ".concat(dateInterval);
        if(connect()){
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(
                                    "SELECT * FROM DADOS WHERE ID_CONVERSA = " + chatID+ " "+ 
                                    dateInterval+
                                    " ORDER BY DATA_HORA ASC;");
            ArrayList<MsgReg> messages = new ArrayList<>();
            
            while(result.next()){
                int         ID_DADO     = result.getInt("ID_DADO");
                int         ID_CONVERSA = result.getInt("ID_CONVERSA");
                int         ID_CONTATO  = result.getInt("ID_CONTATO");
                Calendar    DATA_HORA   = Calendar.getInstance();
                try {
                    DATA_HORA.setTime(dateFormat.parse(result.getString("DATA_HORA")));
                } catch (ParseException ex) {
                    Logger.getLogger(BDConnetion.class.getName()).log(Level.SEVERE, null, ex);
                }
                String      DADO        = result.getString("DADO");
                
                MsgReg msg = new MsgReg(ID_DADO, ID_CONVERSA, ID_CONTATO, DATA_HORA, DADO);
                messages.add(msg);
            }
            
            return messages;
        }
        else
        return null;
    }
    
    public boolean storeMessage(MsgReg msg, ConvReg conv, ContReg cont){
        if(connect()){
            try{
                Statement stm = connection.createStatement();
                String sql = "INSERT INTO DADOS (ID_CONVERSA, ID_CONTATO, DATA_HORA, DADO) "
                        + "VALUES("+
                        conv.getID_CONVERSA()+","+
                        cont.getID_CONTATO() +","+
                        "'"+new SimpleDateFormat(DATETIME_FORMAT).format(msg.getDATE_TIME().getTime())+"',"+
                        "'"+msg.getDADO()+"');";
                System.out.println(sql);
                stm.executeUpdate(sql);
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(BDConnetion.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        return false;
    }
    
    public ArrayList<ConvReg> getConversationInfo() throws SQLException, ParseException{
        if(connect()){
            Statement stm = connection.createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM CONTATO ORDER BY ID_CONTATO ASC");
            ArrayList<ContReg> contatos = new ArrayList<>();
            while(result.next()){
                contatos.add(new ContReg(   result.getInt("ID_CONTATO"),
                                            result.getString("LOGIN_CONTATO"),
                                            result.getString("FOTO")));
            }
            
            for(ContReg contato: contatos){
                System.out.println(contato.getID_CONTATO()+":"+contato.getLOGIN_CONTATO());
            }
            result = stm.executeQuery("SELECT * FROM CONVERSA_INFO ORDER BY ID_CONVERSA ASC");
            ArrayList<ConvReg> conversas = new ArrayList<>();
            while(result.next()){
                Calendar c = Calendar.getInstance();
                c.setTime(new SimpleDateFormat(DATETIME_FORMAT).parse(result.getString("CRIACAO")));
                                        
                conversas.add( new ConvReg( result.getInt("ID_CONVERSA"),
                                            result.getString("NOME"),
                                            c));
            }
            result = stm.executeQuery("SELECT * FROM CONVERSA ORDER BY ID_CONVERSA ASC");
            while(result.next()){
                ContReg contato     = findContato(contatos, result.getInt("ID_CONTATO"));
                ConvReg conversa    = findConversa(conversas, result.getInt("ID_CONVERSA"));
                if (contato != null && conversa != null){
                    conversa.getPARTICIPANTES().add(contato);
                }
                else
                    System.err.println("Inconsistência Encontrada");
            }
            
            return conversas;
        }
        return null;
        
    }
    
    public ContReg findContato(ArrayList<ContReg> contatos ,int ID_CONTATO){
        for(int i = 0; i < contatos.size(); i++){
            if (contatos.get(i).getID_CONTATO()== ID_CONTATO) {
                return contatos.get(i);
            }     
        }
        return null;
    }
    
    private ConvReg findConversa(ArrayList<ConvReg> conversas ,int ID_CONVERSA){
        for(int i = 0; i < conversas.size(); i++){
            if (conversas.get(i).getID_CONVERSA()== ID_CONVERSA){
                return conversas.get(i);
            }     
        }
        return null;
    }
    
    public String getConfigParam(String paramName){
        if(connect()){
            Statement stm;
            try {
                stm = connection.createStatement();
                ResultSet result = stm.executeQuery("SELECT * FROM CONFIGURACAO WHERE PARAM ='"+paramName+"';");
                String output = result.getString("VALUE");
                return output;
            } catch (SQLException ex) {
                Logger.getLogger(BDConnetion.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        return null;
    }
    
    public boolean setConfigParam(String paramName, String paramValue){
        if(connect()){
            Statement stm;
            try {
                stm = connection.createStatement();
                
                    try {
                        stm.executeUpdate("INSERT INTO CONFIGURACAO\n"+
                                          "VALUES('"+paramName+"','"+paramValue+"');");
                        stm.close();
                        disconnect();
                        return true;
                    } catch (SQLException ex) {
                        stm.executeUpdate(  "UPDATE CONFIGURACAO\n"+
                                            "SET VALUE = '"+paramValue+ "'\n"+
                                            "WHERE PARAM = '"+paramName+"';");
                        stm.close();
                        disconnect();
                        return true;
                    }
            } catch (SQLException ex) {
                return false;
            }
        }
        return false;
    }
}      
