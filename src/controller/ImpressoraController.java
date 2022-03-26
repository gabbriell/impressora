package controller;

import dao.ConexaoDAO;
import dao.ImpressoraDAO;
import helper.ImpressoraHelper;
import model.Impressao;
import java.awt.Desktop;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
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
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.JobName;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import model.Processo;
import view.ViewCapaProcesso;



/**
 *
 * @author gabrielm
 */
public class ImpressoraController {
    
    private final ViewCapaProcesso view;
    private ImpressoraHelper helper;
    private DocAttributeSet hasDoc;
    private ImpressoraDAO impressoraDAO;
    private ConexaoDAO conexao;
    private Connection connection;

    public ImpressoraController(ViewCapaProcesso view) {
        this.view = view;
        this.helper = new ImpressoraHelper(view);
        
        
    }         
        /*   
        numero de exemplo para consulta: 520/000.928/22
          */   
       
    public void imprimirCapa(){ 
        
        ArrayList<Processo> processos = helper.obterCodigosDeProcessosDaView();
    
     String processosConsultadosDoBancoDeDados = helper.consultarProcessoNoBancoDeDados(processos); 
        
        helper.imprimirCapa(processosConsultadosDoBancoDeDados);
        
        
    
    }
 
  
    
}
