/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.umc.loja.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 11152100531
 */
public class conectaDB {
    public static Connection getConexao() throws ClassNotFoundException, SQLException{
        Connection con = null;
        try{
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/prod", "postgres", "postgres");
        }catch(ClassNotFoundException erro1){
            throw new RuntimeException(erro1);
        }catch(SQLException erro2){
            throw new RuntimeException(erro2);
        }
        return con;
    }
}
