package br.com.agendaDigital.backend.mapper;


import br.com.agendaDigital.backend.dto.ContatoDTO;
import br.com.agendaDigital.backend.entity.Contato;
import org.springframework.stereotype.Component;

@Component
public class ContatoMapper {

    public Contato toEntity(ContatoDTO contatoDTO) {
        Contato contato = new Contato();
        contato.setTipo(contatoDTO.getTipo());
        contato.setValor(contatoDTO.getValor());
        contato.setObservacao(contatoDTO.getObservacao());
        return contato;
    }

    public void updateEntityFromDto(ContatoDTO contatoDTO, Contato contato) {
        contato.setTipo(contatoDTO.getTipo());
        contato.setValor(contatoDTO.getValor());
        contato.setObservacao(contatoDTO.getObservacao());
    }
}
