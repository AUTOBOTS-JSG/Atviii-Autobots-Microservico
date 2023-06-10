package com.autobots.automanager.selecionadores;

import java.util.List;

import org.springframework.stereotype.Component;

import com.autobots.automanager.entitades.Credencial;
import com.autobots.automanager.entitades.CredencialCodigoBarra;

@Component
public class CredencialCodigoBarraSelecionador {
	public CredencialCodigoBarra selecionar(List<Credencial> credenciais, long id) {
		CredencialCodigoBarra selecionado = null;
		for (CredencialCodigoBarra credencialCodigoBarra : credenciaisCodigosBarras) {
			if (credencialCodigoBarra.getCodigo()==id) {
				selecionado = credencialCodigoBarra;
			}
		}
		return selecionado;
	}
}