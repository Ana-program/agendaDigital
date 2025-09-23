package br.com.agendaDigital.backend.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ClienteDTO {

    private String nome;
    private String endereco;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
}
