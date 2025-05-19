package br.com.resposta.teste.questao2;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface GeradorJson {

    String gerarJson(Object conteudo) throws JsonProcessingException;

}
