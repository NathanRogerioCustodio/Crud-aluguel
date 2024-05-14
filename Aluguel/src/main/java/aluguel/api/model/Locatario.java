package aluguel.api.model;

import aluguel.api.dto.CadastroLocatarioDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "locatario")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Locatario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    @OneToMany(mappedBy = "locatario")
    private List<Aluguel> adocoes = new ArrayList<>();

    public Locatario(CadastroLocatarioDTO dados){
        this.nome = dados.nome();
        this.email = dados.email();
    }

}
