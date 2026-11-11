package br.com.insper.app.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoRequestDTO {

    @NotBlank
    @Email
    private String emailAvaliador;

    @NotBlank
    @Email
    private String emailAvaliado;

    // aceita "comentariosAvaliacao" (nome do enunciado) e tambem "comentarios"
    @JsonAlias("comentarios")
    private String comentariosAvaliacao;

    @NotNull
    @Min(0)
    @Max(10)
    private Integer nota;
}