/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatuo.db;

import static com.chatuo.db.BDConnetion.DATETIME_FORMAT;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danilo
 */
public class Teste {
    
    public void test(Statement stm) {
        try{
            System.out.println("Iniciando Insersão de dados");
            stm.executeUpdate(
                "INSERT INTO CONTATO VALUES ('1', 'Rodrigo', ' ' );");
            stm.executeUpdate(
                "INSERT INTO CONTATO VALUES ('2', 'Danilo', ' ' );");
            stm.executeUpdate(
                "INSERT INTO CONTATO VALUES ('3', 'Rods', ' ');");
            stm.executeUpdate(
                "INSERT INTO CONVERSA_INFO VALUES('1' , 'Quengaral', '"+new SimpleDateFormat(DATETIME_FORMAT).format(Calendar.getInstance().getTime())+"' );");
            stm.executeUpdate(
                "INSERT INTO CONVERSA_INFO VALUES('2' , 'Grupo da Familia', '"+new SimpleDateFormat(DATETIME_FORMAT).format(Calendar.getInstance().getTime())+"' );");
            stm.executeUpdate(
                "INSERT INTO CONVERSA VALUES('1' , '1' );");
            stm.executeUpdate(
                "INSERT INTO CONVERSA VALUES('1', '2');");
            stm.executeUpdate(
                "INSERT INTO CONVERSA VALUES('1', '3');");
            stm.executeUpdate(
                "INSERT INTO DADOS VALUES ('1', '1', '1', '2017-06-18 20:40:00.000', 'Olá Danilo, tudo bem?');");
            stm.executeUpdate(
                "INSERT INTO DADOS VALUES ('2', '1', '2', '2017-06-18 20:40:15.010', 'Stol bem e vc?');");
            stm.executeUpdate(
                "INSERT INTO DADOS VALUES ('3', '1', '1', '2017-06-18 20:40:59.001', 'Ki Bom :) ');");
            stm.executeUpdate(
                "INSERT INTO DADOS VALUES ('4', '1', '3', '2017-06-18 20:41:07.110', 'INHAI A GORDA PRETA PORCA ATIVA CHEGOU!!!! ');");
            stm.executeUpdate(
                "INSERT INTO DADOS VALUES ('5', '1', '2', '2017-06-18 20:42:15.599', 'ELA É COMILONA ELA. KKK ');");
            stm.executeUpdate(
            "INSERT INTO CONTATO VALUES ('5', 'Pedro', ' ' );");
            stm.executeUpdate(
            "INSERT INTO CONVERSA VALUES('2' , '3' );");
            stm.executeUpdate(
            "INSERT INTO CONVERSA VALUES('2', '2');");
            stm.executeUpdate(
            "INSERT INTO CONVERSA VALUES('2' , '5' );");
            stm.executeUpdate(
            "INSERT INTO DADOS VALUES ('6', '2', '2', '2017-06-16 13:59:00.001', 'Oi meninas tuto baum');");
            stm.executeUpdate(
            "INSERT INTO DADOS VALUES ('7', '2', '2', '2017-06-18 13:01:05.110', 'Eu estava no 699 apareceu um cara lindo remexendo o pinto, fiquei louca, mas estava tudo bem ate que entao ...');");
            stm.executeUpdate(
            "INSERT INTO DADOS VALUES ('8', '2', '2', '2017-06-18 19:40:59.001', 'Ai ele ficou me olhando e me disse: ELE ESTÁ ME MANJANDO!!! ANDRADE ME LIGOU LOGO EM SEGUIDA PARA CRITICAR MINHA ATITUDE DE MANDAR E SER FLAGRADA. ');");
            stm.executeUpdate(
            "INSERT INTO DADOS VALUES ('9', '2', '3', '2017-06-18 00:52:25.001', 'Nossa vcs nao sabem, fui vender brusinhas e me travou a coluna, fiquei com dor nas costas e meus pés estão pretos, não consigo mecher a face, acho que fiquei doente denovo.');");
            stm.executeUpdate(
            "INSERT INTO DADOS VALUES ('10', '2', '3', '2017-06-18 20:42:15.599', 'NOSSA EU NAO CONSIGO APRENDER NADA, SOCORRO PRECISO ESTUDAR E NAO CONSIGO APRENDER SÓ RESPONDEER O Q EU FACO?');");
            System.out.println("Inserção de dados concluida");
        } catch (SQLException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
