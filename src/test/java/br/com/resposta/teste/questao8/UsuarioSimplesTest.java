package br.com.resposta.teste.questao8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UsuarioSimplesTest {

    @Test
    void testCriarUsuarioComEmailDuplicado() {

        UsuarioSimplesService usuarioService = new UsuarioSimplesService();

        UsuarioSimples usuario1 = new UsuarioSimples("João", "joao@email.com", "Rua A", "123456789", false);
        UsuarioSimples usuario2 = new UsuarioSimples("Maria", "joao@email.com", "Rua B", "987654321", false);

        usuarioService.cadastrarUsuario(usuario1);

        Exception exception = assertThrows(EmailDuplicadoException.class, () -> {
            usuarioService.cadastrarUsuario(usuario2);
        });

        assertEquals("E-mail já cadastrado!", exception.getMessage());
    }

    @Test
    void testUsuarioNaoAdminNaoPodeExcluir() {

        UsuarioSimplesService usuarioService = new UsuarioSimplesService();

        UsuarioSimples admin = new UsuarioSimples("Admin", "admin@email.com", "Rua Central", "999999999", true);
        UsuarioSimples comum = new UsuarioSimples("Usuário", "user@email.com", "Rua Secundária", "888888888", false);

        usuarioService.cadastrarUsuario(admin);
        usuarioService.cadastrarUsuario(comum);

        Exception exception = assertThrows(PermissaoNegadaException.class, () -> {
            usuarioService.excluirUsuario(comum.getEmail(), comum);
        });

        assertEquals("Somente administradores podem excluir usuários!", exception.getMessage());
    }

}