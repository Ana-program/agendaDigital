package br.com.agendaDigital.backend.repository;

import br.com.agendaDigital.backend.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByCpf(String cpf);

    List<Cliente> findByNome(String nome);

}
