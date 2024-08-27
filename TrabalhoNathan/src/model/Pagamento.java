package model;

import java.util.Date;

public class Pagamento {
	
	private final EFormaPagamento formaPagamento;
	private final Date data;
	private final float valor;
	
	public Pagamento(EFormaPagamento formaPagamento, Date data, float valor) {
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

	public float getValor() {
		return valor;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	

}
