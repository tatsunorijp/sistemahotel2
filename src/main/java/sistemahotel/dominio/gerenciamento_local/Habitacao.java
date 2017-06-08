package sistemahotel.dominio.gerenciamento_local;

import javax.persistence.Entity;
//Programado por Tatsunori
@Entity
public class Habitacao extends Local {
    public Habitacao (){
        this.tipo = "Habitacao";
    }
}
