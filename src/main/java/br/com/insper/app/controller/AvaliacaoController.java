package br.com.insper.app.controller;

import br.com.insper.app.dto.AvaliacaoRequestDTO;
import br.com.insper.app.dto.AvaliacaoResponseDTO;
import br.com.insper.app.service.AvaliacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AvaliacaoController {

    private final AvaliacaoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AvaliacaoResponseDTO cadastrar(@Valid @RequestBody AvaliacaoRequestDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping
    public List<AvaliacaoResponseDTO> listar() {
        return service.listar();
    }
}