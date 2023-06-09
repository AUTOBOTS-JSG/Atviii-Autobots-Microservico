package com.autobots.automanager.adicionadores;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controles.DocumentoControle;
import com.autobots.automanager.entitades.Documento;

@Component
public class AdicionadorLinkDocumento implements AdicionadorLink<Documento> {

	@Override
	public void adicionarLink(List<Documento> lista) {
		for (Documento documento : lista) {
			long id = documento.getId();
			Link linkProprioObterDocumento = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(DocumentoControle.class)
							.obterDocumento(id))
					.withSelfRel();
			documento.add(linkProprioObterDocumento);
			
			Link linkProprioObterDocumentos = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(DocumentoControle.class)
							.obterDocumentos())
					.withSelfRel();
			documento.add(linkProprioObterDocumentos);
			
			Link linkProprioCadastrarDocumento = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(DocumentoControle.class)
							.cadastrarDocumento(documento, id))
					.withSelfRel();
			documento.add(linkProprioCadastrarDocumento);
			
			Link linkProprioAtualizarDocumento = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(DocumentoControle.class)
							.atualizarDocumento(documento))
					.withSelfRel();
			documento.add(linkProprioAtualizarDocumento);
			
			Link linkProprioExcluirDocumento = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(DocumentoControle.class)
							.excluirDocumento(documento, id))
					.withSelfRel();
			documento.add(linkProprioExcluirDocumento);	
			
		}
	}

	@Override
	public void adicionarLink(Documento objeto) {
		Link linkProprioObterDocumento = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(DocumentoControle.class)
						.obterDocumento(objeto.getId()))
				.withRel("documento");
		objeto.add(linkProprioObterDocumento);
		
		Link linkProprioObterDocumentos = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(DocumentoControle.class)
						.obterDocumentos())
				.withRel("documentos");
		objeto.add(linkProprioObterDocumentos);
		
		Link linkProprioCadastrarDocumento = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(DocumentoControle.class)
						.cadastrarDocumento(objeto, id))
				.withRel("cadastrarDocumento");
		objeto.add(linkProprioCadastrarDocumento);
		
		Link linkProprioAtualizarDocumento = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(DocumentoControle.class)
						.atualizarDocumento(objeto))
				.withRel("atualizarDocumento");
		objeto.add(linkProprioAtualizarDocumento);
		
		Link linkProprioExcluirDocumento = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(DocumentoControle.class)
						.excluirDocumento(objeto, id))
				.withRel("excluirDocumento");
		objeto.add(linkProprioExcluirDocumento);
		
	}
}
