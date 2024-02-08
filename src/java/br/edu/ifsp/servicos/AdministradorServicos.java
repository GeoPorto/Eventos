package br.edu.ifsp.servicos;

import br.edu.ifsp.dao.AdministradorDAO;
import br.edu.ifsp.model.Administrador;
import br.edu.ifsp.utility.EventoException;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

public class AdministradorServicos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private AdministradorDAO dao;

    public void salvar(Administrador a) throws EventoException {
        System.out.println("passando pelo salvar");
        dao.salvar(a);
    }

    public void remover(Administrador a) throws EventoException {
        dao.remover(Administrador.class, a.getId());
    }

    public List<Administrador> listarTodos() {
        return dao.buscarTodos("Administrador.findAll");
    }
    
    public Administrador logar(String login, String senha) {
        System.out.println(dao.findByLoginSenha(login, senha));
        return dao.findByLoginSenha(login, senha);
    }
}
