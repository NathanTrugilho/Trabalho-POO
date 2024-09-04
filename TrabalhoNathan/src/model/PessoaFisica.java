package model;

import java.io.Serializable;

import exception.CPFInvalidoException;
import exception.CampoNaoPreenchidoException;
import exception.FormatoEmailInvalidoException;
import exception.TelefoneInvalidoException;
import exception.TelefoneNaoNumericoException;
import util.Utils;

public class PessoaFisica extends Pessoa implements Serializable {

	private static final long serialVersionUID = 2873049312251537530L;

	private final long cpf;

	public PessoaFisica(String nome, long cpf, String email, long telefone)
			throws CampoNaoPreenchidoException, FormatoEmailInvalidoException, TelefoneInvalidoException,
			TelefoneNaoNumericoException, CPFInvalidoException {

		super(nome, email, telefone);
		Utils.validarCPF(cpf);
		this.cpf = cpf;
	}

	@Override
	public long getCadastroRF() {
		return this.cpf;
	}
}