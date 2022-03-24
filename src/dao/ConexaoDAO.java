/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gabrielm
 */
public class ConexaoDAO {
    
    public Connection getConnection() throws SQLException{
        Connection conexao = DriverManager.getConnection("jdbc:Mysql://localhost:3306/impressora","root","");
        return conexao;
    }
    
}
