package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Conta implements IConta {

	private List<Despesa> despesas = new ArrayList<>();
	private List<Pagamento> pagamentos = new ArrayList<>();

	public Conta() {
		super();
	}
	
	public void addDespesa(Date data, String descricao, double valor) {
		Despesa desp = new Despesa(data, descricao, valor);
		despesas.add(desp);
	};
	
	public void addPagamento(EFormaPagamento forma, Date data, double valor) {
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
		return this.getTotalDespesas() - this.getTotalPagamentos();
	};

	public StringBuilder getExtrato() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("\n====== Despesas ======\n");
		
		for (Despesa despesa : despesas) {
			sb.append(despesa.toString());
		}
		
		sb.append("\n====== Pagamentos ======\n");
		
		for (Pagamento pagamento : pagamentos) {
			sb.append(pagamento.toString());
		}
		
		return sb;
	}

}
