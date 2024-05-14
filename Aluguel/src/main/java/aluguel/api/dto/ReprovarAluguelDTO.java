package aluguel.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ReprovarAluguelDTO(
        @NotNull Long idAluguel,
        @NotBlank String justificativa
) {
}
