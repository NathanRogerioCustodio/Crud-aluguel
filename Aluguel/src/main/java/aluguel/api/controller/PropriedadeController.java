package aluguel.api.controller;

import aluguel.api.dto.CadastroPropriedadeDTO;
import aluguel.api.dto.PropriedadeDTO;
import aluguel.api.service.PropriedadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("propriedade")
public class PropriedadeController {

    @Autowired
    private PropriedadeService service;

    @GetMapping
    public ResponseEntity<List<PropriedadeDTO>> buscarTodos(){
        List<PropriedadeDTO> pets = service.listarTodos();
        return ResponseEntity.ok(pets);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestBody @Valid CadastroPropriedadeDTO dados){

        try{
            service.cadastrar(dados);
        }catch (IOException ex){
            ResponseEntity.badRequest().body(ex.getMessage());
        }

        return ResponseEntity.ok().build();
    }
}
