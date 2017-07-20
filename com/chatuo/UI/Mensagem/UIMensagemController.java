/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatuo.UI.Mensagem;

import com.chatuo.db.datatype.MsgReg;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Danilo
 */
public class UIMensagemController implements Initializable {
    MsgReg msg;
    
    public  UIMensagemController(MsgReg msg){
        this.msg = msg;
    }
    @FXML
    private Label contactName;
    @FXML
    private Label msgText;
    @FXML
    private Label msgTime;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                msgTime.setWrapText(true);
                
        //msgText.setText(msg.getDADO());
        msgText.setText(msg.getDADO());
        
        msgTime.setText(new SimpleDateFormat("dd/MM (HH:MM)").format(msg.getDATE_TIME().getTime()));
        contactName.setText(msg.getContato().getLOGIN_CONTATO());
    }
    
}
