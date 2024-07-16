package com.projeto.agenda.server.service;

import java.util.List;
import java.util.Optional;

import com.projeto.agenda.server.domain.Cliente;

public interface ClienteService {
	List<Cliente> findAll();

	Optional<Cliente> findById(Integer id);

	Cliente saveCliente(Cliente cliente);

	Cliente updateById(Integer id, Cliente cliente);

	boolean deleteById(Integer id);
}
