package br.com.resposta.teste.questao8;


import java.util.HashMap;
import java.util.Map;

public class UsuarioSimplesService {

    private Map<String, UsuarioSimples> usuarios = new HashMap<>();

    public void cadastrarUsuario(UsuarioSimples usuario) {

        if (usuarios.containsKey(usuario.getEmail())) {
            throw new EmailDuplicadoException("E-mail já cadastrado!");
        }

        usuarios.put(usuario.getEmail(), usuario);

    }

    public void excluirUsuario(String email, UsuarioSimples solicitante) {

        if (!solicitante.isAdmin()) {
            throw new PermissaoNegadaException("Somente administradores podem excluir usuários!");
        }

        if (!usuarios.containsKey(email)) {
            throw new UsuarioNaoEncontradoException("Usuário não encontrado!");
        }

        usuarios.remove(email);
        
    }

}

