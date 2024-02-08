package br.edu.ifsp.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "aluno")
@NamedQueries({
    @NamedQuery(name = "Alunos.findAll", query = "SELECT a FROM Aluno a"),
    @NamedQuery(name = "Alunos.findByIdalunos", query = "SELECT a FROM Aluno a WHERE a.id = :id"),
    @NamedQuery(name = "Alunos.findByNome", query = "SELECT a FROM Aluno a WHERE a.nome = :nome"),
    @NamedQuery(name = "Alunos.findByCurso", query = "SELECT a FROM Aluno a WHERE a.curso = :curso"),
    @NamedQuery(name = "Alunos.findByCpf", query = "SELECT a FROM Aluno a WHERE a.cpf = :cpf"),
    @NamedQuery(name = "Alunos.findByEmail", query = "SELECT a FROM Aluno a WHERE a.email = :email")
   })
public class Aluno implements Serializable, Base {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name = "idAluno")
    private Long id;
    @Column(name = "nome", length = 60)
    private String nome;
    @Column(name = "curso", length = 50)
    private String curso;
    @Column(name = "cpf", length = 14)
    private String cpf;
    @Column(name = "email", length = 60)
    private String email;
    @Column(name = "login", unique = true, length = 15)
    private String login;
    @Column(name = "senha", unique = true, length = 15)
    private String senha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alunos")
    private List<Matricula> matriculas;

    public Aluno() {
    }

    public Aluno(String nome, String curso, String cpf, String email, String login, String senha, List<Matricula> matriculas) {
        this.nome = nome;
        this.curso = curso;
        this.cpf = cpf;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.matriculas = matriculas;
    }

     @Override
    public Long getId() {

        return this.id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Alunos{" + "id=" + id + ", nome=" + nome + ", curso=" + curso + ", cpf=" + cpf + ", email=" + email + ", login=" + login + ", senha=" + senha + ", matriculas=" + matriculas + '}';
    }

    
    
}
