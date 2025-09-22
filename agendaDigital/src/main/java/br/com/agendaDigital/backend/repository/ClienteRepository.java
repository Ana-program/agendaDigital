package br.com.agendaDigital.backend.repository;

import br.com.agendaDigital.backend.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
