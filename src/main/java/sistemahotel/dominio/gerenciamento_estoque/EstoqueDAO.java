package sistemahotel.dominio.gerenciamento_estoque;
import static sistemahotel.infraestrutura.DataController.ssf;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.Scanner;
//Programado por Leonardo
public class EstoqueDAO {
    Session session = ssf.openSession();
    Transaction tx = null;

    public void adicionarProduto(String nome, String quantidade, String preco, String alertaEstoque){
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setPreco(preco);
        produto.setQuantidade(quantidade);
        produto.setAlertaEstoque(alertaEstoque);
        session.save(produto);
    }

    public void alterarProduto(Long id, String precostring, String quantidadestring, String alertaEstoque){
        tx = session.beginTransaction();
        Produto produto = session.get(Produto.class, id);
        produto.setPreco(precostring);
        produto.setQuantidade(quantidadestring);
        produto.setAlertaEstoque(alertaEstoque);
        tx.commit();
        session.save(produto);
    }

    public void removerProduto(Produto id){
        tx = session.beginTransaction();
        Produto p = session.get(Produto.class, id.getId());
        session.delete(p);
        tx.commit();
    }
}

