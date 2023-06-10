package com.autobots.automanager.adicionadores;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controles.TelefoneControle;
import com.autobots.automanager.entitades.Telefone;

@Component
public class AdicionadorLinkTelefone implements AdicionadorLink<Telefone> {

	@Override
	public void adicionarLink(List<Telefone> lista) {
		for (Telefone telefone : lista) {
			long id = telefone.getId();
			Link linkProprioObterTelefone = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(TelefoneControle.class)
							.obterTelefone(id))
					.withSelfRel();
			telefone.add(linkProprioObterTelefone);
			
			Link linkProprioObterTelefones = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(TelefoneControle.class)
							.obterTelefones())
					.withSelfRel();
			telefone.add(linkProprioObterTelefones);
			
			Link linkProprioCadastrarTelefone = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(TelefoneControle.class)
							.cadastrarTelefone(telefone, id))
					.withSelfRel();
			telefone.add(linkProprioCadastrarTelefone);
			
			Link linkProprioAtualizarTelefone = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(TelefoneControle.class)
							.atualizarTelefone(telefone))
					.withSelfRel();
			telefone.add(linkProprioAtualizarTelefone);
			
			Link linkProprioExcluirTelefone = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(TelefoneControle.class)
							.excluirTelefone(telefone, id))
					.withSelfRel();
			telefone.add(linkProprioExcluirTelefone);	
			
		}
	}

	@Override
	public void adicionarLink(Telefone objeto) {
		Link linkProprioObterTelefone = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(TelefoneControle.class)
						.obterTelefone(objeto.getId()))
				.withRel("telefone");
		objeto.add(linkProprioObterTelefone);
		
		Link linkProprioObterTelefones = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(TelefoneControle.class)
						.obterTelefones())
				.withRel("telefones");
		objeto.add(linkProprioObterTelefones);
		
		Link linkProprioCadastrarTelefone = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(TelefoneControle.class)
						.cadastrarTelefone(objeto, id))
				.withRel("cadastrarTelefone");
		objeto.add(linkProprioCadastrarTelefone);
		
		Link linkProprioAtualizarTelefone = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(TelefoneControle.class)
						.atualizarTelefone(objeto))
				.withRel("atualizarTelefone");
		objeto.add(linkProprioAtualizarTelefone);
		
		Link linkProprioExcluirTelefone = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(TelefoneControle.class)
						.excluirTelefone(objeto, id))
				.withRel("excluirTelefone");
		objeto.add(linkProprioExcluirTelefone);
		
	}
}
