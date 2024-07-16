package com.projeto.agenda.server.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.agenda.server.dao.ClienteRepository;
import com.projeto.agenda.server.domain.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Integer id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateById(Integer id, Cliente cliente) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);
        if (clienteExistente.isPresent()) {
            Cliente clienteAtualizado = clienteExistente.get();
            clienteAtualizado.setNomeCliente(cliente.getNomeCliente());
            clienteAtualizado.setNascimentoCliente(cliente.getNascimentoCliente());
            clienteAtualizado.setCpfCliente(cliente.getCpfCliente());
            clienteAtualizado.setTelefoneCliente(cliente.getTelefoneCliente());
            return clienteRepository.save(clienteAtualizado);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);
        if (clienteExistente.isPresent()) {
            clienteRepository.delete(clienteExistente.get());
            return true;
        } else {
            return false;
        }
    }
}
