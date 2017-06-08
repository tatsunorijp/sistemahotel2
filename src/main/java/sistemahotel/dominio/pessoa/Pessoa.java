package sistemahotel.dominio.pessoa;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
//Programado por Leonardo
@Entity
public abstract class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    @NotNull
    protected String tipo;
    @Column(name="CPF", unique = true)
    private String CPF;
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
