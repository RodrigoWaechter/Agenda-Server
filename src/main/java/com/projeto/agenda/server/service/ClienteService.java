package com.projeto.agenda.server.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.projeto.agenda.server.dao.ClienteRepository;
import com.projeto.agenda.server.domain.Cliente;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping(value = "/buscarTodosClientes")
	public List<Cliente> buscarTodos(){
		return clienteRepository.findAll();
	}
	
	@GetMapping(value = "/buscarCliente/{id}")
	public Optional<Cliente> buscarPorId(Integer id){
		return clienteRepository.findById(id);
	}
	
	@PostMapping(value = "/salvarCliente")
	public String salvar(@RequestBody Cliente cliente) {
		clienteRepository.save(cliente);
		return clienteRepository.save(cliente) != null ? "Cliente salvo com sucesso!" : "Erro ao salvar cliente!";
	}
	
	@PutMapping(value = "/atualizarCliente/{id}")
	public String atualizar(@PathVariable Integer id, @RequestBody Cliente cliente) {
		Cliente clienteAtualizado = clienteRepository.findById(id).get();
		clienteAtualizado.setNomeCliente(cliente.getNomeCliente());
		clienteAtualizado.setNascimentoCliente(cliente.getNascimentoCliente());
		clienteAtualizado.setCpfCliente(cliente.getCpfCliente());
		clienteAtualizado.setTelefoneCliente(cliente.getTelefoneCliente());
		clienteRepository.save(clienteAtualizado);
		return clienteRepository.save(clienteAtualizado) != null ? "Cliente atualizado com sucesso!" : "Erro ao atualizar cliente!";
	}
	
	@DeleteMapping(value = "/excluirCliente/{id}")
	public String excluir(@PathVariable Integer id) {
		Cliente clienteExcluido = clienteRepository.findById(id).get();
		clienteRepository.delete(clienteExcluido);
		return "Cliente excluído com sucesso!";
	}
	
	
}