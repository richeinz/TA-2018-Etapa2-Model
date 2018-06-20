
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Ricardo/Joel
 */
@Entity
@Table(name = "usador")
public class Usador implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_usador", sequenceName = "seq_usador_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_usador", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O name não pode ser nulo")
    @NotBlank(message = "O name não pode ser branco")
    @Length(max = 40, message = "Oname não pode ter mais que {max} caracteres")
    @Column(name = "name", length = 40, nullable = false)
    private String name;
    
    @NotNull(message = "O usador não pode ser nulo")
    @NotBlank(message = "O usador não pode ser branco")
    @Length(max = 40, message = "O usador não pode ter mais que {max} caracteres")
    @Column(name = "usador", length = 40, nullable = false, unique = true)
    private String usador;
    
    @Length(max = 10, message = "A password não pode ter mais que {max} caracteres")
    @NotNull(message = "A password deve ser informado")
    @NotBlank(message = "A password não pode ser em branco")
    @Column(name = "password", length = 10, nullable = false)
    private String password;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "autorizacoes",
            joinColumns = 
            @JoinColumn(name = "usador", referencedColumnName = "usador", nullable = false),
            inverseJoinColumns = 
            @JoinColumn(name = "autorizacao", referencedColumnName = "name", nullable = false), 
            uniqueConstraints = {@UniqueConstraint(columnNames = {"usador","autorizacao"})})    
    private List<Autorizacao> autorizacoes = new ArrayList<>();
    

    public Usador() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsador() {
        return usador;
    }

    public void setUsador(String usador) {
        this.usador = usador;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Autorizacao> getAutorizacoes() {
        return autorizacoes;
    }

    public void setAutorizacoes(List<Autorizacao> autorizacoes) {
        this.autorizacoes = autorizacoes;
    }
    
     @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Usador other = (Usador) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
