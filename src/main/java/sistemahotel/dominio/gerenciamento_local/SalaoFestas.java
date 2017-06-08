package sistemahotel.dominio.gerenciamento_local;

import javax.persistence.Entity;
//Programado por Tatsunori
@Entity
public class SalaoFestas extends Local {

    public SalaoFestas() {
        this.tipo = "Salao de Festas";
    }


}
