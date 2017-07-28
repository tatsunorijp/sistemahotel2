package sistemahotel.design.gerenciamento_estoque;


import javafx.fxml.FXML;
import sistemahotel.dominio.gerenciamento_estoque.EstoqueDAO;
import sistemahotel.infraestrutura.Passing;

import java.awt.*;

/**
 * Created by tatsunori on 28/07/17.
 */

public class MovimentarProduto {
    @FXML
    TextField tfIncr;
    @FXML
    Button btInc;

    public void btIncrementoActionHandler(){
        EstoqueDAO ip = new EstoqueDAO();
        String incremento = tfIncr.getText();
        String estoque = Passing.produtopass.getQuantidade();

        int estoI = Integer.valueOf(estoque);
        int incrT = Integer.valueOf(incremento);

        estoI = estoI + incrT;
        estoque = String.valueOf(estoI);

        ip.incrementarProduto(Passing.produtopass.getId(), estoque);
    }


}
