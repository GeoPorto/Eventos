package br.edu.ifsp.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "matricula")
@NamedQueries({
    @NamedQuery(name = "Matriculas.findAll", query = "SELECT m FROM Matricula m"),
    @NamedQuery(name = "Matriculas.findById", query = "SELECT m FROM Matricula m WHERE m.id = :id"),
    @NamedQuery(name = "Matriculas.findByPresentemanha", query = "SELECT m FROM Matricula m WHERE m.presentemanha = :presentemanha"),
    @NamedQuery(name = "Matriculas.findByPresentetarde", query = "SELECT m FROM Matricula m WHERE m.presentetarde = :presentetarde")})
public class Matricula implements Serializable, Base {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idMatricula")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "presentemanha", length = 1)
    private String presentemanha;
    @Column(name = "presentetarde", length = 1)
    private String presentetarde;
    @JoinColumn(name = "idAluno", referencedColumnName = "idAluno")
    @ManyToOne(optional = false)
    private Aluno alunos;
    @JoinColumn(name = "idProgramacao", referencedColumnName = "idProgramacao")
    @ManyToOne(optional = false)
    private Programacao programacao;

    public Matricula() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPresentemanha() {
        return presentemanha;
    }

    public void setPresentemanha(String presentemanha) {
        this.presentemanha = presentemanha;
    }

    public String getPresentetarde() {
        return presentetarde;
    }

    public void setPresentetarde(String presentetarde) {
        this.presentetarde = presentetarde;
    }

    public Aluno getAlunos() {
        return alunos;
    }

    public void setAlunos(Aluno alunos) {
        this.alunos = alunos;
    }

    public Programacao getProgramacao() {
        return programacao;
    }

    public void setProgramacao(Programacao programacao) {
        this.programacao = programacao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Matricula other = (Matricula) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Matricula{" + "id=" + id + ", presentemanha=" + presentemanha + ", presentetarde=" + presentetarde + ", alunos=" + alunos + ", programacao=" + programacao + '}';
    }

}
