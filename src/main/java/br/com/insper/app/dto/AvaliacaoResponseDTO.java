package br.com.insper.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoResponseDTO {
    private Long id;
    private String emailAvaliador;
    private String emailAvaliado;
    private String comentariosAvaliacao;
    private Integer nota;
    private LocalDateTime dataAvaliacao;
}