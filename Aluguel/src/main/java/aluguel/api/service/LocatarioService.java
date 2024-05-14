package aluguel.api.service;

import aluguel.api.dto.CadastroLocatarioDTO;
import aluguel.api.dto.LocatarioDTO;
import aluguel.api.model.Locatario;
import aluguel.api.repository.LocatarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocatarioService {

    @Autowired
    private LocatarioRepository repository;

    public List<LocatarioDTO> listarTodos(){
        return repository.findAll().stream().map(LocatarioDTO::new).toList();
    }
    public void cadastrar(CadastroLocatarioDTO dados){
        repository.save(new Locatario(dados));
    }
}
