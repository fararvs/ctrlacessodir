package util;

import model.Pasta;
import model.Usuario;

/**
 *
 * @author rvsfara
 */
public class Template {
    public static void adicionaAdmin(){
        Usuario admin = new Usuario();
        admin.setAdmin(Boolean.TRUE);
        admin.setNome("Administrador");
        admin.setPerSeguranca("Qual seu personagem favorito?");
        admin.setResSeguranca("Wolverine");
        admin.setUsuario("admin");
        admin.setSenha("admin");
        Pasta dir = new Pasta();
        dir.setPas_nome("raiz");
        dir.setPas_caminho("/");
        
    }
    public static void main(String[] args) {
        adicionaAdmin();
    }
    
}
