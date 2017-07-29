package sistemahotel.infraestrutura;

import sistemahotel.dominio.gerenciamento_clientes.Cliente;
import sistemahotel.dominio.gerenciamento_estoque.Produto;
import sistemahotel.dominio.gerenciamento_local.Habitacao;
import sistemahotel.dominio.gerenciamento_local.Local;
import sistemahotel.dominio.gerenciamento_local.SalaoFestas;
import sistemahotel.dominio.gerenciamento_reserva.Reserva;

//Programado por Tatsunori
public class Passing {

    public static Cliente clientepass = new Cliente();
    public static Reserva reservapass = new Reserva();
    public static Local localpass;
    public static Habitacao habitacaopass = new Habitacao();
    public static SalaoFestas salaopass = new SalaoFestas();
    public static Produto produtopass = new Produto();

}
