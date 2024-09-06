package model;

import java.io.Serializable;

import exception.CampoNaoPreenchidoException;

public class Tribunal implements Serializable {

	private static final long serialVersionUID = -5242369707305899479L;

	private final String sigla;
	private final String secao;
	private final String descricao;

	public Tribunal(String sigla, String secao, String descricao) throws CampoNaoPreenchidoException {
		if (sigla.isBlank()) {
			throw new CampoNaoPreenchidoException("Insira uma sigla!");
		}

		if (secao.isBlank()) {
			throw new CampoNaoPreenchidoException("Insira uma seção!");
		}

		if (descricao.isBlank()) {
			throw new CampoNaoPreenchidoException("Insira uma descrição!");
		}

		this.sigla = sigla;
		this.descricao = descricao;
		this.secao = secao;
	}

	public String getSigla() {
		return sigla;
	}

	public String getSecao() {
		return secao;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append("Sigla: " + this.getSigla() + "\tSeção: " + this.getSecao() + "\n");
		sb.append("Descricao: " + this.getDescricao() + "\n");

		return sb.toString();
	}
}
