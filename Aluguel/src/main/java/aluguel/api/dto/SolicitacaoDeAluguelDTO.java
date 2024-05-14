package aluguel.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SolicitacaoDeAluguelDTO(
        @NotNull
        Long idPropriedade,
        @NotNull
        Long idLocatario,
        @NotBlank
        String motivo
) {
}
