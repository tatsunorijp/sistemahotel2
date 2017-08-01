package sistemahotel.dominio.gerenciamento_local;

import javax.persistence.Entity;

@Entity
public class Habitacao extends Local {




    public Habitacao (){
        this.tipo = "Habitacao";
    }
}
