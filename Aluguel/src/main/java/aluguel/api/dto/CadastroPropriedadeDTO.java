package aluguel.api.dto;

import aluguel.api.model.TipoPropriedade;
import aluguel.api.model.TamanhoPropriedade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroPropriedadeDTO(
        @NotBlank
        String nome,
        @NotNull
        Integer idade,
        @NotNull
        TipoPropriedade tipo,
        @NotNull
        TamanhoPropriedade tamanho
) {
}
