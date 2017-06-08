package sistemahotel.dominio.gerenciamento_estoque;
import static sistemahotel.infraestrutura.DataController.ssf;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;
//Programado por Leonardo
public class EstoqueDAO {
    Session session = ssf.openSession();
    Transaction tx = null;

    public void adicionarProduto(String nome, String quantidade, String preco){
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setPreco(preco);
        produto.setQuantidade(quantidade);
        session.save(produto);
    }

    public void alterarProduto(Long id, String precostring, String quantidadestring){
        tx = session.beginTransaction();
        Produto produto = session.get(Produto.class, id);
        produto.setPreco(precostring);
        produto.setQuantidade(quantidadestring);
        tx.commit();
        session.save(produto);
    }

    public void removerProduto(Long id){
        tx = session.beginTransaction();
        Produto p = session.get(Produto.class, id);
        session.delete(p);
        tx.commit();
    }
}

