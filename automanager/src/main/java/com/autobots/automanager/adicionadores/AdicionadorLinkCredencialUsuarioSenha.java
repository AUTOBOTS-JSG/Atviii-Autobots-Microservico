package com.autobots.automanager.adicionadores;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controles.CredencialUsuarioSenhaControle;
import com.autobots.automanager.entitades.CredencialUsuarioSenha;

@Component
public class AdicionadorLinkCredencialUsuarioSenha implements AdicionadorLink<CredencialUsuarioSenha> {

	@Override
	public void adicionarLink(List<CredencialUsuarioSenha> lista) {
		for (CredencialUsuarioSenha credencialUsuarioSenha : lista) {
			long id = credencialUsuarioSenha.getId();
			Link linkProprioObterCredencialUsuarioSenha = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(CredencialUsuarioSenhaControle.class)
							.obterCredencialUsuarioSenha(id))
					.withSelfRel();
			credencialUsuarioSenha.add(linkProprioObterCredencialUsuarioSenha);
			
			Link linkProprioObterCredenciaisUsuariosSenhas = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(CredencialUsuarioSenhaControle.class)
							.obterCredenciaisUsuariosSenhas())
					.withSelfRel();
			credencialUsuarioSenha.add(linkProprioObterCredenciaisUsuariosSenhas);
			
			Link linkProprioCadastrarCredencialUsuarioSenha = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(CredencialUsuarioSenhaControle.class)
							.cadastrarCredencialUsuarioSenha(credencialUsuarioSenha, id))
					.withSelfRel();
			credencialUsuarioSenha.add(linkProprioCadastrarCredencialUsuarioSenha);
			
			Link linkProprioAtualizarCredencialUsuarioSenha = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(CredencialUsuarioSenhaControle.class)
							.atualizarCredencialUsuarioSenha(credencialUsuarioSenha))
					.withSelfRel();
			credencialUsuarioSenha.add(linkProprioAtualizarCredencialUsuarioSenha);
			
			Link linkProprioExcluirCredencialUsuarioSenha = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(CredencialUsuarioSenhaControle.class)
							.excluirCredencialUsuarioSenha(credencialUsuarioSenha, id))
					.withSelfRel();
			credencialUsuarioSenha.add(linkProprioExcluirCredencialUsuarioSenha);	
			
		}
	}

	@Override
	public void adicionarLink(CredencialUsuarioSenha objeto) {
		Link linkProprioObterCredencialUsuarioSenha = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(CredencialUsuarioSenhaControle.class)
						.obterCredencialUsuarioSenha(objeto.getId()))
				.withRel("credencialUsuarioSenha");
		objeto.add(linkProprioObterCredencialUsuarioSenha);
		
		Link linkProprioObterCredenciaisUsuariosSenhas = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(CredencialUsuarioSenhaControle.class)
						.obterCredenciaisUsuariosSenhas())
				.withRel("credenciaisUsuariosSenhas");
		objeto.add(linkProprioObterCredenciaisUsuariosSenhas);
		
		Link linkProprioCadastrarCredencialUsuarioSenha = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(CredencialUsuarioSenhaControle.class)
						.cadastrarCredencialUsuarioSenha(objeto, id))
				.withRel("cadastrar");
		objeto.add(linkProprioCadastrarCredencialUsuarioSenha);
		
		Link linkProprioAtualizarCredencialUsuarioSenha = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(CredencialUsuarioSenhaControle.class)
						.atualizarCredencialUsuarioSenha(objeto))
				.withRel("atualizar");
		objeto.add(linkProprioAtualizarCredencialUsuarioSenha);
		
		Link linkProprioExcluirCredencialUsuarioSenha = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(CredencialUsuarioSenhaControle.class)
						.excluirCredencial(objeto, id))
				.withRel("excluir");
		objeto.add(linkProprioExcluirCredencialUsuarioSenha);
		
	}
}
