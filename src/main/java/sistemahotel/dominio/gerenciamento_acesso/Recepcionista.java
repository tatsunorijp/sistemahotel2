package sistemahotel.dominio.gerenciamento_acesso;

import javax.persistence.Entity;
//Programado por Marcelo
@Entity
public class Recepcionista extends Usuario {

    public String getTipo() {
        return tipo;
    }

    public void setTipo() {
        this.tipo = "Recepcionista";
    }


}
