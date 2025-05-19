package br.com.resposta.teste.questao2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AdaptadorRelatorioTest {

    @Test
    void testGerarJsonComObjetoComplexo() {

        AdaptadorRelatorio adaptador = new AdaptadorRelatorio();
        Produto produto = new Produto(101, "Notebook", 3999.99);

        String jsonGerado = adaptador.gerarJson(produto);

        assertTrue(jsonGerado.contains("\"id\":101"), "O JSON gerado deve conter o ID do produto.");
        assertTrue(jsonGerado.contains("\"nome\":\"Notebook\""), "O JSON gerado deve conter o nome do produto.");
        assertTrue(jsonGerado.contains("\"preco\":3999.99"), "O JSON gerado deve conter o preço do produto.");

    }
}