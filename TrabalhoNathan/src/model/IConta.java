package model;

import java.util.Date;

import exception.AtributoNuloException;
import exception.ValorInvalidoException;

public interface IConta {

	public void addPagamento(EFormaPagamento forma, Date data, double valor) throws AtributoNuloException, ValorInvalidoException;

	public void addDespesa(Date data, String descricao, double valor) throws AtributoNuloException, ValorInvalidoException ;

	public double getTotalPagamentos();

	public double getTotalDespesas();

	public double getSaldoConta();

	public StringBuilder getExtrato();
}
