package com.autobots.automanager.adicionadores;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controles.EnderecoControle;
import com.autobots.automanager.entitades.Endereco;

@Component
public class AdicionadorLinkEndereco implements AdicionadorLink<Endereco> {

	@Override
	public void adicionarLink(List<Endereco> lista) {
		for (Endereco endereco : lista) {
			long id = endereco.getId();
			Link linkProprioObterEndereco = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(EnderecoControle.class)
							.obterEndereco(id))
					.withSelfRel();
			endereco.add(linkProprioObterEndereco);
			
			Link linkProprioObterEnderecos = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(EnderecoControle.class)
							.obterEnderecos())
					.withSelfRel();
			endereco.add(linkProprioObterEnderecos);
			
			Link linkProprioCadastrarEndereco = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(EnderecoControle.class)
							.cadastrarEndereco(endereco, id))
					.withSelfRel();
			endereco.add(linkProprioCadastrarEndereco);
			
			Link linkProprioAtualizarEndereco = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(EnderecoControle.class)
							.atualizarEndereco(endereco))
					.withSelfRel();
			endereco.add(linkProprioAtualizarEndereco);
			
			Link linkProprioExcluirEndereco = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(EnderecoControle.class)
							.excluirEndereco(id))
					.withSelfRel();
			endereco.add(linkProprioExcluirEndereco);	
			
		}
	}

	@Override
	public void adicionarLink(Endereco objeto) {
		Link linkProprioObterEndereco = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(EnderecoControle.class)
						.obterEndereco(objeto.getId()))
				.withRel("endereco");
		objeto.add(linkProprioObterEndereco);
		
		Link linkProprioObterEnderecos = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(EnderecoControle.class)
						.obterEnderecos())
				.withRel("enderecos");
		objeto.add(linkProprioObterEnderecos);
		
		Link linkProprioCadastrarEndereco = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(EnderecoControle.class)
						.cadastrarEndereco(objeto, id))
				.withRel("cadastrarEndereco");
		objeto.add(linkProprioCadastrarEndereco);
		
		Link linkProprioAtualizarEndereco = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(EnderecoControle.class)
						.atualizarEndereco(objeto))
				.withRel("atualizarEndereco");
		objeto.add(linkProprioAtualizarEndereco);
		
		Link linkProprioExcluirEndereco = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(EnderecoControle.class)
						.excluirEndereco(objeto, id))
				.withRel("excluirEndereco");
		objeto.add(linkProprioExcluirEndereco);
		
	}
}
