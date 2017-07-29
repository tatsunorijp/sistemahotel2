package sistemahotel.dominio.gerenciamento_reserva;
import org.hibernate.Transaction;
import sistemahotel.dominio.gerenciamento_clientes.Cliente;
import sistemahotel.dominio.gerenciamento_local.Habitacao;
import sistemahotel.dominio.gerenciamento_local.Local;
import org.hibernate.Session;
import sistemahotel.dominio.gerenciamento_local.LocalDAO;
import sistemahotel.dominio.gerenciamento_local.SalaoFestas;
import sistemahotel.dominio.pessoa.Pessoa;
import sistemahotel.infraestrutura.DataController;
import sistemahotel.infraestrutura.Passing;

import static sistemahotel.infraestrutura.DataController.ssf;
import static sistemahotel.infraestrutura.Passing.reservapass;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
//Programado por Tatsunori
public class ReservaDAO {

    Scanner s = new Scanner(System.in);
    Session session = ssf.openSession();
    Transaction tx = null;
    public void novaReservaHab(Cliente cliente, Habitacao habitacao, LocalDate dateIn, LocalDate dateOut){
        Session session = ssf.openSession();
        tx = session.beginTransaction();
        Reserva nr1 = new Reserva();
        nr1.setCliente(cliente);
        nr1.setLocal(habitacao);
        nr1.setCheckIn(dateIn);
        nr1.setCheckOut(dateOut);
        nr1.getCliente();
        nr1.setStatus("Reservado");
        session.save(nr1);
        tx.commit();
        session.close();
    }

    public void novaReservaSalao(Cliente cliente, SalaoFestas salaofestas, LocalDate dateIn, LocalDate dateOut){
        Session session = ssf.openSession();
        tx = session.beginTransaction();
        Reserva nrs1 = new Reserva();
        nrs1.setCliente(cliente);
        nrs1.setLocal(salaofestas);
        nrs1.setCheckIn(dateIn);
        nrs1.setCheckOut(dateOut);
        nrs1.setStatus("Reservado");
        session.save(nrs1);
        tx.commit();
        session.close();
    }

    public void alterarReserva(String nome, String local, String status, LocalDate dataIn, LocalDate dataOut){
        Session session = ssf.openSession();
        Reserva r;
        tx = session.beginTransaction();
        r = session.get(Reserva.class, reservapass.getId());
        for (Cliente c: DataController.listCliente()){
            if (nome.equals(c.getNome())){
                r.setCliente(c);
            }
        }
        for (Local l: DataController.listLocal()){
            if(local.equals(l.getNumero())){
                r.setLocal(l);
            }
        }
        r.setStatus(status);
        r.setCheckIn(dataIn);
        r.setCheckOut(dataOut);
        session.save(r);
        tx.commit();
        session.close();
    }

    public void deletarReserva(Reserva r){
        Session session = ssf.openSession();
        //Reserva r;
        tx = session.beginTransaction();
        //r = session.get(Reserva.class, id);
        session.delete(r);
        tx.commit();
        session.close();

    }

}
