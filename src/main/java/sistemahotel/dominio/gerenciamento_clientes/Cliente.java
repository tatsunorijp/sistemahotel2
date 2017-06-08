package sistemahotel.dominio.gerenciamento_clientes;

import sistemahotel.dominio.pessoa.Pessoa;

import javax.persistence.Entity;
//Programado por Tatsunori
@Entity
public class Cliente extends Pessoa {
    private String telefone;
    private String endereco;

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
