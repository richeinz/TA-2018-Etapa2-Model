
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Ricardo/Joel
 */
@Entity
@Table(name = "carro")
public class Carro implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_carro", sequenceName = "seq_carro_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_carro", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O modelo não pode ser em branco")
    @NotNull(message = "O modelo não pode ser nulo")
    @Length(max = 20, message = "O modelo não pode ter mais de {max} caracteres")    
    @Column(name = "modelo", length = 20, nullable = false)
    private String modelo;
    
    @NotBlank(message = "O ano não pode ser em branco")
    @NotNull(message = "O ano não pode ser nulo")
    @Length(max = 4, message = "O ano não pode ter mais de {max} caracteres")    
    @Column(name = "ano", length = 4, nullable = false)
    private String ano;
    
    @NotBlank(message = "A cor não pode ser em branco")
    @NotNull(message = "A cor não pode ser nula")
    @Length(max = 20, message = "A cor não pode ter mais de {max} caracteres")    
    @Column(name = "cor", length = 20, nullable = false)
    private String cor;
    
    @NotNull(message = "A potência deve ser informadao")
    @Column(name = "potencia", nullable = false, columnDefinition = "numeric(12,1)")
    private Double potencia;
    
    @NotBlank(message = "A placa não pode ser em branco")
    @NotNull(message = "A placa não pode ser nula")
    @Length(max = 7, message = "A placa não pode ter mais de {max} caracteres")    
    @Column(name = "placa", length = 7, nullable = false)
    private String placa;
    
    @NotNull(message = "O preço deve ser informadao")
    @Column(name = "preco", nullable = false, columnDefinition = "numeric(12,2)")
    private Double preco;
    
    @ManyToOne
    @NotNull(message = "A marca deve ser informado")
    @JoinColumn(name = "marca", referencedColumnName = "id",  nullable = false, foreignKey = @ForeignKey(name = "fK_marca_id"))
    private Marca marca;
    
    @OneToMany(mappedBy = "carro", cascade = CascadeType.ALL, 
            orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Imagem> imagens = new ArrayList<>();

    public Carro() {
        
    }
    
    public void adicionarImagem(Imagem obj){
        obj.setCarro(this);
        this.imagens.add(obj);
    }
    
       public void removerImagem(int index){
        this.imagens.remove(index);
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Double getPotencia() {
        return potencia;
    }

    public void setPotencia(Double potencia) {
        this.potencia = potencia;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Imagem> getImagens() {
        return imagens;
    }

    public void setImagens(List<Imagem> imagens) {
        this.imagens = imagens;
    }
    
}
