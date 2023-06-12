package com.autobots.automanager.adicionadores;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controles.VeiculoControle;
import com.autobots.automanager.entitades.Veiculo;

@Component
public class AdicionadorLinkVeiculo implements AdicionadorLink<Veiculo> {

	@Override
	public void adicionarLink(List<Veiculo> lista) {
		for (Veiculo veiculo : lista) {
			long id = veiculo.getId();
			Link linkProprioObterVeiculo = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(VeiculoControle.class)
							.obterVeiculo(id))
					.withSelfRel();
			veiculo.add(linkProprioObterVeiculo);
			
			Link linkProprioObterVeiculos = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(VeiculoControle.class)
							.obterVeiculos())
					.withSelfRel();
			veiculo.add(linkProprioObterVeiculos);
			
			Link linkProprioCadastrarVeiculo = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(VeiculoControle.class)
							.cadastrarVeiculo(veiculo, id))
					.withSelfRel();
			veiculo.add(linkProprioCadastrarVeiculo);
			
			Link linkProprioAtualizarVeiculo = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(VeiculoControle.class)
							.atualizarVeiculo(veiculo))
					.withSelfRel();
			veiculo.add(linkProprioAtualizarVeiculo);
			
			Link linkProprioExcluirVeiculo = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(VeiculoControle.class)
							.excluirVeiculo(veiculo, id))
					.withSelfRel();
			veiculo.add(linkProprioExcluirVeiculo);	
			
		}
	}

	@Override
	public void adicionarLink(Veiculo objeto) {
		Link linkProprioObterVeiculo = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(VeiculoControle.class)
						.obterVeiculo(objeto.getId()))
				.withRel("veiculo");
		objeto.add(linkProprioObterVeiculo);
		
		Link linkProprioObterVeiculos = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(VeiculoControle.class)
						.obterVeiculos())
				.withRel("veiculos");
		objeto.add(linkProprioObterVeiculos);
		
		Link linkProprioCadastrarVeiculo = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(VeiculoControle.class)
						.cadastrarVeiculo(objeto, id))
				.withRel("cadastrar");
		objeto.add(linkProprioCadastrarVeiculo);
		
		Link linkProprioAtualizarVeiculo = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(VeiculoControle.class)
						.atualizarVeiculo(objeto))
				.withRel("atualizar");
		objeto.add(linkProprioAtualizarVeiculo);
		
		Link linkProprioExcluirVeiculo = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(VeiculoControle.class)
						.excluirVeiculo(objeto, id))
				.withRel("excluir");
		objeto.add(linkProprioExcluirVeiculo);
		
	}
}
