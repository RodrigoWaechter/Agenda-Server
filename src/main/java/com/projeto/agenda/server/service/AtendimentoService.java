package com.projeto.agenda.server.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.projeto.agenda.server.dao.AtendimentoRepository;
import com.projeto.agenda.server.domain.Atendimento;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AtendimentoService {
	
	@Autowired
	private AtendimentoRepository atendimentoRepository;

	public List<Atendimento> findAll() {
		return atendimentoRepository.findAll();
	}

	public Optional<Atendimento> findById(@PathVariable Integer id) {
		return atendimentoRepository.findById(id);
	}

	public Atendimento save(Atendimento atendimento) {
		return atendimentoRepository.save(atendimento);
	}

	public Atendimento update(Integer id, Atendimento atendimento) {
		Optional<Atendimento> atendimentoExistente = atendimentoRepository.findById(id);
		if (atendimentoExistente.isPresent()) {
			Atendimento atendimentoAtualizado = atendimentoExistente.get();
			atendimentoAtualizado.setCliente(atendimento.getCliente());
			atendimentoAtualizado.setServico(atendimento.getServico());
			atendimentoAtualizado.setHorarioInicio(atendimento.getHorarioInicio());
			atendimentoAtualizado.setHorarioFim(atendimento.getHorarioFim());
			return atendimentoRepository.save(atendimentoAtualizado);
		} else {
			throw new EntityNotFoundException();
		}

	}

	public boolean deleteById(Integer id) {
		Optional<Atendimento> atendimentoExistente = atendimentoRepository.findById(id);
		if (atendimentoExistente.isPresent()) {
			atendimentoRepository.delete(atendimentoExistente.get());
			return true;
		} else {
			return false;
		}
	}

}
