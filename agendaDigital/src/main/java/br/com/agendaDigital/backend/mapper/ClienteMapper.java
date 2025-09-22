package br.com.agendaDigital.backend.mapper;

import br.com.agendaDigital.backend.dto.ClienteDTO;
import br.com.agendaDigital.backend.entity.Cliente;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ClienteMapper {

    public Cliente toEntity(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setEndereco(clienteDTO.getEndereco());
        cliente.setDataNascimento(clienteDTO.getDataNascimento());
        cliente.setContatos(new ArrayList<>());
        return cliente;
    }
}
