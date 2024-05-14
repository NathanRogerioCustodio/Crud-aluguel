package aluguel.api.dto;

import aluguel.api.model.Locatario;

public record LocatarioDTO(Long id, String nome, String email) {

    public LocatarioDTO(Locatario locatario){
        this(locatario.getId(), locatario.getNome(), locatario.getEmail());
    }
}
