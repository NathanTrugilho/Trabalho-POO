package util;

import exception.CampoNaoPreenchidoException;

public class TribunalUtils {

	public static void validarCadastroTribunal(String sigla, String secao, String descricao)
			throws CampoNaoPreenchidoException {

		if (sigla.isBlank()) {
			throw new CampoNaoPreenchidoException("Insira uma sigla!");
		}

		if (secao.isBlank()) {
			throw new CampoNaoPreenchidoException("Insira uma seção!");
		}

		if (descricao.isBlank()) {
			throw new CampoNaoPreenchidoException("Insira uma descrição!");
		}

	}

}