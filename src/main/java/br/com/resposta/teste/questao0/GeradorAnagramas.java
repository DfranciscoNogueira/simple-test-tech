package br.com.resposta.teste.questao0;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GeradorAnagramas {

    public static List<String> gerarAnagramas(String entrada) {

        List<String> resultado = new ArrayList<>();

        if (Objects.isNull(entrada) || entrada.isEmpty() || !entrada.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("A entrada deve ser uma string não vazia contendo apenas letras.");
        }

        gerarAnagramasRecursivo("", entrada, resultado);

        return resultado;
    }

    // Método auxiliar para gerar anagramas de forma recursiva
    private static void gerarAnagramasRecursivo(String prefixo, String restante, List<String> resultado) {

        if (restante.isEmpty()) {
            resultado.add(prefixo);
        } else {
            for (int i = 0; i < restante.length(); i++) {
                gerarAnagramasRecursivo(prefixo + restante.charAt(i), restante.substring(0, i) + restante.substring(i + 1), resultado);
            }
        }

    }

    public static void main(String[] args) {
        String entrada = "abc";
        System.out.println("Anagramas de '" + entrada + "': " + gerarAnagramas(entrada));
    }

}
