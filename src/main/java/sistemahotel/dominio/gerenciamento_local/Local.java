package sistemahotel.dominio.gerenciamento_local;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//Programado por Tatsunori
@Entity
public class Local {
    @Id
    @GeneratedValue
    protected Long id;
    private String numero;
    protected String tipo;
    protected String status;
    protected String informacoesAdicionais;
    protected String preco;
    private String camasDeSolteiro;
    private String camasDeCasal;

    public String getCamasDeSolteiro() {
        return camasDeSolteiro;
    }

    public void setCamasDeSolteiro(String camasDeSolteiro) {
        this.camasDeSolteiro = camasDeSolteiro;
    }

    public String getCamasDeCasal() {
        return camasDeCasal;
    }

    public void setCamasDeCasal(String camasDeCasal) {
        this.camasDeCasal = camasDeCasal;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getInformacoesAdicionais() {
        return informacoesAdicionais;
    }

    public void setInformacoesAdicionais(String informacoesAdicionais) {
        this.informacoesAdicionais = informacoesAdicionais;
    }

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
