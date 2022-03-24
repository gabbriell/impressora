package helper;


import impressora.Impressao;
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
    
    public ImpressoraHelper(ViewCapaProcesso view){
     
        this.view = view;
    }

        public Impressao obterModelo() {
       Impressao pagina;
            
        String posicao1 = view.getjTextPosicao1().getText();
        
        pagina = new Impressao(posicao1);
        return pagina;
    }
        
        

    @Override
    public void limparTela() {
        view.getjTextPosicao1().setText("");
    }
    
    
    
}
