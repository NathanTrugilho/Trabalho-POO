package util;

import exception.CampoNaoPreenchidoException;

public class TribunalUtils {

	public static void validarCadastroTribunal(String sigla, String secao, String descricao)
			throws CampoNaoPreenchidoException {

		if (sigla.isEmpty()) {
			throw new CampoNaoPreenchidoException("Sigla não pode estar vazia!");
		}

		if (secao.isEmpty()) {
			throw new CampoNaoPreenchidoException("Seção não pode estar vazia!");
		}

		if (descricao.isEmpty()) {
			throw new CampoNaoPreenchidoException("Descrição não pode estar vazia!");
		}

	}

}