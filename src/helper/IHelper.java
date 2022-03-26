/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package helper;

import java.util.ArrayList;
import model.Processo;

/**
 *
 * @author gabrielm
 */
public interface IHelper {
    
    public abstract ArrayList<Processo> obterCodigosDeProcessosDaView();
    
    public abstract String consultarProcessoNoBancoDeDados(ArrayList<Processo> processos);
    
    public abstract void limparTela();
    
    public abstract void imprimirCapa(String processosConsultados);
    
    
    
}
