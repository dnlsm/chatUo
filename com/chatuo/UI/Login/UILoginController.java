/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatuo.UI.Login;

import com.chatuo.Agente;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Danilo
 */
public class UILoginController implements Initializable {

    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;


    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /**
     *
     * @param e
     */
    @FXML
    private void exitButtonAction(javafx.event.ActionEvent event) throws Throwable {
        Platform.exit();
    }

    @FXML
    private void loginClick(ActionEvent event) {
        System.out.println("Username:"+username.getText()+"\nPassword:"+password.getText());
        if (!Agente.logar(username.getText(), password.getText())){
            System.out.println("ERRO DE LOGIN");
        }
    }
    
}
