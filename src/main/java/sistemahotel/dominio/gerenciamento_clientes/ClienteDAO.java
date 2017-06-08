package sistemahotel.dominio.gerenciamento_clientes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sistemahotel.infraestrutura.Passing;

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
    public void novoCliente(String nome, String endereco, String cpf, String telefone){
        c1.setTipo();
        c1.setNome(nome);
        c1.setCPF(cpf);
        c1.setEndereco(endereco);
        c1.setTelefone(telefone);
        session.save(c1);
    }

    //byTatsu
    public void alterarCadastro(String nome, String endereco, String cpf, String telefone){
        tx = session.beginTransaction();
        id = Passing.clientepass.getId();
        c1 = session.get(Cliente.class, id);
        c1.setNome(nome);
        c1.setEndereco(endereco);
        c1.setCPF(cpf);
        c1.setTelefone(telefone);
        c1.setTipo();
        session.flush();
        session.saveOrUpdate(c1);
        tx.commit();
    }

    public void deletarCadastro(Long id){
        tx = session.beginTransaction();
        c1 = session.get(Cliente.class, id);
        session.delete(c1);
        tx.commit();
    }
}
