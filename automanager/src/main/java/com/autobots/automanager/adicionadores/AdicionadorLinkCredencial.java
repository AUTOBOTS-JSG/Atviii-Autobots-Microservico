package com.autobots.automanager.adicionadores;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controles.CredencialControle;
import com.autobots.automanager.entitades.Credencial;
import com.autobots.automanager.adicionadores.AdicionadorLink;

@Component
public class AdicionadorLinkCredencial implements AdicionadorLink<Credencial> {

	@Override
	public void adicionarLink(List<Credencial> lista) {
		for (Credencial credencial : lista) {
			long id = credencial.getId();
			Link linkProprioObterCredencial = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(CredencialControle.class)
							.obterCredencial(id))
					.withSelfRel();
			credencial.add(linkProprioObterCredencial);
			
			Link linkProprioObterCredenciais = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(CredencialControle.class)
							.obterCredenciais())
					.withSelfRel();
			credencial.add(linkProprioObterCredenciais);
			
			Link linkProprioCadastrarCredencial = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(CredencialControle.class)
							.cadastrarCredencial(credencial, id))
					.withSelfRel();
			credencial.add(linkProprioCadastrarCredencial);
			
			Link linkProprioAtualizarCredencial = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(CredencialControle.class)
							.atualizarCredencial(credencial))
					.withSelfRel();
			credencial.add(linkProprioAtualizarCredencial);
			
			Link linkProprioExcluirCredencial = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(CredencialControle.class)
							.excluirCredencial(credencial, id))
					.withSelfRel();
			credencial.add(linkProprioExcluirCredencial);	
			
		}
	}

	@Override
	public void adicionarLink(Credencial objeto) {
		Link linkProprioObterCredencial = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(CredencialControle.class)
						.obterCredencial(objeto.getId()))
				.withRel("credencial");
		objeto.add(linkProprioObterCredencial);
		
		Link linkProprioObterCredenciais = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(CredencialControle.class)
						.obterCredenciais())
				.withRel("credenciais");
		objeto.add(linkProprioObterCredenciais);
		
		Link linkProprioCadastrarCredencial = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(CredencialControle.class)
						.cadastrarUsuario(objeto, id))
				.withRel("cadastrar");
		objeto.add(linkProprioCadastrarCredencial);
		
		Link linkProprioAtualizarCredencial = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(CredencialControle.class)
						.atualizarCredencial(objeto))
				.withRel("atualizar");
		objeto.add(linkProprioAtualizarCredencial);
		
		Link linkProprioExcluirCredencial = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(CredencialControle.class)
						.excluirCredencial(objeto, id))
				.withRel("excluir");
		objeto.add(linkProprioExcluirCredencial);
		
	}
}
