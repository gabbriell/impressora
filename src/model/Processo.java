package model;

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
public class Processo {    
    
    private String numeroDeProcesso;
    private String referencia;
    private String resumoDoAssunto;
    private String dataDoProcesso;
    private String dataDoDocumento;
    private String origem;

    public Processo(String numeroDeProcesso, String referencia, String resumoDoAssunto, String dataDoProcesso, String dataDoDocumento, String origem) {
        this.numeroDeProcesso = numeroDeProcesso;
        this.referencia = referencia;
        this.resumoDoAssunto = resumoDoAssunto;
        this.dataDoProcesso = dataDoProcesso;
        this.dataDoDocumento = dataDoDocumento;
        this.origem = origem;
    }

    public Processo() {
    }

    public Processo(String numeroDeProcesso) {
        this.numeroDeProcesso = numeroDeProcesso;
    }
    
    
   

    public String getNumeroDeProcesso() {
        return numeroDeProcesso;
    }

    public void setNumeroDeProcesso(String numeroDeProcesso) {
        this.numeroDeProcesso = numeroDeProcesso;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getResumoDoAssunto() {
        return resumoDoAssunto;
    }

    public void setResumoDoAssunto(String resumoDoAssunto) {
        this.resumoDoAssunto = resumoDoAssunto;
    }

    public String getDataDoProcesso() {
        return dataDoProcesso;
    }

    public void setDataDoProcesso(String dataDoProcesso) {
        this.dataDoProcesso = dataDoProcesso;
    }

    public String getDataDoDocumento() {
        return dataDoDocumento;
    }

    public void setDataDoDocumento(String dataDoDocumento) {
        this.dataDoDocumento = dataDoDocumento;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }
    
   

    
    
    
}
