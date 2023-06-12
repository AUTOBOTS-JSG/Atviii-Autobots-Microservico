package com.autobots.automanager.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.adicionadores.AdicionadorLinkCredencialUsuarioSenha;
import com.autobots.automanager.atualizadores.CredencialUsuarioSenhaAtualizador;
import com.autobots.automanager.entitades.Credencial;
import com.autobots.automanager.entitades.CredencialUsuarioSenha;
import com.autobots.automanager.repositorios.CredencialUsuarioSenhaRepositorio;
import com.autobots.automanager.selecionadores.CredencialUsuarioSenhaSelecionador;

@RestController
@RequestMapping("/credencialUsuarioSenha")
public class CredencialUsuarioSenhaControle {
	@Autowired
	private CredencialUsuarioSenhaRepositorio repositorioCredencialUsuarioSenha;
	@Autowired
	private CredencialUsuarioSenhaSelecionador selecionadorCredencialUsuarioSenha;
	@Autowired
	private AdicionadorLinkCredencialUsuarioSenha adicionadorLinkCredencialUsuarioSenha;

	@GetMapping("/credencialUsuarioSenha/{id}")
	public ResponseEntity<CredencialUsuarioSenha> obterCredencialUsuarioSenha(@PathVariable long id) {
		List<CredencialUsuarioSenha> credenciaisUsuariosSenhas = repositorioCredencialUsuarioSenha.findAll();
		CredencialUsuarioSenha credencialUsuarioSenha = selecionadorCredencialUsuarioSenha.selecionar(credenciaisUsuariosSenhas, id);
		if (credencialUsuarioSenha == null) {
			ResponseEntity<CredencialUsuarioSenha> resposta = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return resposta;
		} else {
			adicionadorLinkCredencialUsuarioSenha.adicionarLink(credencialUsuarioSenha);
			ResponseEntity<CredencialUsuarioSenha> resposta = new ResponseEntity<CredencialUsuarioSenha>(credencialUsuarioSenha, HttpStatus.FOUND);
			return resposta;
		} 
	}

	@GetMapping("/credenciaisUsuariosSenhas")
	public ResponseEntity<List<CredencialUsuarioSenha>> obterCredenciaisUsuariosSenhas() {
		List<CredencialUsuarioSenha> credenciaisUsuariosSenhas = repositorioCredencialUsuarioSenha.findAll();
		if (credenciaisUsuariosSenhas.isEmpty()) {
			ResponseEntity<List<CredencialUsuarioSenha>> resposta = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return resposta;
		} else {
			adicionadorLinkCredencialUsuarioSenha.adicionarLink(credenciaisUsuariosSenhas);
			ResponseEntity<List<CredencialUsuarioSenha>> resposta = new ResponseEntity<>(credenciaisUsuariosSenhas, HttpStatus.FOUND);
			return resposta;
		}
	}

	@PostMapping("/cadastro") 
	public ResponseEntity<?> cadastrarCredencialUsuarioSenha(@RequestBody CredencialUsuarioSenha credencialUsuarioSenha, @PathVariable long id) {
		HttpStatus status = HttpStatus.CONFLICT;
		if (credencialUsuarioSenha.getId() == null) {
		    repositorioCredencialUsuarioSenha.save(credencialUsuarioSenha);
			status = HttpStatus.CREATED;
		}
		return new ResponseEntity<>(status);

	}
	
	@PutMapping("/atualizar") 
	public ResponseEntity<?> atualizarCredencialUsuarioSenha(@RequestBody CredencialUsuarioSenha atualizacao) {
		HttpStatus status = HttpStatus.CONFLICT;
		CredencialUsuarioSenha credencialUsuarioSenha = repositorioCredencialUsuarioSenha.getById(atualizacao.getId());
		if (credencialUsuarioSenha != null) {
			CredencialUsuarioSenhaAtualizador atualizador = new CredencialUsuarioSenhaAtualizador();
			atualizador.atualizar(credencialUsuarioSenha, atualizacao);
			repositorioCredencialUsuarioSenha.save(credencialUsuarioSenha);
			status = HttpStatus.OK;
		} else {
			status = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<>(status);
		
	}

	@DeleteMapping("/excluir")
	public ResponseEntity<?> excluirCredencialUsuarioSenha(@RequestBody Credencial exclusao, @PathVariable long id) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		CredencialUsuarioSenha credencialUsuarioSenha = repositorioCredencialUsuarioSenha.getById(exclusao.getId());
		if (credencialUsuarioSenha != null) {
			repositorioCredencialUsuarioSenha.save(credencialUsuarioSenha);
			status = HttpStatus.OK;
		}
		return new ResponseEntity<>(status);
		
	}
}
