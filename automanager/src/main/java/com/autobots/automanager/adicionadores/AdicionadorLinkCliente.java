package com.autobots.automanager.adicionadores;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controles.ClienteControle;
import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entitades.Usuario;

@Component
public class AdicionadorLinkUsuario implements AdicionadorLink<Usuario> {

	@Override
	public void adicionarLink(List<Usuario> lista) {
		for (Usuario usuario : lista) {
			long id = cliente.getId();
			Link linkProprioObterUsuario = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(UsuarioControle.class)
							.obterUsuario(id))
					.withSelfRel();
			usuario.add(linkProprioObterUsuario);
			
			Link linkProprioObterClientes = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(ClienteControle.class)
							.obterClientes())
					.withSelfRel();
			cliente.add(linkProprioObterClientes);
			
			Link linkProprioCadastrarCliente = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(ClienteControle.class)
							.cadastrarCliente(cliente))
					.withSelfRel();
			cliente.add(linkProprioCadastrarCliente);
			
			Link linkProprioAtualizarCliente = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(ClienteControle.class)
							.atualizarCliente(cliente))
					.withSelfRel();
			cliente.add(linkProprioAtualizarCliente);
			
			Link linkProprioExcluirCliente = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(ClienteControle.class)
							.excluirCliente(cliente))
					.withSelfRel();
			cliente.add(linkProprioExcluirCliente);	
			
		}
	}

	@Override
	public void adicionarLink(Cliente objeto) {
		Link linkProprioObterCliente = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(ClienteControle.class)
						.obterCliente(objeto.getId()))
				.withRel("cliente");
		objeto.add(linkProprioObterCliente);
		
		Link linkProprioObterClientes = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(ClienteControle.class)
						.obterClientes())
				.withRel("clientes");
		objeto.add(linkProprioObterClientes);
		
		Link linkProprioCadastrarCliente = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(ClienteControle.class)
						.cadastrarCliente(objeto))
				.withRel("cadastrar");
		objeto.add(linkProprioCadastrarCliente);
		
		Link linkProprioAtualizarCliente = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(ClienteControle.class)
						.atualizarCliente(objeto))
				.withRel("atualizar");
		objeto.add(linkProprioAtualizarCliente);
		
		Link linkProprioExcluirCliente = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(ClienteControle.class)
						.excluirCliente(objeto))
				.withRel("excluir");
		objeto.add(linkProprioExcluirCliente);
		
	}
}
