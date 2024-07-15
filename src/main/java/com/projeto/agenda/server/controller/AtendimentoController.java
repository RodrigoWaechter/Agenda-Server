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

import com.projeto.agenda.server.dao.AtendimentoRepository;
import com.projeto.agenda.server.domain.Atendimento;

/**
 * Controlador REST para operações relacionadas a Atendimentos.
 */
@RestController
@RequestMapping("/Atendimento")
public class AtendimentoController {

    @Autowired
    private AtendimentoRepository atendimentoRepository;
    
    /**
     * Retorna todos os atendimentos cadastrados.
     * @return Lista de atendimentos cadastrados.
     */
    @GetMapping(value = "/findAll")
    public List<Atendimento> findAll(){
        return atendimentoRepository.findAll();
    }
    
    /**
     * Busca um atendimento pelo ID.
     * @param id ID do atendimento a ser buscado.
     * @return Atendimento encontrado (caso exista).
     */
    @GetMapping(value = "/findById/{id}")
    public Optional<Atendimento> findById(@PathVariable Integer id){
        return atendimentoRepository.findById(id);
    }
    
    /**
     * Salva um novo atendimento.
     * @param atendimento Atendimento a ser salvo.
     * @return Mensagem indicando sucesso ou falha na operação de salvamento.
     */
    @PostMapping(value = "/save")
    public String save(@RequestBody Atendimento atendimento) {
        atendimentoRepository.save(atendimento);
        return atendimentoRepository.save(atendimento) != null ? "Atendimento salvo com sucesso!" : "Erro ao salvar atendimento!";
    }
    
    /**
     * Atualiza um atendimento pelo ID.
     * @param id ID do atendimento a ser atualizado.
     * @param atendimento Atendimento com os novos dados.
     * @return Mensagem indicando sucesso ou falha na operação de atualização.
     */
    @PutMapping(value = "/updateById/{id}")
    public String update(@PathVariable Integer id, @RequestBody Atendimento atendimento) {
        Atendimento atendimentoAtualizado = atendimentoRepository.findById(id).get();
        atendimentoAtualizado.setCliente(atendimento.getCliente());
        atendimentoAtualizado.setServico(atendimento.getServico());
        atendimentoAtualizado.setHorarioInicio(atendimento.getHorarioInicio());
        atendimentoAtualizado.setHorarioFim(atendimento.getHorarioFim());
        atendimentoRepository.save(atendimentoAtualizado);
        return atendimentoRepository.save(atendimentoAtualizado) != null ? "Atendimento atualizado com sucesso!" : "Erro ao atualizar atendimento!";
    }
    
    /**
     * Exclui um atendimento pelo ID.
     * @param id ID do atendimento a ser excluído.
     * @return Mensagem indicando sucesso na exclusão.
     */
    @DeleteMapping(value = "/deleteById/{id}")
    public String deleteById(@PathVariable Integer id) {
        Atendimento atendimentoExcluido = atendimentoRepository.findById(id).get();
        atendimentoRepository.delete(atendimentoExcluido);
        return "Atendimento excluído com sucesso!";
    }
}
