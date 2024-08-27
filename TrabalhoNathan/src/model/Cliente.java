package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	private final Pessoa pessoa;
	private List<Processo> processos = new ArrayList<>();
	
	public Cliente(Pessoa pessoa) {
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
	
	public StringBuilder getExtratoConta() {
		return;
	}
	
	public double getSaldoConta() {
		return 0;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
