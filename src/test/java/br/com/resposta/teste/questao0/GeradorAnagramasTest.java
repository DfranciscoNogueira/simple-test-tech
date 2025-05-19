package br.com.resposta.teste.questao0;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GeradorAnagramasTest {

    @Test
    void testGerarAnagramasEntradaValida() {
        List<String> anagramas = GeradorAnagramas.gerarAnagramas("abc");
        assertEquals(6, anagramas.size());
        assertTrue(anagramas.contains("abc"));
        assertTrue(anagramas.contains("acb"));
        assertTrue(anagramas.contains("bac"));
        assertTrue(anagramas.contains("bca"));
        assertTrue(anagramas.contains("cab"));
        assertTrue(anagramas.contains("cba"));
    }

    @Test
    void testGerarAnagramasUnicaLetra() {
        List<String> anagramas = GeradorAnagramas.gerarAnagramas("a");
        assertEquals(1, anagramas.size());
        assertTrue(anagramas.contains("a"));
    }

    @Test
    void testGerarAnagramasEntradaInvalida() {
        assertThrows(IllegalArgumentException.class, () -> GeradorAnagramas.gerarAnagramas(""));
        assertThrows(IllegalArgumentException.class, () -> GeradorAnagramas.gerarAnagramas("123"));
        assertThrows(IllegalArgumentException.class, () -> GeradorAnagramas.gerarAnagramas(null));
    }

}