package sistemahotel.dominio.gerenciamento_acesso;

import sistemahotel.dominio.pessoa.Pessoa;

import javax.persistence.Entity;
//Programado por Marcelo
@Entity
public abstract class Usuario extends Pessoa {

    private String login;
    private String senha;

    public void fazerreserva(){

    }
    public String getTipo(){
        return this.tipo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}