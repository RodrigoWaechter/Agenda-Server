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

import com.projeto.agenda.server.dao.AtendimentoRepository;
import com.projeto.agenda.server.domain.Atendimento;
import com.projeto.agenda.server.domain.Cliente;
import com.projeto.agenda.server.service.AtendimentoService;

/**
 * Controlador REST para operações relacionadas a Atendimentos.
 */
@RestController
@RequestMapping("/Atendimento")
public class AtendimentoController {

	@Autowired
	private AtendimentoService service;

	/**
	 * Retorna todos os atendimentos cadastrados.
	 * 
	 * @return Lista de atendimentos cadastrados.
	 */
	@GetMapping(value = "/findAll")
	public List<Atendimento> findAll() {
		return service.findAll();
	}

	/**
	 * Busca um atendimento pelo ID.
	 * 
	 * @param id ID do atendimento a ser buscado.
	 * @return Atendimento encontrado (caso exista).
	 */
	@GetMapping(value = "/findById/{id}")
	public Optional<Atendimento> findById(@PathVariable Integer id) {
		return service.findById(id);
	}

	/**
	 * Salva um novo atendimento.
	 * 
	 * @param atendimento Atendimento a ser salvo.
	 * @return Mensagem indicando sucesso ou falha na operação de salvamento.
	 */
	@PostMapping(value = "/save")
	public ResponseEntity<Atendimento> save(@RequestBody Atendimento atendimento) {
		Atendimento save = service.save(atendimento);
		return ResponseEntity.ok(save);
	}

	/**
	 * Atualiza um atendimento pelo ID.
	 * 
	 * @param id          ID do atendimento a ser atualizado.
	 * @param atendimento Atendimento com os novos dados.
	 * @return Mensagem indicando sucesso ou falha na operação de atualização.
	 */
	@PutMapping(value = "/updateById/{id}")
	public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody Atendimento atendimento) {
		Atendimento atendimentoUpdate = service.update(id, atendimento);
		if (atendimentoUpdate != null) {
			return ResponseEntity.ok("Atendimento atualizado com sucesso!");
		} else {
			return ResponseEntity.status(404).body("Atendimento não encontrado!");
		}

	}

	/**
	 * Exclui um atendimento pelo ID.
	 * 
	 * @param id ID do atendimento a ser excluído.
	 * @return Mensagem indicando sucesso na exclusão.
	 */
	@DeleteMapping(value = "/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id) {
		boolean deleted = service.deleteById(id);
		if (deleted) {
			return ResponseEntity.ok("Cliente excluído com sucesso!");
		} else {
			return ResponseEntity.status(404).body("Cliente não encontrado!");

		}
	}
}
