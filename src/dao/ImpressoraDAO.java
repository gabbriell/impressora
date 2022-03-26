/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Impressao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Processo;
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
    
    public Processo selectProcesso(String codigo) {
           
            String sql = "SELECT * FROM `capa_de_processo` WHERE numero_processo = ?";            
        //JOptionPane.showMessageDialog(null,"executei o sql" );
        Processo processo = new Processo();   
        try{
            statement = connection.prepareStatement(sql);
            
            
            statement.setString(1,codigo);            
            ResultSet resultSet = statement.executeQuery();      
            
            
            if(resultSet.next()){
                
            processo.setNumeroDeProcesso(resultSet.getString(1));
            processo.setOrigem(resultSet.getString(2));
            processo.setReferencia(resultSet.getString(3));
            processo.setResumoDoAssunto(resultSet.getString(4));
            processo.setDataDoProcesso(resultSet.getString(5));
            processo.setDataDoDocumento(resultSet.getString(6));                                               
          
            
            }
            
           } catch (Exception e){
               JOptionPane.showMessageDialog(null, e);
               
           }
        return processo;
            
        }
    
    public void fecharConexao() throws SQLException{
        connection.close();
    }
}