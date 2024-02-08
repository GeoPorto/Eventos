package br.edu.ifsp.servicos;

import br.edu.ifsp.dao.MinistranteDAO;
import br.edu.ifsp.model.Ministrante;
import br.edu.ifsp.utility.EventoException;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

public class MinistranteServicos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private MinistranteDAO dao;

    public void salvar(Ministrante m) throws EventoException {
        System.out.println("passando pelo salvar");
        dao.salvar(m);
    }

    public void remover(Ministrante m) throws EventoException {
        dao.remover(Ministrante.class, m.getId());
    }

    public List<Ministrante> listarTodos() {
        return dao.buscarTodos("SELECT m FROM Ministrante m order by m.nome");
    }
    
}
