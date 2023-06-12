package com.autobots.automanager.adicionadores;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controles.EmailControle;
import com.autobots.automanager.controles.MercadoriaControle;
import com.autobots.automanager.entitades.Email;
import com.autobots.automanager.entitades.Mercadoria;

@Component
public class AdicionadorLinkMercadoria implements AdicionadorLink<Mercadoria> {

	@Override
	public void adicionarLink(List<Mercadoria> lista) {
		for (Mercadoria mercadoria : lista) {
			long id = mercadoria.getId();
			Link linkProprioObterMercadoria = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(MercadoriaControle.class)
							.obterMercadoria(id))
					.withSelfRel();
			mercadoria.add(linkProprioObterMercadoria);
			
			Link linkProprioObterMercadorias = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(MercadoriaControle.class)
							.obterMercadorias())
					.withSelfRel();
			mercadoria.add(linkProprioObterMercadorias);
			
			Link linkProprioCadastrarMercadoria = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(MercadoriaControle.class)
							.cadastrarMercadoria(mercadoria, id))
					.withSelfRel();
			mercadoria.add(linkProprioCadastrarMercadoria);
			
			Link linkProprioAtualizarMercadoria = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(MercadoriaControle.class)
							.atualizarMercadoria(mercadoria))
					.withSelfRel();
			mercadoria.add(linkProprioAtualizarMercadoria);
			
			Link linkProprioExcluirMercadoria = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(MercadoriaControle.class)
							.excluirMercadoria(mercadoria, id))
					.withSelfRel();
			mercadoria.add(linkProprioExcluirMercadoria);	
			
		}
	}

	@Override
	public void adicionarLink(Mercadoria objeto) {
		Link linkProprioObterMercadoria = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(MercadoriaControle.class)
						.obterMercadoria(objeto.getId()))
				.withRel("mercadoria");
		objeto.add(linkProprioObterMercadoria);
		
		Link linkProprioObterMercadorias = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(MercadoriaControle.class)
						.obterMercadorias())
				.withRel("mercadorias");
		objeto.add(linkProprioObterMercadorias);
		
		Link linkProprioCadastrarMercadoria = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(MercadoriaControle.class)
						.cadastrarMercadoria(objeto, id))
				.withRel("cadastrar");
		objeto.add(linkProprioCadastrarMercadoria);
		
		Link linkProprioAtualizarMercadoria = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(MercadoriaControle.class)
						.atualizarMercadoria(objeto))
				.withRel("atualizar");
		objeto.add(linkProprioAtualizarMercadoria);
		
		Link linkProprioExcluirMercadoria = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(EmailControle.class)
						.excluirEmail(objeto, id))
				.withRel("excluir");
		objeto.add(linkProprioExcluirMercadoria);
		
	}
}
