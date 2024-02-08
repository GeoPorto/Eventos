package br.edu.ifsp.servicos;


import br.edu.ifsp.dao.AlunoDAO;
import br.edu.ifsp.model.Aluno;
import br.edu.ifsp.utility.EventoException;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

public class AlunoServicos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private AlunoDAO dao;

    public void salvar(Aluno a) throws EventoException {
        System.out.println("passando pelo salvar");
        dao.salvar(a);
    }

    public void remover(Aluno a) throws EventoException {
        dao.remover(Aluno.class, a.getId());
    }

    public List<Aluno> listarTodos() {
        return dao.buscarTodos("Aluno.findAll");
    }
    
    public Aluno logar(String login, String senha) {
        return dao.findByLoginSenha(login, senha);
    }
}
