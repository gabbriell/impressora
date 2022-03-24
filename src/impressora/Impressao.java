package impressora;

import java.util.ArrayList;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabrielm
 */
public class Impressao {
    
    private String conteudo1;
    private ArrayList<String> posicao = new ArrayList();

    public Impressao(String conteudo1) {
        this.conteudo1 = conteudo1;
    }

    public Impressao(ArrayList<String> posicao) {
        this.posicao = posicao;
    
    }
    
    public String getConteudo1() {
        return conteudo1;
    }
    
    public void setConteudo1(String conteudo1) {
        this.conteudo1 = conteudo1;
    }

    public ArrayList<String> getPosicao() {
        return posicao;
    }

    public void setPosicao(ArrayList<String> posicao) {
        this.posicao = posicao;
    }
    
    
}
