package aluguel.api.repository;

import aluguel.api.model.Aluguel;
import aluguel.api.model.StatusAluguel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AluguelRepository extends JpaRepository<Aluguel,Long> {
    Boolean existsByPropriedadeIdAndStatus(Long idPropriedade, StatusAluguel statusAluguel);
    Integer countByLocatarioIdAndStatus(Long idLocatario, StatusAluguel status);
}
