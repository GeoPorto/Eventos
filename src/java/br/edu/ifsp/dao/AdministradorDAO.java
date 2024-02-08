package br.edu.ifsp.dao;

import br.edu.ifsp.model.Administrador;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class AdministradorDAO extends DAO<Administrador> implements Serializable{
    
    private static final long serialVersionUID = 1L;

    public Administrador findByLoginSenha(String login, String senha) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Administrador> query = (TypedQuery<Administrador>) gerente.createQuery(
                "SELECT a FROM Administrador a WHERE a.login = :login AND a.senha = :senha",
                Administrador.class);
        query.setParameter("login", login);
        query.setParameter("senha", senha);
        try {
            return query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
}
