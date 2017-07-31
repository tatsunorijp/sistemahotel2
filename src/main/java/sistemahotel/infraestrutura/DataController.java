package sistemahotel.infraestrutura;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import sistemahotel.dominio.gerenciamento_acesso.Usuario;
import sistemahotel.dominio.gerenciamento_clientes.Cliente;
import sistemahotel.dominio.gerenciamento_estoque.Produto;
import sistemahotel.dominio.gerenciamento_local.Habitacao;
import sistemahotel.dominio.gerenciamento_local.Local;
import sistemahotel.dominio.gerenciamento_local.SalaoFestas;
import sistemahotel.dominio.gerenciamento_reserva.Consumacao;
import sistemahotel.dominio.gerenciamento_reserva.Reserva;

import java.util.List;
//Programado por Marcelo
public class DataController {
    public static SessionFactory ssf;

    public static void startSessionFactory() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        ssf = sessionFactory;
    }

    public Session startSession(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        return session;
    }

    public Transaction startTransaction(Session session) {
        Transaction transaction = null;
        transaction = session.beginTransaction();
        return transaction;
    }

    public void commitTransaction(Transaction transaction) {
        transaction.commit();
    }

    public void closeSession(Session session) {
        session.close();
    }

    public void closeSessionFactory(SessionFactory sessionFactory) {
        sessionFactory.close();
    }

    public static List<Usuario> listUsuario() {
        Session session = ssf.openSession();
        Transaction transaction = null;

        List users = null;

        try {
            transaction = session.beginTransaction();
            users = session.createQuery("FROM Usuario").list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return users;
    }

    public static Usuario getUsuario(long id) {
        Session session = ssf.openSession();
        Transaction transaction = null;

        Usuario user = null;

        try {
            transaction = session.beginTransaction();
            user = (Usuario) session.get(Usuario.class, id);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }

    public static Reserva getReserva(long id) {
        Session session = ssf.openSession();
        Transaction transaction = null;

        Reserva r = null;

        try {
            transaction = session.beginTransaction();
            r = (Reserva) session.get(Reserva.class, id);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return r;
    }

    public static List<Reserva> listReserva() {
        Session session = ssf.openSession();
        Transaction transaction = null;

        List reservas = null;

        try {
            transaction = session.beginTransaction();
            reservas = session.createQuery("FROM Reserva").list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return reservas;
    }

    public static List<Consumacao> listConsumacao() {
        Session session = ssf.openSession();
        Transaction transaction = null;

        List consumo = null;

        try {
            transaction = session.beginTransaction();
            consumo = session.createQuery("FROM Consumacao").list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return consumo;
    }

    public static List<Cliente> listCliente() {
        Session session = ssf.openSession();
        Transaction transaction = null;

        List clientes = null;

        try {
            transaction = session.beginTransaction();
            clientes = session.createQuery("FROM Cliente").list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return clientes;
    }

    public static Cliente getCliente(long id) {
        Session session = ssf.openSession();
        Transaction transaction = null;

        Cliente c = null;

        try {
            transaction = session.beginTransaction();
            c = (Cliente) session.get(Cliente.class, id);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return c;
    }

    public static Habitacao getHabitacao(String numero) {
        Session session = ssf.openSession();
        Transaction transaction = null;

        Habitacao h = null;

        try {
            transaction = session.beginTransaction();
            h = (Habitacao) session.get(Habitacao.class, numero);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return h;
    }

    public static List<Habitacao> listHabitacoes() {
        Session session = ssf.openSession();
        Transaction transaction = null;

        List habitacoes = null;

        try {
            transaction = session.beginTransaction();
            habitacoes = session.createQuery("FROM Habitacao").list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return habitacoes;
    }


    public static List<Local> listLocal() {
        Session session = ssf.openSession();
        Transaction transaction = null;

        List locais = null;

        try {
            transaction = session.beginTransaction();
            locais = session.createQuery("FROM Local").list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return locais;
    }

    public static List<SalaoFestas> listSalao() {
        Session session = ssf.openSession();
        Transaction transaction = null;

        List salao = null;

        try {
            transaction = session.beginTransaction();
            salao = session.createQuery("FROM SalaoFestas").list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return salao;
    }

    public static List<Produto> listProduto() {
        Session session = ssf.openSession();
        Transaction transaction = null;

        List produto = null;

        try {
            transaction = session.beginTransaction();
            produto = session.createQuery("FROM Produto").list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return produto;
    }
}