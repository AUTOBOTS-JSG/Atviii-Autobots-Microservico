package com.autobots.automanager.adicionadores;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controles.EmpresaControle;
import com.autobots.automanager.entitades.Empresa;

@Component
public class AdicionadorLinkEmpresa implements AdicionadorLink<Empresa> {

	@Override
	public void adicionarLink(List<Empresa> lista) {
		for (Empresa empresa : lista) {
			long id = empresa.getId();
			Link linkProprioObterEmpresa = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(EmpresaControle.class)
							.obterEmpresa(id))
					.withSelfRel();
			empresa.add(linkProprioObterEmpresa);
			
			Link linkProprioObterEmpresas = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(EmpresaControle.class)
							.obterEmpresas())
					.withSelfRel();
			empresa.add(linkProprioObterEmpresas);
			
			Link linkProprioCadastrarEmpresa = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(EmpresaControle.class)
							.cadastrarEmpresa(empresa))
					.withSelfRel();
			empresa.add(linkProprioCadastrarEmpresa);
			
			Link linkProprioAtualizarEmpresa = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(EmpresaControle.class)
							.atualizarEmpresa(empresa))
					.withSelfRel();
			empresa.add(linkProprioAtualizarEmpresa);
			
			Link linkProprioExcluirEmpresa = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(EmpresaControle.class)
							.excluirEmpresa(empresa))
					.withSelfRel();
			empresa.add(linkProprioExcluirEmpresa);	
			
		}
	}

	@Override
	public void adicionarLink(Empresa objeto) {
		Link linkProprioObterEmpresa = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(EmpresaControle.class)
						.obterEmpresa(objeto.getId()))
				.withRel("empresa");
		objeto.add(linkProprioObterEmpresa);
		
		Link linkProprioObterEmpresas = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(EmpresaControle.class)
						.obterEmpresas())
				.withRel("empresas");
		objeto.add(linkProprioObterEmpresas);
		
		Link linkProprioCadastrarEmpresa = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(EmpresaControle.class)
						.cadastrarEmpresa(objeto))
				.withRel("cadastrar");
		objeto.add(linkProprioCadastrarEmpresa);
		
		Link linkProprioAtualizarEmpresa = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(EmpresaControle.class)
						.atualizarEmpresa(objeto))
				.withRel("atualizar");
		objeto.add(linkProprioAtualizarEmpresa);
		
		Link linkProprioExcluirEmpresa = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(EmpresaControle.class)
						.excluirEmpresa(objeto))
				.withRel("excluir");
		objeto.add(linkProprioExcluirEmpresa);
		
	}
}
