package com.projeto.agenda.server.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.agenda.server.domain.Atendimento;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Integer> {

}
