package aluguel.api.dto;

import jakarta.validation.constraints.NotBlank;

public record CadastroLocatarioDTO(
        @NotBlank
        String nome,

        @NotBlank
        String email
) {
}
