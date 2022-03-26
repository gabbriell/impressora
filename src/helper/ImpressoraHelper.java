package helper;


import dao.ConexaoDAO;
import dao.ImpressoraDAO;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import model.Impressao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.ServiceUI;
import javax.print.SimpleDoc;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.JobName;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
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
        
    public String consultarProcessoNoBancoDeDados(ArrayList<Processo> processos){
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
                  
             
                
            conteudo = conteudo + "                  ETIQUETA DE PROCESSO   \n\r \n\r"
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
            
        try {
            impressoraDAO.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ImpressoraHelper.class.getName()).log(Level.SEVERE, null, ex);
          }
        
        JOptionPane.showMessageDialog(view,"Imprimindo processo Nº: " + conteudo);
        return conteudo;
    }
    
    public void imprimirCapa(String processosConsultados){      
        
        //impressoraDAO.fecharConexao();
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(DocFlavor.INPUT_STREAM.AUTOSENSE,null);
        PrintService impressoraPadrao = PrintServiceLookup.lookupDefaultPrintService();
        DocFlavor docFlavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        HashDocAttributeSet hashDocAttributeSet = new HashDocAttributeSet();
        
        try{
            
            InputStream InputStream = new ByteArrayInputStream(processosConsultados.getBytes());
            Doc doc = new SimpleDoc(InputStream, docFlavor,hashDocAttributeSet);
            PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
            printRequestAttributeSet.add(new JobName("Capa de processo", null));            
            printRequestAttributeSet.add(OrientationRequested.PORTRAIT);
            printRequestAttributeSet.add(MediaSizeName.ISO_A4);
            
            PrintService printServico = ServiceUI.printDialog(null, 300, 200, printService, impressoraPadrao, docFlavor, printRequestAttributeSet);
            if(printServico != null){
                DocPrintJob docPrintJob = printServico.createPrintJob();
                
                //mandar consultarProcessoNoBancoDeDados documento
                docPrintJob.print(doc, printRequestAttributeSet);
            }
        } catch (PrintException ex) {
            JOptionPane.showMessageDialog(view, ex);
        }       
     

    }
    
    @Override
    public void limparTela() {
        view.getjTextPosicao1().setText("");
    }  

   
    
    
    
}