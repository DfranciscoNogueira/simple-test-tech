package br.com.resposta.teste.questao7;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    @Autowired
    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public String salvarVeiculo(String codigo, String descricao) {

        if (!codigo.matches("\\d+")) {
            return "O código deve ser numérico e obrigatório.";
        }

        if (veiculoRepository.existsByCode(codigo)) {
            return "Código já existe.";
        }

        if (Objects.nonNull(descricao) && descricao.length() > 10) {
            return "A descrição deve ter no máximo 10 caracteres.";
        }

        Veiculo veiculo = new Veiculo(codigo, Objects.nonNull(descricao) ? descricao : "");
        veiculoRepository.save(veiculo);

        return "Veículo cadastrado com sucesso.";
    }

    public Optional<Veiculo> getVeiculo(Long id) {
        return veiculoRepository.findById(id);
    }

}


