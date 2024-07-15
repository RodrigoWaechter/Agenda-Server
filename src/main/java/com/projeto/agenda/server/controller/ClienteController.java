package com.projeto.agenda.server.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.agenda.server.dao.ClienteRepository;
import com.projeto.agenda.server.domain.Cliente;

/**
 * Controlador REST para operações relacionadas a Clientes.
 */
@RestController
@RequestMapping("/Cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    /**
     * Retorna todos os clientes cadastrados.
     * @return Lista de clientes cadastrados.
     */
    @GetMapping("/findAll")
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    /**
     * Busca um cliente pelo ID.
     * @param id ID do cliente a ser buscado.
     * @return Cliente encontrado (caso exista).
     */
    @GetMapping("/buscarPorId/{id}")
    public Optional<Cliente> findById(@PathVariable Integer id) {
        return clienteRepository.findById(id);
    }

    /**
     * Salva um novo cliente.
     * @param cliente Cliente a ser salvo.
     * @return Mensagem indicando sucesso ou falha na operação de salvamento.
     */
    @PostMapping("/save")
    public String save(@RequestBody Cliente cliente) {
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return clienteSalvo != null ? "Cliente salvo com sucesso!" : "Erro ao salvar cliente!";
    }

    /**
     * Atualiza um cliente pelo ID.
     * @param id ID do cliente a ser atualizado.
     * @param cliente Cliente com os novos dados.
     * @return Mensagem indicando sucesso ou falha na operação de atualização.
     */
    @PutMapping("/updateById/{id}")
    public String updateById(@PathVariable Integer id, @RequestBody Cliente cliente) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);
        if (clienteExistente.isPresent()) {
            Cliente clienteAtualizado = clienteExistente.get();
            clienteAtualizado.setNomeCliente(cliente.getNomeCliente());
            clienteAtualizado.setNascimentoCliente(cliente.getNascimentoCliente());
            clienteAtualizado.setCpfCliente(cliente.getCpfCliente());
            clienteAtualizado.setTelefoneCliente(cliente.getTelefoneCliente());
            clienteRepository.save(clienteAtualizado);
            return "Cliente atualizado com sucesso!";
        } else {
            return "Cliente não encontrado!";
        }
    }

    /**
     * Exclui um cliente pelo ID.
     * @param id ID do cliente a ser excluído.
     * @return Mensagem indicando sucesso na exclusão ou falha se o cliente não for encontrado.
     */
    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable Integer id) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);
        if (clienteExistente.isPresent()) {
            clienteRepository.delete(clienteExistente.get());
            return "Cliente excluído com sucesso!";
        } else {
            return "Cliente não encontrado!";
        }
    }
}
