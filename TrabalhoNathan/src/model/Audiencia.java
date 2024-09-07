package model;

import java.io.Serializable;
import java.util.Date;

import exception.AtributoNuloException;

public class Audiencia implements Serializable{

	private static final long serialVersionUID = -166608631342301689L;
	
	private final Advogado advogado;
	private final Date data;
	private final String recomendacao;

	public Audiencia(Advogado advogado, Date data, String recomendacao) throws AtributoNuloException {
		
		if(advogado == null) {
			throw new AtributoNuloException("Advogado não pode ser nulo na criação de uma audiência!");
		}
		
		if(data == null) {
			throw new AtributoNuloException("Data não pode ser nula na criação de uma audiência!");
		}
		
		if(recomendacao == null || recomendacao.isBlank()) {
			throw new AtributoNuloException("Recomendação não pode ser nula na criação de uma audiência!");
		}
		
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
