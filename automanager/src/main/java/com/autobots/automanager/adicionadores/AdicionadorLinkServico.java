package com.autobots.automanager.adicionadores;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controles.ServicoControle;
import com.autobots.automanager.entitades.Servico;

@Component
public class AdicionadorLinkServico implements AdicionadorLink<Servico> {

	@Override
	public void adicionarLink(List<Servico> lista) {
		for (Servico servico : lista) {
			long id = servico.getId();
			Link linkProprioObterServico = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(ServicoControle.class)
							.obterServico(id))
					.withSelfRel();
			servico.add(linkProprioObterServico);
			
			Link linkProprioObterServicos = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(ServicoControle.class)
							.obterServicos())
					.withSelfRel();
			servico.add(linkProprioObterServicos);
			
			Link linkProprioCadastrarServico = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(ServicoControle.class)
							.cadastrarServico(servico, id))
					.withSelfRel();
			servico.add(linkProprioCadastrarServico);
			
			Link linkProprioAtualizarServico = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(ServicoControle.class)
							.atualizarServico(servico))
					.withSelfRel();
			servico.add(linkProprioAtualizarServico);
			
			Link linkProprioExcluirServico = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(ServicoControle.class)
							.excluirServico(servico, id))
					.withSelfRel();
			servico.add(linkProprioExcluirServico);	
			
		}
	}

	@Override
	public void adicionarLink(Servico objeto) {
		Link linkProprioObterServico = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(ServicoControle.class)
						.obterServico(objeto.getId()))
				.withRel("servico");
		objeto.add(linkProprioObterServico);
		
		Link linkProprioObterServicos = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(ServicoControle.class)
						.obterServicos())
				.withRel("servicos");
		objeto.add(linkProprioObterServicos);
		
		Link linkProprioCadastrarServico = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(ServicoControle.class)
						.cadastrarServico(objeto, id))
				.withRel("cadastrar");
		objeto.add(linkProprioCadastrarServico);
		
		Link linkProprioAtualizarServico = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(ServicoControle.class)
						.atualizarServico(objeto))
				.withRel("atualizar");
		objeto.add(linkProprioAtualizarServico);
		
		Link linkProprioExcluirServico = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(ServicoControle.class)
						.excluirServico(objeto, id))
				.withRel("excluir");
		objeto.add(linkProprioExcluirServico);
		
	}
}
