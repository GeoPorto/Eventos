package br.edu.ifsp.dominio.controller;

import br.edu.ifsp.model.Administrador;
import br.edu.ifsp.model.Aluno;
import br.edu.ifsp.model.Matricula;
import br.edu.ifsp.model.Programacao;
import br.edu.ifsp.servicos.AdministradorServicos;
import br.edu.ifsp.servicos.AlunoServicos;
import br.edu.ifsp.servicos.MatriculaServicos;
import br.edu.ifsp.utility.Mensagens;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import javax.inject.Named;

@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    AdministradorServicos admServicos;

    @Inject
    AlunoServicos alunoServicos;

    @Inject
    MatriculaServicos matriculaServicos;

    Aluno alunoLogado;

    Administrador administradorLogado;

    private boolean islogado = false;

    private boolean adm = false;

    private String login;

    private String senha;

    public void carregar() {

    }

    public void logar() {

        administradorLogado = admServicos.logar(login, senha);

        if (administradorLogado == null) {
            alunoLogado = alunoServicos.logar(login, senha);
            if (alunoLogado == null) {
                Mensagens.erro("Login e senha incorretos.");
                // return null;
            } else {
                islogado = true;
                adm = false; //é um aluno
                Mensagens.info("Aluno logado.");
                // return "paginaInicial.xhtml";
            }
        } else {
            islogado = true;
            adm = true; //é um adm
            Mensagens.info("Administrador logado.");
            //return "paginaInicial.xhtml";
        }
    }

    public void deslogar() {

        islogado = false;
        adm = false;
        administradorLogado = null;
        alunoLogado = null;

    }

    public void inscrever(Programacao programacao) {
         System.out.println("alunoLogado: " + alunoLogado);
         System.out.println("programacao: " + programacao);
        Matricula matricula = new Matricula();
        if (alunoLogado != null) {
            if (matriculaServicos.verificarMatriculaExistente(alunoLogado, programacao)) {
            Mensagens.aviso("Você já está matriculado nesta programação.");
            } else {
        if (programacao.getQtdevagas() < 1) {
            Mensagens.aviso("Matriculas esgotadas");
        } else {
            matricula.setPresentemanha("N");
            matricula.setPresentetarde("N");
            programacao.setQtdematriculados(programacao.getQtdematriculados() + 1);
            programacao.setQtdevagas(programacao.getQtdevagas() - 1);
            matricula.setAlunos(alunoLogado);
            matricula.setProgramacao(programacao);
            try {
                matriculaServicos.salvar(matricula);
                carregar();
                Mensagens.info("Matricula Realizada");
            } catch (Exception e) {
                Mensagens.info(e.getMessage());
            }
        }
        }
        } else {
        Mensagens.aviso("Aluno não está logado. Faça o login antes de tentar matricular-se.");
    }
    }

    public String logarOuDeslogar() {

        if (islogado) {
            deslogar();
            return "paginaInicial.xhtml";
        } else {
            return "login.xhtml";
        }

    }
    
    public List<Matricula> buscarMatriculas() {
        List<Matricula> matriculasaluno = matriculaServicos.listarMatriculasPorIdAluno(alunoLogado.getId());
        if (matriculasaluno == null) {
            matriculasaluno = new ArrayList<>();
        }
        return matriculasaluno;
    }

    public boolean isIslogado() {
        return islogado;
    }

    public void setIslogado(boolean islogado) {
        this.islogado = islogado;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isAdm() {
        return adm;
    }

    public void setAdm(boolean adm) {
        this.adm = adm;
    }

}
