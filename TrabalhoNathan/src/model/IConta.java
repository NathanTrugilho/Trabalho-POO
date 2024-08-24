package model;

public interface IConta {

	public void addPagamento();

	public void addDespesa();

	public double getTotalPagamentos();

	public double getTotalDespesas();

	public double getSaldoConta();

	public StringBuilder getExtrato();
}
