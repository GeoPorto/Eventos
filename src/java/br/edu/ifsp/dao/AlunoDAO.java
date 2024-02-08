package br.edu.ifsp.dao;

import br.edu.ifsp.model.Aluno;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;


public class AlunoDAO extends DAO<Aluno> implements Serializable {

    private static final long serialVersionUID = 1L;

    public Aluno findByLoginSenha(String login, String senha) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Aluno> query = gerente.createQuery(
                "SELECT a FROM Aluno a WHERE a.login = :login AND a.senha = :senha",
                Aluno.class);
        query.setParameter("login", login);
        query.setParameter("senha", senha);
        try {
            return query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
}
