package sistemahotel.dominio.gerenciamento_local;

import javax.persistence.Entity;
//Programado por Tatsunori
@Entity
public class Habitacao extends Local {
    private int camasDeSolteiro;
    private int camasDeCasal;

    public int getCamasDeSolteiro() {
        return camasDeSolteiro;
    }

    public void setCamasDeSolteiro(int camasDeSolteiro) {
        this.camasDeSolteiro = camasDeSolteiro;
    }

    public int getCamasDeCasal() {
        return camasDeCasal;
    }

    public void setCamasDeCasal(int camasDeCasal) {
        this.camasDeCasal = camasDeCasal;
    }

    public Habitacao (){
        this.tipo = "Habitacao";
    }
}
