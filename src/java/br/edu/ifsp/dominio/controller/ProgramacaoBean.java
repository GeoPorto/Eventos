package br.edu.ifsp.dominio.controller;

import br.edu.ifsp.model.Ministrante;
import br.edu.ifsp.model.Programacao;
import br.edu.ifsp.model.Semana;
import br.edu.ifsp.servicos.ProgramacaoServicos;
import br.edu.ifsp.utility.Mensagens;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import javax.inject.Named;

@Named("programacaoBean")
@SessionScoped
public class ProgramacaoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Programacao programacao;

    @Inject
    private ProgramacaoServicos servicos;

    private List<Programacao> listaProgramacao;
    
    private Semana semana;
    
    private Ministrante ministrante;

    @PostConstruct
    public void carregar() {
        listaProgramacao = servicos.listarTodos();

    }

    public void adicionar() {

        try {
            programacao.setQtdematriculados(0);
            programacao.setStatus("C");
            programacao.setIdSemana(semana);
            programacao.setIdministrante(ministrante);
            servicos.salvar(programacao);
            programacao = new Programacao();
            carregar();
            Mensagens.info("Programação adicionada");
        } catch (Exception e) {
            Mensagens.info(e.getMessage());
        }

    }
    
    public void cancelar() {
     
        programacao = new Programacao();
        
    }

    public Programacao getProgramacao() {
        return programacao;
    }

    public void setProgramacao(Programacao programacao) {
        this.programacao = programacao;
    }

    public List<Programacao> getListaProgramacao() {
        return listaProgramacao;
    }

    public void setListaProgramacao(List<Programacao> listaProgramacao) {
        this.listaProgramacao = listaProgramacao;
    }

    public Semana getSemana() {
        return semana;
    }

    public void setSemana(Semana semana) {
        this.semana = semana;
    }

    public Ministrante getMinistrante() {
        return ministrante;
    }

    public void setMinistrante(Ministrante ministrante) {
        this.ministrante = ministrante;
    }

}
