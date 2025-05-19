package br.com.resposta.teste.questao8;

import java.util.Objects;

public class UsuarioSimples {

    private String nome;
    private String email;
    private String endereco;
    private String telefone;
    private boolean isAdmin;

    public UsuarioSimples(String nome, String email, String endereco, String telefone, boolean isAdmin) {

        if (Objects.isNull(nome) || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório!");
        }

        if (Objects.isNull(email) || !email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("E-mail inválido!");
        }

        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.isAdmin = isAdmin;

    }

    public String getEmail() {
        return email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
