package br.com.resposta.teste.questao4;

import jakarta.persistence.EntityManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    public Usuario buscarPorNome(Connection conexao, String nome) throws Exception {

        String sqlNot = "SELECT * FROM usuarios WHERE nome = " + nome; // Vulnerável a SQL Injection

        String sql = "SELECT * FROM usuarios WHERE nome = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, nome); // Prevenção contra SQL Injection
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Usuario(rs.getInt("id"), rs.getString("nome"));
            }

        }

        return null;
    }

    public Usuario buscarPorNome(EntityManager em, String nome) {
        return em.createQuery("SELECT u FROM Usuario u WHERE u.nome = :nome", Usuario.class)
                .setParameter("nome", nome) // Evita injeção SQL
                .getSingleResult();
    }

}
