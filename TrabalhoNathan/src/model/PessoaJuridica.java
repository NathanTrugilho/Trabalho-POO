package model;

import java.io.Serializable;

import exception.CNPJInvalidoException;
import exception.CampoNaoPreenchidoException;
import exception.FormatoEmailInvalidoException;
import exception.PrepostoNaoPodeSerNuloException;
import exception.TelefoneInvalidoException;
import exception.TelefoneNaoNumericoException;
import util.Utils;

public class PessoaJuridica extends Pessoa implements Serializable {

	private static final long serialVersionUID = 833265267744814155L;

	private final String cnpj;
	private PessoaFisica preposto;

	public PessoaJuridica(String nome, String cnpj, PessoaFisica preposto, String email, long telefone)
			throws CampoNaoPreenchidoException, FormatoEmailInvalidoException, TelefoneInvalidoException,
			TelefoneNaoNumericoException, CNPJInvalidoException, PrepostoNaoPodeSerNuloException {

		super(nome, email, telefone);

		Utils.validarCNPJ(cnpj);

		if (preposto == null) {
			throw new PrepostoNaoPodeSerNuloException();
		}

		this.cnpj = cnpj;
		this.preposto = preposto;
	}

	@Override
	public String getCadastroRF() {
		return this.cnpj;
	}

	public PessoaFisica getPreposto() {
		return preposto;
	}

	public void setPreposto(PessoaFisica preposto) {
		this.preposto = preposto;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Preposto: " + getPreposto().getCadastroRF() + "\n");
		sb.append(super.toString());

		return sb.toString();
	}

}
