package model;

import java.util.Date;

public class Despesa {

	private final Date data;
	private final String descricao;
	private final double valor;

	public Despesa(Date data, String descricao, double valor) {
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getValor() {
		return valor;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append("Data: " + this.getData() + "\tValor: " + this.getValor() + "\n");
		sb.append("Descricao: " + this.getDescricao() + "\n\n");

		return sb.toString();
	}

}
