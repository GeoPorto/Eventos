package br.edu.ifsp.servicos;

import br.edu.ifsp.dao.SemanaDAO;
import br.edu.ifsp.model.Semana;
import br.edu.ifsp.utility.EventoException;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

public class SemanaServicos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private SemanaDAO dao;

    public void salvar(Semana s) throws EventoException {
        System.out.println("passando pelo salvar");
        dao.salvar(s);
    }

    public void remover(Semana s) throws EventoException {
        dao.remover(Semana.class, s.getId());
    }

    public List<Semana> listarTodos() {
        return dao.buscarTodos("SELECT s FROM Semana s order by s.sigla");
    }
    
}
