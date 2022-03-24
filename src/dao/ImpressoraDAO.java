/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import impressora.Impressao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ImpressoraModel;


/**
 *
 * @author gabrielm
 */
public class ImpressoraDAO {
    
    private final Connection connection;
    private PreparedStatement statement;

    public ImpressoraDAO(Connection connection) {
        this.connection = connection;
    }
    
    public ArrayList<String> select(String posicao1) throws SQLException{
            ArrayList<String> processo = new ArrayList();  
            String sql = "SELECT * FROM `capa_de_processo` WHERE numero_processo = ?";            
        JOptionPane.showMessageDialog(null,"executei o sql" );
           try{
            statement = connection.prepareStatement(sql);
            statement.setString(1,posicao1);                        
            
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
            processo.add(resultSet.getString(1));
            processo.add(resultSet.getString(2));
            processo.add(resultSet.getString(3));
            processo.add(resultSet.getString(4));
            processo.add(resultSet.getString(5));
            processo.add(resultSet.getString(6));
            } else{                
            }
           } catch (Exception e){
               JOptionPane.showMessageDialog(null, e);
           }
        return processo;
            
        }
        
}