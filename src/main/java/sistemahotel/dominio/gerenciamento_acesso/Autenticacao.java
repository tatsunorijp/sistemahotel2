package sistemahotel.dominio.gerenciamento_acesso;

import sistemahotel.dominio.gerenciamento_acesso.Usuario;
import sistemahotel.infraestrutura.DataController;

import javax.xml.crypto.Data;

public class Autenticacao {
    Usuario user;
    DataController controller = new DataController();
    public Usuario Autenticar(String usuario, String senha){
        user = null;
        for (Usuario a: DataController.listUsuario()) {
            if (a.getLogin().equals(usuario) && a.getSenha().equals(senha)) {
                user = a;
            }
        }
    return user;
    }
}
