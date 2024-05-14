package aluguel.api.dto;

import aluguel.api.model.Propriedade;
import aluguel.api.model.TipoPropriedade;

public record PropriedadeDTO(Long id, String nome, Integer idade, TipoPropriedade tipo, Boolean adotado) {

    public PropriedadeDTO(Propriedade propriedade){

        this(propriedade.getId(), propriedade.getNome(), propriedade.getIdade(), propriedade.getTipo(), propriedade.getAlugado());
    }
}
