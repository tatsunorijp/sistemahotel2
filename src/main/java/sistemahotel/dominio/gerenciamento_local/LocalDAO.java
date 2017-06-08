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
    public void novaHabitacao(String numero) {
        Session session = ssf.openSession();
        Habitacao habitacao = new Habitacao();
        habitacao.setNumero(numero);
        session.save(habitacao);
        session.close();
    }

    public void novoSalao(String numero) {
        Session session = ssf.openSession();
        SalaoFestas salao = new SalaoFestas();
        salao.setNumero(numero);
        session.save(salao);
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
