package br.com.agendaDigital.backend.controller;

import br.com.agendaDigital.backend.dto.ClienteDTO;
import br.com.agendaDigital.backend.entity.Cliente;
import br.com.agendaDigital.backend.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Integer id, @RequestBody ClienteDTO clienteDTO){
        return ResponseEntity.ok(service.updateCliente(id, clienteDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Integer id){
        service.deleteCliente(id);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Cliente>> findAllCliente(){
        return ResponseEntity.ok( service.findAllCliente());
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> findCliente(@RequestParam(required = false) String nome,
                                                     @RequestParam(required = false) String cpf){
        List<Cliente> result = service.findClienteByNomeOrCpf(nome, cpf);

        if (result.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result);
    }

}
