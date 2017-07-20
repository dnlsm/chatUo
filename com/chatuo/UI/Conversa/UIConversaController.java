/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatuo.UI.Conversa;

import com.chatuo.Agente;
import com.chatuo.UI.Mensagem.UIMensagemController;
import com.chatuo.db.BDConnetion;
import static com.chatuo.db.BDConnetion.DATETIME_FORMAT;
import com.chatuo.db.Dados;
import com.chatuo.db.datatype.ConvReg;
import com.chatuo.db.datatype.MsgReg;
import com.jfoenix.controls.JFXTextArea;
import java.awt.Event;
import static java.awt.Event.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Danilo
 */
public class UIConversaController implements Initializable {
    private ConvReg conversa;
    @FXML
    private JFXTextArea msgText;

    public UIConversaController(ConvReg conversa){
        this.conversa = conversa;
    }
    @FXML
    private VBox msgArea;
    
    @FXML
    private ScrollPane scroll;
    
    @FXML
    private Label nomeConv;

    /**
     * Initializes the controller class.
     * @param url
     */
    
    public void showConversa(ConvReg convers){
                System.out.println("CONV ID = "+convers.getID_CONVERSA());

        this.conversa = convers;
               try {
                    BDConnetion bd = new BDConnetion();
                    ArrayList<MsgReg> messages;
                    messages = bd.searchMessage(conversa.getID_CONVERSA(), null, null);
                    msgArea.getChildren().clear();
                    System.out.println("teste");
                    for(MsgReg message: messages){
                        System.out.println("msg test");
                        message.setContato(
                        bd.findContato(conversa.getPARTICIPANTES(),message.getID_CONTATO()));
                        FXMLLoader msgLoader = new FXMLLoader(getClass().getResource(
                                "/com/chatuo/UI/Mensagem/UIMensagem.fxml"));
                        UIMensagemController msgController = new UIMensagemController(message);
                        msgLoader.setController(msgController);
                        AnchorPane msgPane = msgLoader.load();
                        msgArea.getChildren().add(msgPane);
                    }
            nomeConv.setText(conversa.getNOME());
            bd.disconnect();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UIConversaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UIConversaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        scroll.vvalueProperty().setValue(10);

    }
    
    
    private void sendMessage(){
        Agente.sendMessage(msgText.getText(),
                conversa.getID_CONVERSA(),
                1);
        msgText.clear();
        Agente.openConversa(conversa);

    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.showConversa(this.conversa);
        msgText.setOnKeyTyped(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent keyEvent){
                System.out.println(msgText.getText());
                if(keyEvent.getCode()== KeyCode.ENTER){
                    System.out.println("ASDF");
                }
            }
        });
    }    

  
    @FXML
    private void keyTyped(KeyEvent event) {
        
    }

    @FXML
    private void send(ActionEvent event) {
        sendMessage();
    }
    
}
