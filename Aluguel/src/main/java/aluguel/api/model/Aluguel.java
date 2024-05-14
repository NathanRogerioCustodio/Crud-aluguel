package aluguel.api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "aluguel")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Locatario locatario;

    @OneToOne(fetch = FetchType.LAZY)
    private Propriedade propriedade;

    private String motivo;

    @Enumerated(EnumType.STRING)
    private StatusAluguel status;

    private String justificativa;

    public Aluguel(Locatario locatario, Propriedade propriedade, String motivo){
        this.locatario = locatario;
        this.propriedade = propriedade;
        this.motivo = motivo;
        this.status = StatusAluguel.AGUARDANDO_AVALIACAO;
    }

    public void marcarComoAprovada(){

        this.status = StatusAluguel.APROVADO;
    }

    public void marcarComoReprovada(String justificativa)
    {
        this.status = StatusAluguel.REPROVADO;
        this.justificativa = justificativa;
    }
}
