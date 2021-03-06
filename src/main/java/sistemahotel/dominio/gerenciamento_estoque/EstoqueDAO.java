package sistemahotel.dominio.gerenciamento_estoque;
import static sistemahotel.infraestrutura.DataController.ssf;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.Scanner;

public class EstoqueDAO {

    private static EstoqueDAO uniqueInstance;

    Transaction tx = null;

    private EstoqueDAO(){

    }

    public static EstoqueDAO getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new EstoqueDAO();
        }
        return uniqueInstance;
    }

    public void adicionarProduto(String nome, String quantidade, String preco, String alertaEstoque){
        Session session = ssf.openSession();
        tx = session.beginTransaction();
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setPreco(preco);
        produto.setQuantidade(quantidade);
        produto.setAlertaEstoque(alertaEstoque);
        session.save(produto);
        tx.commit();
        session.close();
    }

    public void alterarProduto(Long id, String precostring, String quantidadestring, String alertaEstoque){
        Session session = ssf.openSession();
        tx = session.beginTransaction();
        Produto produto = session.get(Produto.class, id);
        produto.setPreco(precostring);
        produto.setQuantidade(quantidadestring);
        produto.setAlertaEstoque(alertaEstoque);
        session.save(produto);
        tx.commit();
        session.close();
    }

    public void removerProduto(Produto id){
        Session session = ssf.openSession();
        tx = session.beginTransaction();
        Produto p = session.get(Produto.class, id.getId());
        session.delete(p);
        tx.commit();
        session.close();
    }

    public void incrementarProduto(Long id, String estoque, String incremento){
        Session session = ssf.openSession();
        tx = session.beginTransaction();
        Produto produto = session.get(Produto.class, id);

        int estoI = Integer.valueOf(estoque);
        int incrT = Integer.valueOf(incremento);
        estoI = estoI + incrT;
        estoque = String.valueOf(estoI);

        produto.setQuantidade(estoque);
        session.save(produto);
        tx.commit();
        session.close();
    }
}

