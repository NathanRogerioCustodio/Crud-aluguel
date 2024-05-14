package aluguel.api.service;

import aluguel.api.exception.AluguelException;
import aluguel.api.model.Aluguel;
import aluguel.api.model.Propriedade;
import aluguel.api.model.StatusAluguel;
import aluguel.api.model.Locatario;
import aluguel.api.repository.AluguelRepository;
import aluguel.api.repository.PropriedadeRepository;
import aluguel.api.repository.LocatarioRepository;
import aluguel.api.dto.AluguelDTO;
import aluguel.api.dto.AprovarAluguelDTO;
import aluguel.api.dto.ReprovarAluguelDTO;
import aluguel.api.dto.SolicitacaoDeAluguelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AluguelService {

    @Autowired
    private PropriedadeRepository propriedadeRepository;

    @Autowired
    private LocatarioRepository locatarioRepository;

    @Autowired
    private AluguelRepository aluguelRepository;

    public List<AluguelDTO> listarTodos(){

        return aluguelRepository.findAll().stream().map(AluguelDTO::new).toList();
    }
    public AluguelDTO listar(Long id){

        return aluguelRepository.findById(id).stream().findFirst().map(AluguelDTO::new).orElse(null);
    }

    public void solicitar(SolicitacaoDeAluguelDTO dto){
        Propriedade propriedade = propriedadeRepository.getReferenceById(dto.idPropriedade());
        Locatario locatario = locatarioRepository.getReferenceById(dto.idLocatario());


        if(propriedade.getAlugado()){
            throw new AluguelException("Propriedade alugada");
        }

        Boolean petAdocaoEmAndamento = aluguelRepository.existsByPropriedadeIdAndStatus(dto.idPropriedade(), StatusAluguel.AGUARDANDO_AVALIACAO);

        if(petAdocaoEmAndamento){
            throw new AluguelException("Pet com aluguel em andamento");
        }


        Integer locatarioAlugueis = aluguelRepository.countByLocatarioIdAndStatus(dto.idLocatario(), StatusAluguel.APROVADO);

        if (locatarioAlugueis == 2){
            throw new AluguelException("Locatario com máximo de alugueis");
        }

        aluguelRepository.save(new Aluguel(locatario, propriedade, dto.motivo()));
    }

    public void aprovar(AprovarAluguelDTO dto){
        Aluguel aluguel = aluguelRepository.getReferenceById(dto.idAluguel());
        aluguel.marcarComoAprovada();
        aluguel.getPropriedade().marcarComoAlugado();
    }

    public void reprovar(ReprovarAluguelDTO dto){
        Aluguel aluguel = aluguelRepository.getReferenceById(dto.idAluguel());
        aluguel.marcarComoReprovada(dto.justificativa());
    }
}