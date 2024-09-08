package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import exception.AtributoNuloException;
import exception.ValorInvalidoException;

public class Conta implements IConta, Serializable{

	private static final long serialVersionUID = 2908618581228493812L;
	
	private List<Despesa> despesas = new ArrayList<>();
	private List<Pagamento> pagamentos = new ArrayList<>();

	public Conta() {
		super();
	}
	
	public void addDespesa(Date data, String descricao, double valor) throws AtributoNuloException, ValorInvalidoException {
		Despesa desp = new Despesa(data, descricao, valor);
		despesas.add(desp);
	};
	
	public void addPagamento(EFormaPagamento forma, Date data, double valor) throws AtributoNuloException, ValorInvalidoException {
		Pagamento pag = new Pagamento(forma, data, valor);
		pagamentos.add(pag);
	};

	public double getTotalPagamentos() {
		double totalPagamentos = 0;

		for (Pagamento pagamento : pagamentos) {
			totalPagamentos += pagamento.getValor();
		}
		return totalPagamentos;
	};

	public double getTotalDespesas() {
		double totalDespesas = 0;
		
		for (Despesa despesa : despesas) {
			totalDespesas += despesa.getValor();
		}
		return totalDespesas;
	};

	public double getSaldoConta() {
		return this.getTotalPagamentos() - this.getTotalDespesas();
	};

	public StringBuilder getExtrato() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("\n====== Despesas ======\n");
		
		for (Despesa despesa : despesas) {
			sb.append(despesa.toString());
		}
		
		sb.append("====== Pagamentos ======\n");
		
		for (Pagamento pagamento : pagamentos) {
			sb.append(pagamento.toString());
		}
		
		return sb;
	}

}
