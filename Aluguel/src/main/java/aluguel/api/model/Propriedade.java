package aluguel.api.model;


import aluguel.api.dto.CadastroPropriedadeDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "propriedade")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Propriedade {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer idade;

    @Enumerated(EnumType.STRING)
    private TipoPropriedade tipo;

    private Boolean alugado;


    @OneToOne(mappedBy = "propriedade", fetch = FetchType.LAZY)
    private Aluguel aluguel;

    public Propriedade(CadastroPropriedadeDTO dados)
    {
        this.nome = dados.nome();
        this.idade = dados.idade();
        this.tipo = dados.tipo();
        this.alugado = false;
    }

    public void marcarComoAlugado(){
        this.alugado = true;
    }
}
