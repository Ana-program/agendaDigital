package br.com.agendaDigital.backend.repository;

import br.com.agendaDigital.backend.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {

    List<Contato> findByClienteId(Integer clienteId);
}
