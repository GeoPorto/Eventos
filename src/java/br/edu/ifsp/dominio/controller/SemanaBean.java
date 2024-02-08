package br.edu.ifsp.dominio.controller;

import br.edu.ifsp.model.Semana;
import br.edu.ifsp.servicos.SemanaServicos;
import br.edu.ifsp.utility.Mensagens;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import javax.inject.Named;

@Named("semanaBean")
@SessionScoped
public class SemanaBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
  
    @Inject
    private Semana semana;

    @Inject
    SemanaServicos servicos;

    private List<Semana> listaSemanas;

    @PostConstruct
    public void carregar() {
        listaSemanas = servicos.listarTodos();
    }
    
    public List<Semana> findAll() {
        return servicos.listarTodos();
    }
    
    public void adicionar() {

        try {
            semana.setFinalizado("N");
            servicos.salvar(semana);
            semana = new Semana();
            carregar();
            Mensagens.info("Semana adicionada");
        } catch (Exception e) {
            Mensagens.info(e.getMessage());
        }

    }
    
    public void cancelar() {
     
        semana = new Semana();
        
    }

    public Semana getSemana() {
        return semana;
    }

    public void setSemana(Semana semana) {
        this.semana = semana;
    }

    public List<Semana> getListaSemanas() {
        return listaSemanas;
    }

    public void setListaSemanas(List<Semana> listaSemanas) {
        this.listaSemanas = listaSemanas;
    }
    
}
