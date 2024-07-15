package com.projeto.agenda.server;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.projeto.agenda.server.dao.ClienteRepository;

@SpringBootTest
class ServerApplicationTests {


    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void contextLoads() throws Exception {
    	//assertNull(clienteRepository);
    }

}
