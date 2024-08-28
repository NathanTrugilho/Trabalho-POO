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
		StringBuilder sb = new StringBuilder();

		sb.append("Advogado: " + this.getAdvogado().getNome() + "\tRegistro: " + this.getAdvogado().getRegistro() + "\n");
				
		sb.append("Data: " + this.getData() + "\n");

		sb.append("Recomendacao: " + this.getRecomendacao() + "\n\n");

		return sb.toString();
	}
}
