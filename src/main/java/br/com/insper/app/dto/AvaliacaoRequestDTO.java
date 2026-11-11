package br.com.insper.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoRequestDTO {
    private String emailAvaliador;
    private String emailAvaliado;
    private String comentarios;
    private Integer nota;
}