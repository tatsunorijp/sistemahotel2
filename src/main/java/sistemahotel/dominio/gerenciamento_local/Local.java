package sistemahotel.dominio.gerenciamento_local;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//Programado por Tatsunori
@Entity
public abstract class Local {
    @Id
    @GeneratedValue
    protected Long id;
    @Column(name = "Numero", unique = true)
    private String numero;
    protected String tipo;
    protected String status;

    public String toString(){
        return getNumero();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



}
