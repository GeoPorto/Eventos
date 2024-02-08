package br.edu.ifsp.servicos;

import br.edu.ifsp.dao.DAO;
import br.edu.ifsp.dao.MatriculaDAO;
import br.edu.ifsp.model.Aluno;
import br.edu.ifsp.model.Matricula;
import br.edu.ifsp.model.Programacao;
import br.edu.ifsp.utility.EventoException;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

public class MatriculaServicos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private MatriculaDAO dao;

    public void salvar(Matricula m) throws EventoException {
        System.out.println("passando pelo salvar");
        dao.salvar(m);
    }

    public void remover(Matricula m) throws EventoException {
        dao.remover(Matricula.class, m.getId());
    }

    public List<Matricula> listarTodos() {
        return dao.buscarTodos("SELECT m FROM Matricula m order by m.presentetarde");
    }
    
    public boolean verificarMatriculaExistente(Aluno aluno, Programacao programacao) {
        return dao.verificarMatriculaExistente(aluno, programacao);
    }
    
    public List<Matricula> listarMatriculasPorIdAluno(Long idAluno) {
        
        return dao.encontrarMatriculasPorIdAluno(idAluno);
    }
    
}
