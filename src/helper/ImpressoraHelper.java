package helper;


import dao.ConexaoDAO;
import dao.ImpressoraDAO;
import model.Impressao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Processo;
import view.ViewCapaProcesso;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabrielm
 */
public class ImpressoraHelper implements IHelper {
    
    private final ViewCapaProcesso view;
    private ImpressoraDAO impressoraDAO;
    private ConexaoDAO conexao;
    private Connection connection;
    
    public ImpressoraHelper(ViewCapaProcesso view){
     
        this.view = view;
    }

    public ArrayList<Processo> obterCodigosDeProcessosDaView() {
 
        ArrayList<Processo> processos = new ArrayList();  
        
        processos.add(new Processo(view.getjTextPosicao1().getText()));
        processos.add(new Processo(view.getjTextPosicao2().getText()));
        processos.add(new Processo(view.getjTextPosicao3().getText()));
        processos.add(new Processo(view.getjTextPosicao4().getText()));
        
        return processos;        
    }
        
    public String imprimir(ArrayList<Processo> processos){
             String conteudo = "";
                       
           // JOptionPane.showMessageDialog(view,"passei aqui " );
        try {
            connection = new ConexaoDAO().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ImpressoraHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        impressoraDAO = new ImpressoraDAO(connection);
       // JOptionPane.showMessageDialog(view,"conectei com o banco " + processos.getPosicao());          
        
      
        
            for(int i =0; i < processos.size(); i++){
               if(processos.get(i).getNumeroDeProcesso().isBlank()){
                   conteudo = conteudo + "\n\r \n\r \n\r \n\r";
                   
               }else{
               Processo processo = impressoraDAO.selectProcesso(processos.get(i).getNumeroDeProcesso());                            
                  
             
                
            conteudo = conteudo + "                ETIQUETA DE PROCESSO   \n\r \n\r"
            + "NUMERO DO PROCESSO:                            ORIGEM: \n\r"
            +" "+processo.getNumeroDeProcesso()+"                        "+processo.getOrigem()+"\n\r"
            +"\n\r  "
            +"    REFERÊNCIA:                              RESUMO DO ASSUNTO:  \n\r"
            +" "+processo.getReferencia()+"                        "+processo.getResumoDoAssunto()+"\n\r"
            +"\n\r "
            +  "DATA DO PROCESSO:                         DATA DO DOCUMENTO: \n\r"
            +" "+processo.getDataDoProcesso()+"                                "+processo.getDataDoDocumento()+"\n\r"; 
                
               }             
            
        }         
        
        JOptionPane.showMessageDialog(view,"Imprimindo processo Nº: " + conteudo);
        return conteudo;
        }      
    
    @Override
    public void limparTela() {
        view.getjTextPosicao1().setText("");
    }  
    
}