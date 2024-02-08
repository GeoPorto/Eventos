package br.edu.ifsp.servicos;

import br.edu.ifsp.dao.DAO;
import br.edu.ifsp.model.Programacao;
import br.edu.ifsp.utility.EventoException;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

public class ProgramacaoServicos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private DAO<Programacao> dao;

    public void salvar(Programacao a) throws EventoException {
        System.out.println("passando pelo salvar");
        dao.salvar(a);
    }

    public void remover(Programacao a) throws EventoException {
        dao.remover(Programacao.class, a.getId());
    }

    public List<Programacao> listarTodos() {
        return dao.buscarTodos("SELECT p FROM Programacao p order by p.nome");
    }
    
}
