package model;

public class Advogado extends PessoaFisica {

	private final long registro;

	public Advogado(String nome, long cpf, long registro, String email, long telefone) {
		super(nome, cpf, email, telefone);
		this.registro = registro;
	}

	public Advogado(String nome, long cpf, long registro, String email) {
		super(nome, cpf, email);
		this.registro = registro;
	}
	
	public Advogado(String nome, long cpf, long registro, long telefone) {
		super(nome, cpf, telefone);
		this.registro = registro;
	}
	
	public long getRegistro() {
		return registro;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(super.toString());
		sb.append("Registro: " + this.getRegistro() + "\n");
		
		return sb.toString();
	}
}
