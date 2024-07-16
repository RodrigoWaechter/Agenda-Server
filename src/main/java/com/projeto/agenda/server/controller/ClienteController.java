package com.projeto.agenda.server.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.agenda.server.domain.Cliente;
import com.projeto.agenda.server.service.ClienteService;

/**
 * Controlador REST para operações relacionadas a Clientes.
 */
@RestController
@RequestMapping("/Cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    /**
     * Retorna todos os clientes cadastrados.
     * @return Lista de clientes cadastrados.
     */
    @GetMapping("/findAll")
    public List<Cliente> findAll() {
        return clienteService.findAll();
    }

    /**
     * Busca um cliente pelo ID.
     * @param id ID do cliente a ser buscado.
     * @return Cliente encontrado (caso exista).
     */
    @GetMapping("/buscarPorId/{id}")
    public Optional<Cliente> findById(@PathVariable Integer id) {
        return clienteService.findById(id);
    }

    /**
     * Salva um novo cliente.
     * @param cliente Cliente a ser salvo.
     * @return Cliente salvo.
     */
    @PostMapping("/save")
    public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente) {
        Cliente savedCliente = clienteService.saveCliente(cliente);
        return ResponseEntity.ok(savedCliente);
    }

    /**
     * Atualiza um cliente pelo ID.
     * @param id ID do cliente a ser atualizado.
     * @param cliente Cliente com os novos dados.
     * @return Mensagem indicando sucesso ou falha na operação de atualização.
     */
    @PutMapping("/updateById/{id}")
    public ResponseEntity<String> updateById(@PathVariable Integer id, @RequestBody Cliente cliente) {
        Cliente updatedCliente = clienteService.updateById(id, cliente);
        if (updatedCliente != null) {
            return ResponseEntity.ok("Cliente atualizado com sucesso!");
        } else {
            return ResponseEntity.status(404).body("Cliente não encontrado!");
        }
    }

    /**
     * Exclui um cliente pelo ID.
     * @param id ID do cliente a ser excluído.
     * @return Mensagem indicando sucesso na exclusão ou falha se o cliente não for encontrado.
     */
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        boolean deleted = clienteService.deleteById(id);
        if (deleted) {
            return ResponseEntity.ok("Cliente excluído com sucesso!");
        } else {
            return ResponseEntity.status(404).body("Cliente não encontrado!");
        }
    }
}
