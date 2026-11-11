package br.com.insper.app.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "avaliacoes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String emailAvaliador;

    @Column(nullable = false)
    private String emailAvaliado;

    @Column(length = 1000)
    private String comentariosAvaliacao;

    @Column(nullable = false)
    private Integer nota; // 0 a 10

    @Column(nullable = false)
    private LocalDateTime dataAvaliacao;
}