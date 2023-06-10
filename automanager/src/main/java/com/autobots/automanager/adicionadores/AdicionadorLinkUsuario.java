package com.autobots.automanager.adicionadores;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controles.UsuarioControle;
import com.autobots.automanager.entitades.Usuario;

@Component
public class AdicionadorLinkUsuario implements AdicionadorLink<Usuario> {

	@Override
	public void adicionarLink(List<Usuario> lista) {
		for (Usuario usuario : lista) {
			long id = usuario.getId();
			Link linkProprioObterUsuario = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(UsuarioControle.class)
							.obterUsuario(id))
					.withSelfRel();
			usuario.add(linkProprioObterUsuario);
			
			Link linkProprioObterUsuarios = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(UsuarioControle.class)
							.obterUsuarios())
					.withSelfRel();
			usuario.add(linkProprioObterUsuarios);
			
			Link linkProprioCadastrarUsuario = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(UsuarioControle.class)
							.cadastrarUsuario(usuario, id))
					.withSelfRel();
			usuario.add(linkProprioCadastrarUsuario);
			
			Link linkProprioAtualizarUsuario = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(UsuarioControle.class)
							.atualizarUsuario(usuario))
					.withSelfRel();
			usuario.add(linkProprioAtualizarUsuario);
			
			Link linkProprioExcluirUsuario = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(UsuarioControle.class)
							.excluirUsuario(usuario, id))
					.withSelfRel();
			usuario.add(linkProprioExcluirUsuario);	
			
		}
	}

	@Override
	public void adicionarLink(Usuario objeto) {
		Link linkProprioObterUsuario = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(UsuarioControle.class)
						.obterUsuario(objeto.getId()))
				.withRel("usuario");
		objeto.add(linkProprioObterUsuario);
		
		Link linkProprioObterUsuarios = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(UsuarioControle.class)
						.obterUsuarios())
				.withRel("usuarios");
		objeto.add(linkProprioObterUsuarios);
		
		Link linkProprioCadastrarUsuario = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(UsuarioControle.class)
						.cadastrarUsuario(objeto, id))
				.withRel("cadastrar");
		objeto.add(linkProprioCadastrarUsuario);
		
		Link linkProprioAtualizarUsuario = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(UsuarioControle.class)
						.atualizarUsuario(objeto))
				.withRel("atualizar");
		objeto.add(linkProprioAtualizarUsuario);
		
		Link linkProprioExcluirUsuario = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(UsuarioControle.class)
						.excluirUsuario(objeto, id))
				.withRel("excluir");
		objeto.add(linkProprioExcluirUsuario);
		
	}
}
