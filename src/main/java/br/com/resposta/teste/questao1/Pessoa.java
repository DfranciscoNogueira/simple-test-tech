package br.com.resposta.teste.questao1;

import java.util.Objects;

public class Pessoa {
    private int id;
    private String nome;

    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Sobrescrevendo equals() para comparar objetos pelo ID
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pessoa pessoa = (Pessoa) obj;
        return id == pessoa.id;
    }

    // Sobrescrevendo hashCode() para manter consistência com equals()
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static void main(String[] args) {

        Pessoa p1 = new Pessoa(1, "Diego");
        Pessoa p2 = new Pessoa(1, "Carlos");
        Pessoa p3 = new Pessoa(2, "Ana");

        boolean mesmaInstancia = p2 == p3; // Comparando referências de objetos (parece com o que o instanceof faz, o .equals não faz, pq compara o conteúdo)

        System.out.println("usando ==, " + mesmaInstancia); // True (mesmo ID)

        System.out.println("p1 é igual a p2? " + p1.equals(p2)); // True (mesmo ID)
        System.out.println("p1 é igual a p3? " + p1.equals(p3)); // False (ID diferente)

    }

}
