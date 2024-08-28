package model;

import java.util.Date;

public class Pagamento {
	
	private final EFormaPagamento formaPagamento;
	private final Date data;
	private final double valor;
	
	public Pagamento(EFormaPagamento formaPagamento, Date data, double valor) {
		this.formaPagamento = formaPagamento;
		this.data = data;
		this.valor = valor;
	}

	public EFormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public Date getData() {
		return data;
	}

	public double getValor() {
		return valor;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Data: " + this.getData() + "\n");

		sb.append("FormaPagamento: " + this.getFormaPagamento() + "\tValor: " + this.getValor() + "\n\n");
		
		return sb.toString();
	}
	

}
