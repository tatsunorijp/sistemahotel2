package sistemahotel.dominio.gerenciamento_local;

import javax.persistence.Entity;
//Programado por Tatsunori
@Entity
public class Habitacao extends Local {
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

    public Habitacao (){
        this.tipo = "Habitacao";
    }
}
