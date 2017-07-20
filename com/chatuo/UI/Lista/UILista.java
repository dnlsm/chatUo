/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatuo.UI.Lista;

import com.chatuo.UI.Sala.UISalaController;
import com.chatuo.db.datatype.ConvReg;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Danilo
 */
public class UILista implements Initializable {
    private ArrayList<ConvReg> conversas;
    @FXML
    private VBox lista;

    public UILista(ArrayList<ConvReg> conversas) {
        this.conversas = conversas;
    }
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (ConvReg conversa : conversas) {
            try {
                FXMLLoader salaLoader = new FXMLLoader(getClass().getResource(
                        "/com/chatuo/UI/Sala/UISala.fxml"));
                
                UISalaController salaController = new UISalaController(conversa);
                salaLoader.setController(salaController);
                AnchorPane salaPane = salaLoader.load();
                lista.getChildren().add(salaPane);
                
            } catch (IOException ex) {
                Logger.getLogger(UILista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
    
}
