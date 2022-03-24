package helper;


import dao.ConexaoDAO;
import dao.ImpressoraDAO;
import impressora.Impressao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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

        public Impressao obterModelo() {
        Impressao pagina;
        ArrayList<String> posicao = new ArrayList();  
        
        posicao.add(view.getjTextPosicao1().getText());
        pagina = new Impressao(posicao);
        return pagina;        
        }
        
        public String imprimir(Impressao posicao){
             ArrayList<String> processo = new ArrayList();
                       
           // JOptionPane.showMessageDialog(view,"passei aqui " );
        try {
            connection = new ConexaoDAO().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ImpressoraHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        impressoraDAO = new ImpressoraDAO(connection);
       // JOptionPane.showMessageDialog(view,"conectei com o banco " + posicao.getPosicao());
        try {
            processo = impressoraDAO.selectPosicao1(posicao.getPosicao());
        } catch (SQLException ex) {
            Logger.getLogger(ImpressoraHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String conteudo = "                ETIQUETA DE PROCESSO   \n\r \n\r"
                + "NUMERO DO PROCESSO:                            ORIGEM: \n\r"
                +" "+processo.get(0)+"                        "+processo.get(1)+"\n\r"
                +"\n\r  "
                +"    REFERÊNCIA:                              RESUMO DO ASSUNTO:  \n\r"
                +" "+processo.get(2)+"                        "+processo.get(3)+"\n\r"
                +"\n\r "
                +  "DATA DO PROCESSO:                         DATA DO DOCUMENTO: \n\r"
                +" "+processo.get(4)+"                              "+processo.get(5)+"\n\r"; 
        
        JOptionPane.showMessageDialog(view,"Imprimindo processo Nº: " + conteudo);
        return conteudo;
        }
        

    @Override
    public void limparTela() {
        view.getjTextPosicao1().setText("");
    }

    @Override
    public String imprimir() {
        return null;
    }

    
    
}
