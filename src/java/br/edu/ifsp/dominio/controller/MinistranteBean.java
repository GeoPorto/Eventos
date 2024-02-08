package br.edu.ifsp.dominio.controller;

import br.edu.ifsp.model.Ministrante;
import br.edu.ifsp.servicos.MinistranteServicos;
import br.edu.ifsp.utility.Mensagens;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import javax.inject.Named;

@Named("ministranteBean")
@SessionScoped
public class MinistranteBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
  
    @Inject
    private Ministrante ministrante;

    @Inject
    MinistranteServicos servicos;

    private List<Ministrante> listaMinistrantes;

    @PostConstruct
    public void carregar() {
        listaMinistrantes = servicos.listarTodos();
    }
    
    public List<Ministrante> findAll() {
        return servicos.listarTodos();
    }
    
    public void adicionar() {

        try {
            servicos.salvar(ministrante);
            ministrante = new Ministrante();
            carregar();
            Mensagens.info("Ministrante adicionado");
        } catch (Exception e) {
            Mensagens.info(e.getMessage());
        }

    }
    
    public void cancelar() {
     
        ministrante = new Ministrante();

        
    }

    public Ministrante getMinistrante() {
        return ministrante;
    }

    public void setMinistrante(Ministrante ministrante) {
        this.ministrante = ministrante;
    }

    public List<Ministrante> getListaMinistrantes() {
        return listaMinistrantes;
    }

    public void setListaMinistrantes(List<Ministrante> listaMinistrantes) {
        this.listaMinistrantes = listaMinistrantes;
    }
    
    
    
}
