package br.com.insper.app.service;

import br.com.insper.app.dto.AvaliacaoRequestDTO;
import br.com.insper.app.dto.AvaliacaoResponseDTO;
import br.com.insper.app.entity.Avaliacao;
import br.com.insper.app.repository.AvaliacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliacaoService {

    private final AvaliacaoRepository repository;

    public AvaliacaoResponseDTO salvar(AvaliacaoRequestDTO dto) {
        Avaliacao avaliacao = Avaliacao.builder()
                .emailAvaliador(dto.getEmailAvaliador())
                .emailAvaliado(dto.getEmailAvaliado())
                .comentariosAvaliacao(dto.getComentariosAvaliacao())
                .nota(dto.getNota())
                .dataAvaliacao(LocalDateTime.now())
                .build();

        return toDTO(repository.save(avaliacao));
    }

    public List<AvaliacaoResponseDTO> listar() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    private AvaliacaoResponseDTO toDTO(Avaliacao avaliacao) {
        return AvaliacaoResponseDTO.builder()
                .id(avaliacao.getId())
                .emailAvaliador(avaliacao.getEmailAvaliador())
                .emailAvaliado(avaliacao.getEmailAvaliado())
                .comentariosAvaliacao(avaliacao.getComentariosAvaliacao())
                .nota(avaliacao.getNota())
                .dataAvaliacao(avaliacao.getDataAvaliacao())
                .build();
    }
}