package aluguel.api.service;

import aluguel.api.dto.CadastroPropriedadeDTO;
import aluguel.api.dto.PropriedadeDTO;
import aluguel.api.model.Propriedade;
import aluguel.api.repository.PropriedadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PropriedadeService {

    @Autowired
    private PropriedadeRepository repository;

    @Autowired
    private ImageStorageService imagemService;

    public List<PropriedadeDTO> listarTodos(){
        return repository.findAll().stream().map(PropriedadeDTO::new).toList();
    }

    public void cadastrar(CadastroPropriedadeDTO dto) throws IOException {
        repository.save(new Propriedade(dto));
    }
}
