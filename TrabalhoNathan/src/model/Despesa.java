package model;

import java.util.Date;

public class Despesa {
	
	private final Date data;
	private final String descricao;
	private final double valor;
	
	public Despesa(Date data, String descricao, double valor) {
		super();
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Despesas [descricao=" + descricao + ", valor=" + valor + "]";
	}
	
	

}
