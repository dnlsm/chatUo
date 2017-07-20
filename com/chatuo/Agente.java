/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatuo;
import com.chatuo.UI.Conversa.UIConversaController;
import com.chatuo.db.BDConnetion;
import com.chatuo.db.datatype.ContReg;
import com.chatuo.db.datatype.ConvReg;
import com.chatuo.db.datatype.MsgReg;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
/**
 *
 * @author Danilo
 */
public class Agente {
    private static Stage stage;
    private static UIConversaController conversaController;
    
    
    public void recuperarConta(){
        
    }
    public void criarSessao(){
        
    }
    
    public static void setStage(Stage stage){
        Agente.stage = stage;
    }
    
    public static void setController(UIConversaController conversaController){
        Agente.conversaController = conversaController;
    }
    
    public static void openConversa(ConvReg conversa){
        System.out.println("Abrindo conversas");
        conversaController.showConversa(conversa);
        
    }
    
    public static void sendMessage(String message, int conversaID, int contatoID){
        BDConnetion bd = new BDConnetion();
        bd.storeMessage(new MsgReg(0, conversaID, contatoID, Calendar.getInstance(), message),
                new ConvReg(conversaID, null, null),
                new ContReg(contatoID, null, null));
        
    }
    
    public static boolean logar(String username, String passwd){
        System.out.println("Tentativa de Login");
        if(username.equals("teste") && passwd.equals("1234")){
            System.out.println("SenhaCorreta");
            try {
                Scene newScene = new Scene
                (FXMLLoader.load(Agente.class.getResource("/com/chatuo/UI/Principal/Principal.fxml")));
                stage.close();
                setStage(new Stage(StageStyle.DECORATED));
                stage.setScene(newScene);
                stage.setTitle("ChatUÓ");
                stage.show();
                return true;
            } catch (IOException ex) {
                Logger.getLogger(Agente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
        
    }
    
    public ArrayList<MsgReg> lerMensagens(){
        return null;
    }
    
    public void enviarMensagem(MsgReg msg){
        
    }
    
    
}
