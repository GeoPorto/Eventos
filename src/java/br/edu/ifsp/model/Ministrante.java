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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ministrante")
@NamedQueries({
    @NamedQuery(name = "Ministrante.findAll", query = "SELECT m FROM Ministrante m"),
    @NamedQuery(name = "Ministrante.findByIdministrante", query = "SELECT m FROM Ministrante m WHERE m.id = :idministrante"),
    @NamedQuery(name = "Ministrante.findByNome", query = "SELECT m FROM Ministrante m WHERE m.nome = :nome"),
    @NamedQuery(name = "Ministrante.findByCargo", query = "SELECT m FROM Ministrante m WHERE m.cargo = :cargo"),
    @NamedQuery(name = "Ministrante.findByEntidade", query = "SELECT m FROM Ministrante m WHERE m.entidade = :entidade"),
    @NamedQuery(name = "Ministrante.findByEmail", query = "SELECT m FROM Ministrante m WHERE m.email = :email"),
    @NamedQuery(name = "Ministrante.findByCpf", query = "SELECT m FROM Ministrante m WHERE m.cpf = :cpf")})
public class Ministrante implements Serializable, Base {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "idMinistrante")
    private Long id;
    @Column(name = "nome", length = 60)
    private String nome;
    @Column(name = "cargo", length = 100)
    private String cargo;
    @Column(name = "entidade", length = 100)
    private String entidade;
    @Column(name = "email", length = 60)
    private String email;
    @Column(name = "cpf", length = 14)
    private String cpf;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idministrante")
    private List<Programacao> programacaoList;

    public Ministrante() {
    }

    @Override
    public Long getId() {
        return id;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEntidade() {
        return entidade;
    }

    public void setEntidade(String entidade) {
        this.entidade = entidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Programacao> getProgramacaoList() {
        return programacaoList;
    }

    public void setProgramacaoList(List<Programacao> programacaoList) {
        this.programacaoList = programacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Ministrante other = (Ministrante) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return nome;
    }

}
