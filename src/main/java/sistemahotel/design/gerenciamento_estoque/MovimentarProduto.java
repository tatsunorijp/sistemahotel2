package sistemahotel.design.gerenciamento_estoque;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sistemahotel.dominio.gerenciamento_estoque.EstoqueDAO;
import sistemahotel.infraestrutura.Passing;



/**
 * Created by tatsunori on 28/07/17.
 */

public class MovimentarProduto {
    @FXML
    TextField tfIncr;
    @FXML
    Button btInc;

    public void btIncrementoActionHandler(ActionEvent e){
        EstoqueDAO ip = new EstoqueDAO();
        String incremento = tfIncr.getText();
        String estoque = Passing.produtopass.getQuantidade();

        int estoI = Integer.valueOf(estoque);
        int incrT = Integer.valueOf(incremento);

        estoI = estoI + incrT;
        estoque = String.valueOf(estoI);

        ip.incrementarProduto(Passing.produtopass.getId(), estoque);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operação realizada com sucesso");
        alert.setHeaderText(null);
        alert.setContentText("Movimentação realizada");
        alert.showAndWait();
        ((Node)e.getSource()).getParent().getScene().getWindow().hide();

    }


}
