package br.com.resposta.teste.questao4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UsuarioDAOTest {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private Connection conexao;
    private UsuarioDAO usuarioDAO;

    @BeforeAll
    static void inicializarBanco() {
        emf = Persistence.createEntityManagerFactory("testePU");
    }

    @BeforeEach
    void setUp() throws Exception {
        em = emf.createEntityManager();
        conexao = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
        usuarioDAO = new UsuarioDAO();

        List<Usuario> usuarios = List.of(new Usuario(1, "Diego"), new Usuario(2, "Carlos"));

        for (Usuario usuario : usuarios) {
            Usuario existente = em.find(Usuario.class, usuario.getId());
            if (existente == null) {
                em.getTransaction().begin();
                em.persist(usuario);
                em.getTransaction().commit();
            } else {
                System.out.println("Usuário com ID já existente.");
            }
        }

    }

    @Test
    void testBuscarPorNomeComJPA() {
        Usuario usuario = usuarioDAO.buscarPorNome(em, "Carlos");
        assertNotNull(usuario, "O usuário não deve ser nulo.");
        assertEquals(2, usuario.getId(), "O ID deve ser 2.");
        assertEquals("Carlos", usuario.getNome(), "O nome deve ser 'Carlos'.");
    }

    @Test
    void testBuscarPorNomeComJDBC() throws Exception {
        Usuario usuario = usuarioDAO.buscarPorNome(conexao, "Diego");
        assertNotNull(usuario, "O usuário não deve ser nulo.");
        assertEquals(1, usuario.getId(), "O ID deve ser 1.");
        assertEquals("Diego", usuario.getNome(), "O nome deve ser 'Diego'.");
    }

    @AfterEach
    void limparTestes() throws Exception {
        conexao.close();
        em.close();
    }

    @AfterAll
    static void finalizarBanco() {
        emf.close();
    }

}