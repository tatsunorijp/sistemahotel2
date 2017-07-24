package sistemahotel.design.telainicial;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import javax.swing.text.html.ListView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

//Programado por Tatsunori
public class newTelaInicial implements Initializable{

    @FXML
    TabPane tbPane;
    @FXML
    ListView lvClientes;
    @FXML
    ListView lvReservas;
    @FXML
    ListView lvEstoque;
    @FXML
    ListView lvLocais;


    //Gerenciador de Clientes
    @FXML
    Button btNovoCadastro;
    @FXML
    Button AlterarCadastro;
    @FXML
    Button DeletarCadastro;

    public void loadListView(){

    }

    public void btNovoCadastroActionHandler(){
        try{
            Node node;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/fxml_clientes/cadastro_cliente.fxml"));
            node = loader.load();
            Tab tb = new Tab("Novo Cadastro",node);
            tbPane.getTabs().add(tb);
        }catch(IOException ex){
            ex.printStackTrace();
        }

    }

    public void btAlterarCadastroActionHandler (ActionEvent e){
        try{
        Node node;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/fxml_clientes/alterar_cadastro_list.fxml"));
        node = loader.load();

        Tab tb = new Tab("Alterar Cadastro",node);
        tbPane.getTabs().add(tb);
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public void btDeletarCadastroActionHandler(){
        try{
            Node node;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/fxml_clientes/deletar_cadastrocliente.fxml"));
            node = loader.load();
            Tab tb = new Tab("Deletar Cadastro",node);
            tbPane.getTabs().add(tb);
        }catch(IOException ex){
            ex.printStackTrace();
        }

    }

    //Gerenciador de Reservas
    @FXML
    Button NovaReservaHabitacao;
    @FXML
    Button NovaReservaSalao;
    @FXML
    Button AlterarReserva;
    @FXML
    Button ExcluirReserva;

    public void btNovaReservaHabitacaoActionHandler(){
        try{
            Node node;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/fxml_reservas/reserva_habitacao.fxml"));
            node = loader.load();
            Tab tb = new Tab("Reservar Habitação",node);
            tbPane.getTabs().add(tb);
        }catch(IOException ex){
            ex.printStackTrace();
        }

    }
    public void btNovaReservaSalaoActionHandler(){
        try{
            Node node;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/fxml_reservas/reserva_salao.fxml"));
            node = loader.load();
            Tab tb = new Tab("Reservar Salão",node);
            tbPane.getTabs().add(tb);
        }catch(IOException ex){
            ex.printStackTrace();
        }

    }
    public void beAlterarReservaActionHandler(){
        try{
            Node node;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/fxml_reservas/alterar_reserva_list.fxml"));
            node = loader.load();
            Tab tb = new Tab("Alterar Reserva",node);
            tbPane.getTabs().add(tb);
        }catch(IOException ex){
            ex.printStackTrace();
        }

    }
    public void btExcluirReservaActionHandler(){
        try{
            Node node;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/fxml_reservas/deletar_reserva.fxml"));
            node = loader.load();
            Tab tb = new Tab("Excluir Reserva",node);
            tbPane.getTabs().add(tb);
        }catch(IOException ex){
            ex.printStackTrace();
        }

    }


    //Gerenciador de Estoque
    @FXML
    Button btAdicionarProduto;
    @FXML
    Button btAlterarProduto;
    @FXML
    Button btRemoverProduto;
    public void btAdicionarProdutoActionHandler(){
        try{
            Node node;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/fxml_estoque/adicionar_produto.fxml"));
            node = loader.load();
            Tab tb = new Tab("Adicionar Produto",node);
            tbPane.getTabs().add(tb);
        }catch(IOException ex){
            ex.printStackTrace();
        }

    }
    public void btAlterarProdutoActionHandler(){
        try{
            Node node;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/fxml_estoque/selecionar_alterar_produto.fxml"));
            node = loader.load();
            Tab tb = new Tab("Alterar Produto",node);
            tbPane.getTabs().add(tb);
        }catch(IOException ex){
            ex.printStackTrace();
        }

    }
    public void btRemoverProdutoActionHandler(){
        try{
            Node node;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/fxml_estoque/remover_produto.fxml"));
            node = loader.load();
            Tab tb = new Tab("Remover Produto",node);
            tbPane.getTabs().add(tb);
        }catch(IOException ex){
            ex.printStackTrace();
        }

    }

    //Gerenciador de Locais
    @FXML
    Button btNovaHabitacao;
    @FXML
    Button btNovoSalaDeEventos;
    @FXML
    Button btDeletarHabitacao;
    @FXML
    Button btDeletarSalaoDeEventos;

    public void btNovaHabitacaoActionHandler(){
        try{
            Node node;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/fxml_locais/cadastro_habitacao.fxml"));
            node = loader.load();
            Tab tb = new Tab("Nova Habitação",node);
            tbPane.getTabs().add(tb);
        }catch(IOException ex){
            ex.printStackTrace();
        }

    }
    public void btNovoSalaoDeEventosActionHandler(){
        try{
            Node node;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/fxml_locais/cadastro_salao.fxml"));
            node = loader.load();
            Tab tb = new Tab("Novo Salão de Eventos",node);
            tbPane.getTabs().add(tb);
        }catch(IOException ex){
            ex.printStackTrace();
        }

    }
    public void btDeletarLocalActionHandler(){
        try{
            Node node;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/fxml_locais/deletar_local.fxml"));
            node = loader.load();
            Tab tb = new Tab("Deletar Local",node);
            tbPane.getTabs().add(tb);
        }catch(IOException ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
