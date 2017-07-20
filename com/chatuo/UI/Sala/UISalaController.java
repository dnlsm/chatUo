/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatuo.UI.Sala;

import com.chatuo.Agente;
import com.chatuo.db.datatype.ConvReg;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Danilo
 */
public class UISalaController implements Initializable {

    @FXML
    private ImageView img;
    @FXML
    private Label nomeSala;
    
    private ConvReg conversa;

    public UISalaController(ConvReg conversa) {
        this.conversa = conversa;
    }
    
    
    
    
    /**
     * Initializes the controller class.
     */
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nomeSala.setText(conversa.getNOME());
    }    

    @FXML
    private void listaClick(MouseEvent event) {
        Agente.openConversa(conversa);
    }
    
}
