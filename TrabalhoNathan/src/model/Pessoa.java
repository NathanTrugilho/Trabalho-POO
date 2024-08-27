package model;

public abstract class Pessoa {
	private String nome;
	private String email;
	private long telefone;

	public Pessoa(String nome, String email, long telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public Pessoa(String nome, String email) {
		this.nome = nome;
		this.email = email;
		this.telefone = 0;
	}

	public Pessoa(String nome, long telefone) {
		this.nome = nome;
		this.email = null;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public abstract long getCadastroRF();

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Nome: " + this.nome + "\n");
		
		sb.append("CadastroRF: " + getCadastroRF() + "\n");
		
		if (this.email != null) {
			sb.append("Email: " + this.email + "\n");
		}
		
		if (this.telefone != 0) {
			sb.append("Telefone: " + this.telefone + "\n");
		}
		
		return sb.toString();
	}
}
