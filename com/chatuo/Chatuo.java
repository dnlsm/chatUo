/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatuo;

import com.chatuo.db.Dados;
import java.awt.Image;
import java.net.URL;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;

/**
 *
 * @author a1620576
 */
public class Chatuo extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Agente.setStage(stage);
        Parent root = FXMLLoader.load(getClass().getResource("/com/chatuo/UI/Login/UILogin.fxml"));
        
        stage.initStyle(StageStyle.UNDECORATED);
  
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }
    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        launch(args);
    }
    
}
