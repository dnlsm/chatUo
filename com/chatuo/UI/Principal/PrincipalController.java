/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatuo.UI.Principal;

import com.chatuo.Agente;
import com.chatuo.UI.Conversa.UIConversaController;
import com.chatuo.UI.Lista.UILista;
import com.chatuo.UI.Mensagem.UIMensagemController;
import com.chatuo.db.BDConnetion;
import com.chatuo.db.Dados;
import com.chatuo.db.datatype.ContReg;
import com.chatuo.db.datatype.ConvReg;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Danilo
 */
public class PrincipalController implements Initializable {

    @FXML
    private Pane convsPane;
    @FXML
    private AnchorPane msgPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            
            
            BDConnetion bd = new BDConnetion();
            bd.initialize();
            //bd.teste();
            ArrayList<ConvReg> conversas = null;
            try {
                conversas = bd.getConversationInfo();
                bd.disconnect();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            FXMLLoader listaLoader = new FXMLLoader(getClass().getResource(
                        "/com/chatuo/UI/Lista/UILista.fxml"));
            UILista listaController = new UILista(conversas);
            listaLoader.setController(listaController);
            AnchorPane listaPane = listaLoader.load();
            convsPane.getChildren().add(listaPane);
            AnchorPane.setLeftAnchor(listaPane, 0.0);
            AnchorPane.setRightAnchor(listaPane, 0.0);
            
            FXMLLoader conversaLoader =
                    new FXMLLoader(getClass().getResource("/com/chatuo/UI/Conversa/UIConversa.fxml"));
            UIConversaController conversaController = new UIConversaController(conversas.get(0));
            conversaLoader.setController(conversaController);

            Pane msgsPane = conversaLoader.load();
            
            msgPane.getChildren().add(msgsPane);
            AnchorPane.setBottomAnchor(msgsPane, 0.0);
            AnchorPane.setLeftAnchor(msgsPane, 0.0);
            AnchorPane.setRightAnchor(msgsPane,0.0);
            AnchorPane.setTopAnchor(msgsPane, 0.0);
            
            Agente.setController(conversaController);
        } catch (IOException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
    
}
