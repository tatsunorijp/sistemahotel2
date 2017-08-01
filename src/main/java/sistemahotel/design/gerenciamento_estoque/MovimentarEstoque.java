package sistemahotel.design.gerenciamento_estoque;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sistemahotel.dominio.gerenciamento_estoque.EstoqueDAO;
import sistemahotel.infraestrutura.Passing;





public class MovimentarEstoque {
    @FXML
    TextField tfIncr;
    @FXML
    Button btInc;

    public void btIncrementoActionHandler(ActionEvent e){
        EstoqueDAO ip = EstoqueDAO.getInstance();
        String incremento = tfIncr.getText();
        String estoque = Passing.produtopass.getQuantidade();

        ip.incrementarProduto(Passing.produtopass.getId(), estoque, incremento);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operação realizada com sucesso");
        alert.setHeaderText(null);
        alert.setContentText("Movimentação realizada");
        alert.showAndWait();
        ((Node)e.getSource()).getParent().getScene().getWindow().hide();

    }


}
