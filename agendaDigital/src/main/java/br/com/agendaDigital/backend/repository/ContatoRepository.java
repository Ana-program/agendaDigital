package br.com.agendaDigital.backend.repository;

import br.com.agendaDigital.backend.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {
}
