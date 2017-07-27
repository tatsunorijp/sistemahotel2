package sistemahotel.dominio.gerenciamento_clientes;

import sistemahotel.dominio.pessoa.Pessoa;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

//Programado por Tatsunori
@Entity
public class Cliente extends Pessoa {
    private String telefone;
    private String endereco;
    private String email;
    private String cidade;
    private String nacionalidade;
    private String placaDoCarro;
    private String informacoesAdicionais;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getPlacaDoCarro() {
        return placaDoCarro;
    }

    public void setPlacaDoCarro(String placaDoCarro) {
        this.placaDoCarro = placaDoCarro;
    }

    public String getInformacoesAdicionais() {
        return informacoesAdicionais;
    }

    public void setInformacoesAdicionais(String informacoesAdicionais) {
        this.informacoesAdicionais = informacoesAdicionais;
    }

    public String toString(){
        return getNome();
    }

    public Cliente() {
    }

    public void setTipo(){
        this.tipo = "Cliente";
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        System.out.print(telefone);
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void solicitareserva(){

    }

    public void realizarpagamento(){

    }
}
