package com.projeto.agenda.server.dao;

import com.projeto.agenda.server.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginBeanRepository extends JpaRepository<Usuario, Long> {
    // Métodos adicionais podem ser definidos aqui, se necessário
}
