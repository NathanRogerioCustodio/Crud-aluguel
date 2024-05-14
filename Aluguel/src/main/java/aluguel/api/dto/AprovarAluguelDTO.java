package aluguel.api.dto;

import jakarta.validation.constraints.NotNull;

public record AprovarAluguelDTO(@NotNull Long idAluguel) {
}