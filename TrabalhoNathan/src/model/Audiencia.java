package model;

import java.util.Date;

public class Audiencia {

	private final Advogado advogado;
	private final Date data;
	private final String recomendacao;

	public Audiencia(Advogado advogado, Date data, String recomendacao) {
		this.advogado = advogado;
		this.data = data;
		this.recomendacao = recomendacao;
	}

	public Advogado getAdvogado() {
		return advogado;
	}

	public Date getData() {
		return data;
	}

	public String getRecomendacao() {
		return recomendacao;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
