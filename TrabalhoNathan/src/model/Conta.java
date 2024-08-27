package model;

import java.util.ArrayList;
import java.util.List;

public class Conta implements IConta{
	
	private List<Despesa> despesas = new ArrayList<>();
	private List<Pagamento> pagamentos = new ArrayList<>();
	
	public Conta() {
		super();
	}
	
	public void addPagamento(Pagamento pagamento) {
		pagamentos.add(pagamento);
	};

	public void addDespesa(Despesa despesa) {
		despesas.add(despesa);
	};

	public double getTotalPagamentos() {
		
	};

	public double getTotalDespesas() {
		
	};

	public double getSaldoConta() {
		
	};

	public StringBuilder getExtrato() {
		
	};
}
