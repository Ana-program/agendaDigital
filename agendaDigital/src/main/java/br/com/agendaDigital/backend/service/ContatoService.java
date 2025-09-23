package br.com.agendaDigital.backend.service;

import br.com.agendaDigital.backend.dto.ContatoDTO;
import br.com.agendaDigital.backend.entity.Cliente;
import br.com.agendaDigital.backend.entity.Contato;
import br.com.agendaDigital.backend.exception.ClienteException;
import br.com.agendaDigital.backend.mapper.ContatoMapper;
import br.com.agendaDigital.backend.repository.ClienteRepository;
import br.com.agendaDigital.backend.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ContatoMapper contatoMapper;

    public void createContato(Integer clienteId, ContatoDTO contatoDTO) {
        Contato contato = contatoMapper.toEntity(contatoDTO);
        Cliente result =  clienteRepository.findById(clienteId).orElseThrow(() -> new ClienteException("Cliente não encontrado!"));
        contato.setCliente(result);
        repository.save(contato);
    }

    public Contato updateContato(Integer id, ContatoDTO contatoDTO) {
        Contato contato = repository.findById(id).orElseThrow(() -> new ClienteException("Contato não encontrado"));;
        contatoMapper.updateEntityFromDto(contatoDTO, contato);
        return repository.save(contato);
    }

    public void deleteContato(Integer id) {
        repository.deleteById(id);
    }

    public List<Contato> getAllContatoById(Integer clienteId) {
        clienteRepository.findById(clienteId).orElseThrow(() -> new ClienteException("Cliente não encontrado!"));
        return repository.findByClienteId(clienteId);
    }
}
