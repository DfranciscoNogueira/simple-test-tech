package br.com.resposta.teste.questao1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PessoaTest {

    @Test
    public void testPessoasComMesmoIdSaoIguais() {
        Pessoa p1 = new Pessoa(1, "Diego");
        Pessoa p2 = new Pessoa(1, "Carlos");

        assertEquals(p1, p2, "Duas pessoas com o mesmo ID devem ser consideradas iguais.");
    }

    @Test
    public void testPessoasComIdsDiferentesNaoSaoIguais() {
        Pessoa p1 = new Pessoa(1, "Diego");
        Pessoa p2 = new Pessoa(2, "Ana");

        assertNotEquals(p1, p2, "Duas pessoas com IDs diferentes não devem ser consideradas iguais.");
    }

    @Test
    public void testHashCodeConsistenteComEquals() {
        Pessoa p1 = new Pessoa(3, "Marcos");
        Pessoa p2 = new Pessoa(3, "Lucas");

        assertEquals(p1.hashCode(), p2.hashCode(), "Se dois objetos são iguais pelo equals(), seus hashCodes também devem ser iguais.");
    }

    @Test
    public void testPessoaNaoEhIgualANulo() {
        Pessoa p1 = new Pessoa(4, "João");

        assertNotEquals(null, p1, "Uma instância de Pessoa nunca deve ser igual a null.");
    }

    @Test
    public void testPessoaNaoEhIgualAOutroTipoDeObjeto() {
        Pessoa p1 = new Pessoa(5, "Maria");
        String outraCoisa = "Texto aleatório";

        assertNotEquals(p1, outraCoisa, "Um objeto Pessoa não deve ser igual a um objeto de outro tipo.");
    }
}