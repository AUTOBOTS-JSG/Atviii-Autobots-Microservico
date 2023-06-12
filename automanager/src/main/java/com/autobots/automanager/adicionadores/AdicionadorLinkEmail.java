package com.autobots.automanager.adicionadores;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controles.EmailControle;
import com.autobots.automanager.entitades.Email;

@Component
public class AdicionadorLinkEmail implements AdicionadorLink<Email> {

	@Override
	public void adicionarLink(List<Email> lista) {
		for (Email email : lista) {
			long id = email.getId();
			Link linkProprioObterEmail = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(EmailControle.class)
							.obterEmail(id))
					.withSelfRel();
			email.add(linkProprioObterEmail);
			
			Link linkProprioObterEmails = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(EmailControle.class)
							.obterEmails())
					.withSelfRel();
			email.add(linkProprioObterEmails);
			
			Link linkProprioCadastrarEmail = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(EmailControle.class)
							.cadastrarEmail(email, id))
					.withSelfRel();
			email.add(linkProprioCadastrarEmail);
			
			Link linkProprioAtualizarEmail = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(EmailControle.class)
							.atualizarEmail(email))
					.withSelfRel();
			email.add(linkProprioAtualizarEmail);
			
			Link linkProprioExcluirEmail = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(EmailControle.class)
							.excluirEmail(email, id))
					.withSelfRel();
			email.add(linkProprioExcluirEmail);	
			
		}
	}

	@Override
	public void adicionarLink(Email objeto) {
		Link linkProprioObterEmail = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(EmailControle.class)
						.obterEmail(objeto.getId()))
				.withRel("email");
		objeto.add(linkProprioObterEmail);
		
		Link linkProprioObterEmails = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(EmailControle.class)
						.obterEmails())
				.withRel("emails");
		objeto.add(linkProprioObterEmails);
		
		Link linkProprioCadastrarEmail = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(EmailControle.class)
						.cadastrarEmail(objeto, id))
				.withRel("cadastrar");
		objeto.add(linkProprioCadastrarEmail);
		
		Link linkProprioAtualizarEmail = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(EmailControle.class)
						.atualizarEmail(objeto))
				.withRel("atualizar");
		objeto.add(linkProprioAtualizarEmail);
		
		Link linkProprioExcluirEmail = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(EmailControle.class)
						.excluirEmail(objeto, id))
				.withRel("excluir");
		objeto.add(linkProprioExcluirEmail);
		
	}
}
