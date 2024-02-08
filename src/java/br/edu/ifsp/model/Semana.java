package br.edu.ifsp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "semana")
@NamedQueries({
    @NamedQuery(name = "Semana.findAll", query = "SELECT s FROM Semana s"),
    @NamedQuery(name = "Semana.findByIdSemana", query = "SELECT s FROM Semana s WHERE s.id = :idSemana"),
    @NamedQuery(name = "Semana.findBySigla", query = "SELECT s FROM Semana s WHERE s.sigla = :sigla"),
    @NamedQuery(name = "Semana.findByNome", query = "SELECT s FROM Semana s WHERE s.nome = :nome"),
    @NamedQuery(name = "Semana.findByLocal", query = "SELECT s FROM Semana s WHERE s.local = :local"),
    @NamedQuery(name = "Semana.findByInicio", query = "SELECT s FROM Semana s WHERE s.inicio = :inicio"),
    @NamedQuery(name = "Semana.findByTermino", query = "SELECT s FROM Semana s WHERE s.termino = :termino"),
    @NamedQuery(name = "Semana.findByFinalizado", query = "SELECT s FROM Semana s WHERE s.finalizado = :finalizado")})
public class Semana implements Serializable, Base {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idSemana")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sigla", length = 10)
    private String sigla;
    @Column(name = "nome", length = 100)
    private String nome;
    @Column(name = "local", length = 100)
    private String local;
    @Column(name = "inicio")
    @Temporal(TemporalType.DATE)
    private Date inicio;
    @Column(name = "termino")
    @Temporal(TemporalType.DATE)
    private Date termino;
    @Column(name = "finalizado", length = 1)
    private String finalizado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSemana")
    private List<Programacao> programacao;

    public Semana() {
    }

    public Semana(String sigla, String nome, String local, Date inicio, Date termino, String finalizado, List<Programacao> programacao) {
        this.sigla = sigla;
        this.nome = nome;
        this.local = local;
        this.inicio = inicio;
        this.termino = termino;
        this.finalizado = finalizado;
        this.programacao = programacao;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Programacao> getProgramacao() {
        return programacao;
    }

    public void setProgramacao(List<Programacao> programacao) {
        this.programacao = programacao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
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

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getTermino() {
        return termino;
    }

    public void setTermino(Date termino) {
        this.termino = termino;
    }

    public String getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(String finalizado) {
        this.finalizado = finalizado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Semana other = (Semana) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return sigla + "-" + nome ;
    }

}
