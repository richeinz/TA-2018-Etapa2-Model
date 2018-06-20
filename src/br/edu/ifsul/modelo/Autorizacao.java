
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Ricardo/Joel
 */
@Entity
@Table(name = "autorizacao")
public class Autorizacao implements Serializable {
    
    @Id
    @NotBlank(message = "O name não pode ser em branco")
    @NotNull(message = "O name não pode ser nulo")
    @Length(max = 30, message = "O name não pode ter mais de {max} caracteres")
    @Column(name = "name", length = 30, nullable = false)
    private String name;
    
    @NotBlank(message = "A description não pode ser em branco")
    @NotNull(message = "A description não pode ser nula")
    @Length(max = 40, message = "A description não pode ter mais de {max} caracteres")    
    @Column(name = "description", length = 40, nullable = false)
    private String description;

    public Autorizacao() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.getName());
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
        final Autorizacao other = (Autorizacao) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
}
