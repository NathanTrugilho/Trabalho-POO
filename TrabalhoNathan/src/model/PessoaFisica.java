package model;

public class PessoaFisica extends Pessoa {

	private final long cpf;

	public PessoaFisica(String nome, String email, long telefone, long cpf) {
		super(nome, email, telefone);
		this.cpf = cpf;
	}

	@Override
	public long getCadastro() {
		return this.cpf;
	}

}