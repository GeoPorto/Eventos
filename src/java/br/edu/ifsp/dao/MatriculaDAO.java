package br.edu.ifsp.dao;

import br.edu.ifsp.model.Aluno;
import br.edu.ifsp.model.Matricula;
import br.edu.ifsp.model.Programacao;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class MatriculaDAO extends DAO<Matricula> implements Serializable {

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

    public boolean verificarMatriculaExistente(Aluno aluno, Programacao programacao) {
        EntityManager gerente = GerenciadorConexao.getGerente();

        Query query = gerente.createQuery(
                "SELECT COUNT(m) FROM Matricula m WHERE m.alunos.id = :alunoId AND m.programacao.id = :programacaoId",
                Long.class);
        query.setParameter("alunoId", aluno.getId());
        query.setParameter("programacaoId", programacao.getId());

        Long count = (Long) query.getSingleResult();

        return count > 0;
    }
    
    public List<Matricula> encontrarMatriculasPorIdAluno(Long idAluno) {
        
        EntityManager gerente = GerenciadorConexao.getGerente();
  
        Query query  = gerente.createQuery(
                "SELECT m FROM Matricula m WHERE m.alunos.id = :alunoId",
                Matricula.class);
        query.setParameter("alunoId", idAluno);
        try {
            return query.getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

}
