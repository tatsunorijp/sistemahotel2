package sistemahotel.dominio.gerenciamento_acesso;

import javax.persistence.Entity;

@Entity
public class Gerente extends Usuario {


    public String getTipo() {
        return tipo;
    }

    public void setTipo() {
        this.tipo = "Gerente";
    }

    public void gerarRelatorio(){

    }

}
