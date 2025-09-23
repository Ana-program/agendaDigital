package br.com.agendaDigital.backend.service;

import br.com.agendaDigital.backend.dto.ClienteDTO;
import br.com.agendaDigital.backend.entity.Cliente;
import br.com.agendaDigital.backend.exception.ClienteException;
import br.com.agendaDigital.backend.mapper.ClienteMapper;
import br.com.agendaDigital.backend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteMapper clienteMapper;

    @Autowired
    private ClienteRepository repository;

    public void createCliente(Cliente cliente) {
       repository.save(cliente);
    }

    public Cliente updateCliente(Integer id, ClienteDTO clienteDTO) {
        Cliente cliente = repository.findById(id).orElseThrow(() -> new ClienteException("Cliente não encontrado"));
        clienteMapper.updateCliente(clienteDTO, cliente);
        return repository.save(cliente);
    }

    public void deleteCliente(Integer id) {
        repository.deleteById(id);
    }

    public List<Cliente> findAllCliente() {
        return repository.findAll();
    }

    public List<Cliente> findClienteByNomeOrCpf(String nome, String cpf) {
        if (cpf != null && !cpf.isBlank()){
            return repository.findByCpf(cpf);
        }
        if (nome != null && !nome.isBlank()){
            return repository.findByNome(nome);
        }
        return repository.findAll();
    }

}
