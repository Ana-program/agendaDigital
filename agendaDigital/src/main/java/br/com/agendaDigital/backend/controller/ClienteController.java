package br.com.agendaDigital.backend.controller;

import br.com.agendaDigital.backend.dto.ClienteDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.agendaDigital.backend.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping("/criar")
    public ResponseEntity<Void> criarCliente(@Valid @RequestBody ClienteDTO clienteDTO){
        service.registrarCliente(clienteDTO);
        return ResponseEntity.ok().build();
    }

}
