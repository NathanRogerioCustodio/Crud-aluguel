package aluguel.api.controller;


import aluguel.api.dto.CadastroLocatarioDTO;
import aluguel.api.dto.LocatarioDTO;
import aluguel.api.service.LocatarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locatario")
public class LocatarioController {

    @Autowired
    private LocatarioService service;

    @GetMapping
    public ResponseEntity<List<LocatarioDTO>> buscarTodos(){
        List<LocatarioDTO> locatario = service.listarTodos();
        return ResponseEntity.ok(locatario);
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid CadastroLocatarioDTO dados){

        this.service.cadastrar(dados);
    }


}
