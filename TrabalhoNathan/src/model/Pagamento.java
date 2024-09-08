package model;

import java.io.Serializable;
import java.util.Date;

import exception.AtributoNuloException;
import exception.ValorInvalidoException;

public class Pagamento implements Serializable{

	private static final long serialVersionUID = -114271032340405257L;
	
	private final EFormaPagamento formaPagamento;
	private final Date data;
	private final double valor;
	
	public Pagamento(EFormaPagamento formaPagamento, Date data, double valor) throws AtributoNuloException, ValorInvalidoException {
		
		if(data == null) {
			throw new AtributoNuloException("Data não pode ser nula na criação de uma despesa!");
		}
		
		if(formaPagamento == null){
			throw new AtributoNuloException("Descrição não pode ser nula na criação de uma despesa!");
		}
		
		if (valor <= 0) {
			throw new ValorInvalidoException("Insira um valor válido de despesa!");
		}
		
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

		sb.append("FormaPagamento: " + this.getFormaPagamento() + "\tValor: " + this.getValor() + " reais\n\n");
		
		return sb.toString();
	}
	

}
