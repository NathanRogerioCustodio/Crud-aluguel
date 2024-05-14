package aluguel.api.dto;

import aluguel.api.model.Aluguel;
import aluguel.api.model.StatusAluguel;

public record AluguelDTO(Long     id, Long locatario, Long propriedade, String motivo, StatusAluguel status,
                         String justificativa) {
    public AluguelDTO(Aluguel aluguel){
        this(aluguel.getId(), aluguel.getLocatario().getId(), aluguel.getPropriedade().getId(), aluguel.getMotivo(), aluguel.getStatus(), aluguel.getJustificativa());
    }
}
