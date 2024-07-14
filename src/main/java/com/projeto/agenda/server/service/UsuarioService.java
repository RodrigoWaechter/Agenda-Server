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

import com.projeto.agenda.server.dao.UsuarioRepository;
import com.projeto.agenda.server.domain.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping(value = "/")
	public String exibirPagina() {
		return "Bem-vindo";
	}
	
	@GetMapping(value = "/buscarTodosUsuarios")
	public List<Usuario> buscarTodos(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping(value = "/buscarUsuario/{id}")
	public Optional<Usuario> buscarPorId(Integer id){
		return usuarioRepository.findById(id);
	}
	
	@PostMapping(value = "/salvarUsuario")
	public String salvar(@RequestBody Usuario usuario) {
		usuarioRepository.save(usuario);
		return usuarioRepository.save(usuario) != null ? "Usuário salvo com sucesso!" : "Erro ao salvar usuário!";
	}
	
	@PutMapping(value = "/atualizarUsuario/{id}")
	public String atualizar(@PathVariable Integer id, @RequestBody Usuario usuario) {
		Usuario usuarioAtualizado = usuarioRepository.findById(id).get();
		usuarioAtualizado.setNomeUsuario(usuario.getNomeUsuario());
		usuarioAtualizado.setSenhaUsuario(usuario.getSenhaUsuario());
		usuarioAtualizado.setData(usuario.getData());
		usuarioRepository.save(usuarioAtualizado);
		return usuarioRepository.save(usuarioAtualizado) != null ? "Usuário atualizado com sucesso!" : "Erro ao atualizar usuário!";
	}
	
	@DeleteMapping(value = "/excluirUsuario/{id}")
	public String excluir(@PathVariable Integer id) {
		Usuario usuarioExcluido = usuarioRepository.findById(id).get();
		usuarioRepository.delete(usuarioExcluido);
		return "Usuário excluído com sucesso!";
	}
	
}