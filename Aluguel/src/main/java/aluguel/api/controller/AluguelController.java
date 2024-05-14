package aluguel.api.controller;

import aluguel.api.dto.AluguelDTO;
import aluguel.api.dto.AprovarAluguelDTO;
import aluguel.api.dto.ReprovarAluguelDTO;
import aluguel.api.dto.SolicitacaoDeAluguelDTO;
import aluguel.api.service.AluguelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("aluguel")
public class AluguelController {

    @Autowired
    private AluguelService service;

    @GetMapping
    public ResponseEntity<List<AluguelDTO>> buscarTodos(){
        List<AluguelDTO> adocoes = service.listarTodos();
        return ResponseEntity.ok(adocoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AluguelDTO> buscar(@PathVariable Long id){
        AluguelDTO adocao = service.listar(id);
        return ResponseEntity.ok(adocao);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> solicitar(@RequestBody @Valid SolicitacaoDeAluguelDTO dados){
        this.service.solicitar(dados);
        return ResponseEntity.ok("Aluguel solicitado com sucesso!");
    }

    @PutMapping("/aprovar")
    @Transactional
    public ResponseEntity<String> aprovar(@RequestBody @Valid AprovarAluguelDTO dto){
        this.service.aprovar(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/reprovar")
    @Transactional
    public ResponseEntity<String> reprovar(@RequestBody @Valid ReprovarAluguelDTO dto){
        this.service.reprovar(dto);
        return ResponseEntity.ok().build();
    }
}