package sistemahotel.dominio.gerenciamento_local;
import javafx.event.ActionEvent;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sistemahotel.dominio.gerenciamento_acesso.Usuario;
import sistemahotel.dominio.gerenciamento_clientes.Cliente;
import sistemahotel.infraestrutura.DataController;

import static sistemahotel.infraestrutura.DataController.ssf;
import java.util.Scanner;
//Programado por Tatsunori
public class LocalDAO {
    Transaction tx = null;
    public void novaHabitacao(String numero, String camasSolteiro, String camasCasal, String informacoesAdicionais) {
        Session session = ssf.openSession();
        tx = session.beginTransaction();
        Habitacao habitacao = new Habitacao();
        habitacao.setNumero(numero);
        habitacao.setCamasDeSolteiro(camasSolteiro);
        habitacao.setCamasDeCasal(camasCasal);
        habitacao.setInformacoesAdicionais(informacoesAdicionais);
        session.save(habitacao);
        tx.commit();
        session.close();
    }

    public void novoSalao(String numero, String maximoPessoas, String informacoesAdicionais) {
        Session session = ssf.openSession();
        tx = session.beginTransaction();
        SalaoFestas salao = new SalaoFestas();
        salao.setNumero(numero);
        salao.setMaximoPessoas(maximoPessoas);
        salao.setInformacoesAdicionais(informacoesAdicionais);
        session.save(salao);
        tx.commit();
        session.close();
    }

    public void editarLocal() {

    }

    public void deletarLocal(Local local) {
        Session session = ssf.openSession();
        tx = session.beginTransaction();
        session.delete(local);
        tx.commit();
    }

}
