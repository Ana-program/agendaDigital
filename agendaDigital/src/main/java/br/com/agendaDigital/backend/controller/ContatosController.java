package br.com.agendaDigital.backend.controller;

import br.com.agendaDigital.backend.dto.ContatoDTO;
import br.com.agendaDigital.backend.entity.Contato;
import br.com.agendaDigital.backend.service.ContatoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contatos")
public class ContatosController {

    @Autowired
    private ContatoService service;

    @PostMapping("/create/{clienteId}")
    public ResponseEntity<Void> createContato(@PathVariable Integer clienteId, @Valid @RequestBody ContatoDTO contatoDTO){
        service.createContato(clienteId, contatoDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contato> updateContato(@PathVariable Integer id, @Valid @RequestBody ContatoDTO contatoDTO){
        return ResponseEntity.ok(service.updateContato(id, contatoDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteContato(@PathVariable Integer id){
        service.deleteContato(id);
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<List<Contato>> getAllContatosById(@PathVariable Integer clienteId){
        return ResponseEntity.ok(service.getAllContatoById(clienteId));
    }

}
