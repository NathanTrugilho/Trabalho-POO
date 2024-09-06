package model;

import exception.CPFInvalidoException;
import exception.CampoNaoPreenchidoException;
import exception.FormatoEmailInvalidoException;
import exception.RegistroNuloException;
import exception.TelefoneInvalidoException;
import exception.TelefoneNaoNumericoException;

public class Advogado extends PessoaFisica {

	private static final long serialVersionUID = -8787887370149414760L;

	private final String registro;

	public Advogado(String nome, String cpf, String registro, String email, long telefone)
			throws CampoNaoPreenchidoException, FormatoEmailInvalidoException, TelefoneInvalidoException,
			TelefoneNaoNumericoException, CPFInvalidoException, RegistroNuloException {

		super(nome, cpf, email, telefone);
				
		if (registro == null) {
			throw new RegistroNuloException();
		}
		
		this.registro = registro;
	}

	public String getRegistro() {
		return registro;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append("Registro: " + this.getRegistro() + "\n");
		sb.append(super.toString());

		return sb.toString();
	}
}
