package sistemahotel.dominio.gerenciamento_local;

import javax.persistence.Entity;
//Programado por Tatsunori
@Entity
public class SalaoFestas extends Local {
    String maximoPessoas;
    String informacoesAdicionais;

    @Override
    public String getInformacoesAdicionais() {
        return informacoesAdicionais;
    }

    @Override
    public void setInformacoesAdicionais(String informacoesAdicionais) {
        this.informacoesAdicionais = informacoesAdicionais;
    }

    public String getMaximoPessoas() {
        return maximoPessoas;
    }

    public void setMaximoPessoas(String maximoPessoas) {
        this.maximoPessoas = maximoPessoas;
    }

    public SalaoFestas() {
        this.tipo = "Salao de Festas";
    }


}
