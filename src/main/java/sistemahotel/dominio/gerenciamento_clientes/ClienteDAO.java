package sistemahotel.dominio.gerenciamento_clientes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sistemahotel.infraestrutura.DataController;
import sistemahotel.infraestrutura.Passing;

import java.time.LocalDate;
import java.util.List;

import static sistemahotel.infraestrutura.DataController.ssf;
//Programado por Tatsunori
public class ClienteDAO {
    private String nomecliente;
    private int opcao;
    private String endereco;
    private long id;

    Session session = ssf.openSession();
    Transaction tx = null;

    Cliente c1 = new Cliente();
    public void novoCliente(String nome, String endereco, String cpf, String telefone, String rg, String email, String cidade, String nacionalidade, String placaDoCarro, String informacoesAdicionais, LocalDate dataDeNascimento){
        c1.setTipo();
        c1.setNome(nome);
        c1.setCPF(cpf);
        c1.setEndereco(endereco);
        c1.setTelefone(telefone);
        c1.setRG(rg);
        c1.setEmail(email);
        c1.setCidade(cidade);
        c1.setNacionalidade(nacionalidade);
        c1.setPlacaDoCarro(placaDoCarro);
        c1.setInformacoesAdicionais(informacoesAdicionais);
        c1.setDataDeNascimento(dataDeNascimento);
        session.save(c1);
    }

    //byTatsu
    public void alterarCadastro(String nome, String endereco, String cpf, String telefone, String rg, String email, String cidade, String nacionalidade, String placaDoCarro, String informacoesAdicionais, LocalDate dataDeNascimento){
        tx = session.beginTransaction();
        id = Passing.clientepass.getId();
        c1 = session.get(Cliente.class, id);
        c1.setNome(nome);
        c1.setEndereco(endereco);
        c1.setCPF(cpf);
        c1.setTelefone(telefone);
        c1.setTipo();
        c1.setRG(rg);
        c1.setEmail(email);
        c1.setCidade(cidade);
        c1.setNacionalidade(nacionalidade);
        c1.setPlacaDoCarro(placaDoCarro);
        c1.setInformacoesAdicionais(informacoesAdicionais);
        c1.setDataDeNascimento(dataDeNascimento);
        session.flush();
        session.saveOrUpdate(c1);
        tx.commit();
    }

    public void deletarCadastro(Cliente c1){
        tx = session.beginTransaction();
        session.delete(c1);
        tx.commit();
    }
}
