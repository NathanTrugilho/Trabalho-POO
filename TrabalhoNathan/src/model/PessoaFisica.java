package model;

import java.io.Serializable;

public class PessoaFisica extends Pessoa implements Serializable{

	private static final long serialVersionUID = 2873049312251537530L;

	private final long cpf;

	public PessoaFisica(String nome, long cpf, String email, long telefone) {
		super(nome, email, telefone);
		this.cpf = cpf;
	}
	
	public PessoaFisica(String nome, long cpf, String email) {
		super(nome, email);
		this.cpf = cpf;
	}
	
	public PessoaFisica(String nome, long cpf, long telefone) {
		super(nome, telefone);
		this.cpf = cpf;
	}

	@Override
	public long getCadastroRF() {
		return this.cpf;
	}
}