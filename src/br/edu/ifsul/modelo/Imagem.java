
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Ricardo/Joel
 */
@Entity
@Table(name = "imagem")
public class Imagem implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_imagem", sequenceName = "seq_imagem_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_imagem", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O nome deve ser informado")
    @NotBlank(message = "O nome não pode ser em branco")
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    
    @NotNull(message = "A descrição deve ser informada")
    @NotBlank(message = "A descrição não pode ser em branco")
    @Column(name = "descricao", nullable = false, length = 50)    
    private String descricao;
    
    @NotNull(message = "O arquivo deve ser informado")
    @Column(name = "arquivo", nullable = false)
    @Lob
    private byte[] arquivo;
    
    @NotNull(message = "O carro deve ser informado")
    @ManyToOne
    @JoinColumn(name = "carro", referencedColumnName = "id", nullable = false)
    private Carro carro;

    public Imagem() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
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
        final Imagem other = (Imagem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
