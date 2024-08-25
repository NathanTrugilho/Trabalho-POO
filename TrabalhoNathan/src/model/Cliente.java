package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	private final Pessoa pessoa;
	private List<Processo> processos = new ArrayList<>();
	
	public Cliente(Pessoa pessoa, Processo processo) {
		this.pessoa = pessoa;
		processos.add(processo);
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
	
	public StringBuilder getExtratoConta() {
		
	}
	
	public double getSaldoConta() {
		
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
