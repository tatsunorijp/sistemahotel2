package sistemahotel.dominio.gerenciamento_reserva;

import org.hibernate.Transaction;
import sistemahotel.dominio.gerenciamento_clientes.Cliente;
import sistemahotel.dominio.gerenciamento_estoque.EstoqueDAO;
import sistemahotel.dominio.gerenciamento_local.Local;
import org.hibernate.Session;
import sistemahotel.infraestrutura.DataController;

import static sistemahotel.infraestrutura.DataController.ssf;
import static sistemahotel.infraestrutura.Passing.reservapass;

import java.time.LocalDate;

//Programado por Tatsunori
public class ReservaDAO {

    Session session = ssf.openSession();
    Transaction tx = null;
    public void novaReservaHab(Cliente cliente, Local local, LocalDate dateIn, LocalDate dateOut, String qtdhospedes){
        Session session = ssf.openSession();
        tx = session.beginTransaction();
        Reserva nr1 = new Reserva();
        nr1.setCliente(cliente);
        nr1.setLocal(local);
        nr1.setCheckIn(dateIn);
        nr1.setCheckOut(dateOut);
        nr1.getCliente();
        nr1.setStatus("Reservado");
        nr1.setQtdhospede(qtdhospedes);
        session.save(nr1);
        tx.commit();
        session.close();
    }


    public void alterarReserva(String nome, String local, String status, LocalDate dataIn, LocalDate dataOut, String qtdhospedes){
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
        r.setQtdhospede(qtdhospedes);
        session.save(r);
        tx.commit();
        session.close();
    }

    public void checkIn(){
        Session session = ssf.openSession();
        tx = session.beginTransaction();
        Reserva r;
        r = session.get(Reserva.class, reservapass.getId());
        r.setStatus("Em andamento");
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

    public boolean addConsumo(String produtoNome, String preco, String quantidade, String estoque, Long id, String cliente){
        Session session = ssf.openSession();
        tx = session.beginTransaction();

        Reserva r;
        r = session.get(Reserva.class, reservapass.getId());

        int Iquantidade = Integer.valueOf(quantidade);
        int Iestoque = Integer.valueOf(estoque);
        if((Iestoque - Iquantidade) >= 0){
            Consumacao consumo = new Consumacao();
            consumo.setProduto(produtoNome);
            consumo.setPreco(preco);
            consumo.setQuantidade(quantidade);
            consumo.setCliente(cliente);
            consumo.setReserva(r);

            session.save(consumo);
            tx.commit();
            session.close();

            quantidade = String.valueOf(-Iquantidade);
            EstoqueDAO ic = new EstoqueDAO();
            ic.incrementarProduto(id, estoque, quantidade);

            return true;

        }else{
            session.close();
            return false;
        }


    }

}
