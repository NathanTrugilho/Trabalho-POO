package model;

import java.io.Serializable;
import java.util.Date;

import exception.AtributoNuloException;
import exception.ValorInvalidoException;

public class Despesa implements Serializable{

	private static final long serialVersionUID = 3904985312831726862L;
	
	private final Date data;
	private final String descricao;
	private final double valor;

	public Despesa(Date data, String descricao, double valor) throws AtributoNuloException, ValorInvalidoException {
				
		if(data == null) {
			throw new AtributoNuloException("Data não pode ser nula na criação de uma despesa!");
		}
		
		if(descricao == null || descricao.isBlank()) {
			throw new AtributoNuloException("Descrição não pode ser nula na criação de uma despesa!");
		}
		
		if (valor <= 0) {
			throw new ValorInvalidoException("Insira um valor válido de despesa!");
		}
		
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

		sb.append("Data: " + this.getData() + "\n");
		sb.append("Valor: " + this.getValor() + "\n");
		sb.append("Descricao: " + this.getDescricao() + "\n\n");

		return sb.toString();
	}

}
