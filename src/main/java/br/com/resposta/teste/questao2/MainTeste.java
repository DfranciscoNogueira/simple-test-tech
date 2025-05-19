package br.com.resposta.teste.questao2;

import com.fasterxml.jackson.core.JsonProcessingException;

public class MainTeste {

    /**
     *
     * EXPLICACAO:
     *
     * Quando há a possibilidade de substituir uma biblioteca externa no futuro, um padrão de design útil para desacoplar o código é o Adapter Pattern
     * (Padrão Adaptador). Esse padrão permite que o código da aplicação interaja com uma interface intermediária, em vez de depender diretamente da
     * biblioteca externa. Assim, caso a biblioteca seja substituída, apenas o adaptador precisará ser modificado, sem impactar o restante do sistema.
     *
     */
    public static void main(String[] args) throws JsonProcessingException {

        // Criação de um objeto de exemplo
        Relatorio relatorio = new Relatorio("Relatório de Teste", "Este é um relatório de teste.");

        // Criação do adaptador
        GeradorJson adaptador = new AdaptadorRelatorio();

        // Geração do JSON
        String json = adaptador.gerarJson(relatorio);

        // Exibição do JSON gerado
        System.out.println(json);

    }
}
