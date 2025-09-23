package br.com.agendaDigital.backend.dto;

import br.com.agendaDigital.backend.enums.TipoContato;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ContatoDTO {

    private String valor;
    private String observacao;
    private TipoContato tipo;

}
