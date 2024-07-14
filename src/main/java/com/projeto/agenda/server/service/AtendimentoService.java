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

import com.projeto.agenda.server.dao.AtendimentoRepository;
import com.projeto.agenda.server.domain.Atendimento;

@Service
public class AtendimentoService {

	@Autowired
	private AtendimentoRepository atendimentoRepository;
	
	@GetMapping(value = "/buscarTodosAtendimentos")
	public List<Atendimento> buscarTodos(){
		return atendimentoRepository.findAll();
	}
	
	@GetMapping(value = "/buscarAtendimento/{id}")
	public Optional<Atendimento> buscarPorId(Integer id){
		return atendimentoRepository.findById(id);
	}
	
	@PostMapping(value = "/salvarAtendimento")
	public String salvar(@RequestBody Atendimento atendimento) {
		atendimentoRepository.save(atendimento);
		return atendimentoRepository.save(atendimento) != null ? "Atendimento salvo com sucesso!" : "Erro ao salvar atendimento!";
	}
	
	@PutMapping(value = "/atualizarAtendimento/{id}")
	public String atualizar(@PathVariable Integer id, @RequestBody Atendimento atendimento) {
		Atendimento atendimentoAtualizado = atendimentoRepository.findById(id).get();
		atendimentoAtualizado.setCliente(atendimento.getCliente());
		atendimentoAtualizado.setServico(atendimento.getServico());
		atendimentoAtualizado.setHorarioInicio(atendimento.getHorarioInicio());
		atendimentoAtualizado.setHorarioFim(atendimento.getHorarioFim());
		atendimentoRepository.save(atendimentoAtualizado);
		return atendimentoRepository.save(atendimentoAtualizado) != null ? "Atendimento atualizado com sucesso!" : "Erro ao atualizar atendimento!";
	}
	
	@DeleteMapping(value = "/excluirAtendimento/{id}")
	public String excluir(@PathVariable Integer id) {
		Atendimento atendimentoExcluido = atendimentoRepository.findById(id).get();
		atendimentoRepository.delete(atendimentoExcluido);
		return "Atendimento excluído com sucesso!";
	}
	
}