package br.com.resposta.teste.questao8;

public class PermissaoNegadaException extends RuntimeException {
    public PermissaoNegadaException(String mensagem) {
        super(mensagem);
    }
}