package model;

import exception.CPFInvalidoException;
import exception.CampoNaoPreenchidoException;
import exception.FormatoEmailInvalidoException;
import exception.RegistroInvalidoException;
import exception.TelefoneInvalidoException;
import exception.TelefoneNaoNumericoException;

public class Advogado extends PessoaFisica {

	private static final long serialVersionUID = -8787887370149414760L;

	private final long registro;

	public Advogado(String nome, long cpf, long registro, String email, long telefone)
			throws CampoNaoPreenchidoException, FormatoEmailInvalidoException, TelefoneInvalidoException,
			TelefoneNaoNumericoException, CPFInvalidoException, RegistroInvalidoException {

		super(nome, cpf, email, telefone);
		
		if (registro <= 0) {
			throw new RegistroInvalidoException();
		}
		
		this.registro = registro;
	}

	public long getRegistro() {
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
