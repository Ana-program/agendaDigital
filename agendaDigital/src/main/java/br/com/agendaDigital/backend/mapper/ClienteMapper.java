package br.com.agendaDigital.backend.mapper;

import br.com.agendaDigital.backend.dto.ClienteDTO;
import br.com.agendaDigital.backend.entity.Cliente;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class ClienteMapper {

    public void updateCliente(ClienteDTO clienteDTO, Cliente cliente) {
        Optional.ofNullable(clienteDTO.getNome()).ifPresent(cliente::setNome);
        Optional.ofNullable(clienteDTO.getEndereco()).ifPresent(cliente::setEndereco);
        Optional.ofNullable(clienteDTO.getDataNascimento()).ifPresent(cliente::setDataNascimento);
    }
}
