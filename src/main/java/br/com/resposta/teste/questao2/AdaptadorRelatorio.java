package br.com.resposta.teste.questao2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AdaptadorRelatorio implements GeradorJson {
    private ObjectMapper biblioteca;

    public AdaptadorRelatorio() {
        this.biblioteca = new ObjectMapper(); // Instância de uma biblioteca externa (ela é do spring jackson-databind)
        this.biblioteca.configure(com.fasterxml.jackson.databind.SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    @Override
    public String gerarJson(Object conteudo) {
        try {
            return biblioteca.writeValueAsString(conteudo); // Chama a biblioteca externa (converte o objeto em JSON)
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao gerar JSON", e);
        }
    }

}
