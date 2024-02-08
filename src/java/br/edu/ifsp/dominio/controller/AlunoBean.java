package br.edu.ifsp.dominio.controller;

import br.edu.ifsp.model.Aluno;
import br.edu.ifsp.servicos.AlunoServicos;
import br.edu.ifsp.utility.Mensagens;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.NonUniqueResultException;

@Named("alunoBean")
@SessionScoped
public class AlunoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Aluno aluno;

    @Inject
    private AlunoServicos servicos;

    private List<Aluno> listaAlunos;


    public void carregar() {
        listaAlunos = servicos.listarTodos();

    }

    public void adicionar() {

        try {
            servicos.salvar(aluno);
            aluno = new Aluno();
            //carregar();
            Mensagens.info("Aluno cadastrado");
        } catch (Exception e) {
            
                Mensagens.erro("Login e senha já existem");
            
        }

    }

    public void cancelar() {
     
        aluno = new Aluno();
        
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    

}
