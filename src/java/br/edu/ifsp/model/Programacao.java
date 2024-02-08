package br.edu.ifsp.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "programacao")
@NamedQueries({
    @NamedQuery(name = "Programacao.findAll", query = "SELECT p FROM Programacao p"),
    @NamedQuery(name = "Programacao.findByIdprogramacao", query = "SELECT p FROM Programacao p WHERE p.id = :id"),
    @NamedQuery(name = "Programacao.findByNome", query = "SELECT p FROM Programacao p WHERE p.nome = :nome"),
    @NamedQuery(name = "Programacao.findByLocal", query = "SELECT p FROM Programacao p WHERE p.local = :local"),
    @NamedQuery(name = "Programacao.findByCh", query = "SELECT p FROM Programacao p WHERE p.ch = :ch"),
    @NamedQuery(name = "Programacao.findByQtdevagas", query = "SELECT p FROM Programacao p WHERE p.qtdevagas = :qtdevagas"),
    @NamedQuery(name = "Programacao.findByQtdematriculados", query = "SELECT p FROM Programacao p WHERE p.qtdematriculados = :qtdematriculados"),
    @NamedQuery(name = "Programacao.findByStatus", query = "SELECT p FROM Programacao p WHERE p.status = :status")})
public class Programacao implements Serializable, Base {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idProgramacao")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", length = 100)
    private String nome;
    @Column(name = "local", length = 45)
    private String local;
    @Column(name = "ch")
    private Integer ch;
    @Column(name = "qtdevagas")
    private Integer qtdevagas;
    @Column(name = "qtdematriculados")
    private Integer qtdematriculados;
    @Column(name = "status", length = 1)
    private String status;
    
    @JoinColumn(name = "idministrante", referencedColumnName = "idMinistrante")
    @ManyToOne(optional = false)
    private Ministrante idministrante;
    
    @JoinColumn(name = "idSemana", referencedColumnName = "idSemana")
    @ManyToOne(optional = false)
    private Semana idSemana;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programacao")
    private List<Matricula> matriculasList;

    public Programacao() {
    }

     @Override
    public Long getId() {

        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Integer getCh() {
        return ch;
    }

    public void setCh(Integer ch) {
        this.ch = ch;
    }

    public Integer getQtdevagas() {
        return qtdevagas;
    }

    public void setQtdevagas(Integer qtdevagas) {
        this.qtdevagas = qtdevagas;
    }

    public Integer getQtdematriculados() {
        return qtdematriculados;
    }

    public void setQtdematriculados(Integer qtdematriculados) {
        this.qtdematriculados = qtdematriculados;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Ministrante getIdministrante() {
        return idministrante;
    }

    public void setIdministrante(Ministrante idministrante) {
        this.idministrante = idministrante;
    }

    public Semana getIdSemana() {
        return idSemana;
    }

    public void setIdSemana(Semana idSemana) {
        this.idSemana = idSemana;
    }

    public List<Matricula> getMatriculasList() {
        return matriculasList;
    }

    public void setMatriculasList(List<Matricula> matriculasList) {
        this.matriculasList = matriculasList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final Programacao other = (Programacao) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Programacao{" + "id=" + id + ", nome=" + nome + ", local=" + local + ", ch=" + ch + ", qtdevagas=" + qtdevagas + ", qtdematriculados=" + qtdematriculados + ", status=" + status + ", idministrante=" + idministrante + ", idSemana=" + idSemana + ", matriculasList=" + matriculasList + '}';
    }
    
}
