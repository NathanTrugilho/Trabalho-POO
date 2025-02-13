package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import exception.ClienteNecessitaPessoa;

public class Cliente implements Serializable{

	private static final long serialVersionUID = 1324820353526542179L;
	
	private final Pessoa pessoa;
	private List<Processo> processos = new ArrayList<>();
	
	public Cliente(Pessoa pessoa) throws ClienteNecessitaPessoa {
		
		if (pessoa == null) {
			throw new ClienteNecessitaPessoa();
		}
		
		this.pessoa = pessoa;
	}
	
	public Pessoa getPessoa() {
		return this.pessoa;
	}
	
	public void addProcesso(Processo processo) {
		processos.add(processo);	
	}
	
	public void removeProcesso(Processo processo) {
		processos.remove(processo);
	}
	
	public List<Processo> getListProcessos() {
		return this.processos;
	}
	
	public StringBuilder getExtratoConta() {
		
		StringBuilder sb = new StringBuilder();
		
		for (Processo processo : processos) {
			sb.append(processo.getExtratoContas());
		}
		
		return sb;
	}
	
	public double getSaldoConta() {
		
		double somaSaldo = 0;
		
		for (Processo processo : processos) {
			somaSaldo += processo.getConta().getSaldoConta();
		}
		
		return somaSaldo;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
