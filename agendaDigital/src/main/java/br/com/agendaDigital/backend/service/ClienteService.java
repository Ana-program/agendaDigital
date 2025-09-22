package br.com.agendaDigital.backend.service;

import br.com.agendaDigital.backend.dto.ClienteDTO;
import br.com.agendaDigital.backend.entity.Cliente;
import br.com.agendaDigital.backend.mapper.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.agendaDigital.backend.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    ClienteMapper clienteMapper;

    @Autowired
    private ClienteRepository repository;

    public void registrarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
       repository.save(cliente);
    }


}
