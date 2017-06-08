package sistemahotel.dominio.gerenciamento_reserva;
import sistemahotel.dominio.gerenciamento_local.Local;
import org.hibernate.Session;
import sistemahotel.dominio.gerenciamento_local.Habitacao;
import sistemahotel.dominio.gerenciamento_local.SalaoFestas;
import sistemahotel.dominio.gerenciamento_acesso.Usuario;

import java.util.Scanner;

//Programado por Marcelo
public class CheckIn {
    Session session;
    Scanner s = new Scanner(System.in);
    private Long idlocal;
    public void checkInSalao(Usuario usuario, Reserva reserva){
        System.out.println("Id do salão reservado");
        idlocal = s.nextLong();
        SalaoFestas salao = (SalaoFestas) session.get(Local.class, idlocal);
        salao.setStatus("Ocupado");
        reserva.setStatus("Em andamento");
    }

    public void checkOutHabitacao(Usuario usuario, Reserva reserva){
        System.out.println("Id do quarto reservado");
        idlocal = s.nextLong();
        Habitacao habitacao = (Habitacao) session.get(Local.class, idlocal);
        habitacao.setStatus("Ocupado");
        reserva.setStatus("Em andamento");
    }
}
