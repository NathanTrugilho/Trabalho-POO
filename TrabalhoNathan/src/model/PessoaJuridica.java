package model;

import java.io.Serializable;

import exception.CNPJInvalidoException;
import exception.CampoNaoPreenchidoException;
import exception.FormatoEmailInvalidoException;
import exception.PrepostoNaoPodeSerNulo;
import exception.TelefoneInvalidoException;
import exception.TelefoneNaoNumericoException;
import util.Utils;

public class PessoaJuridica extends Pessoa implements Serializable {

	private static final long serialVersionUID = 833265267744814155L;

	private final long cnpj;
	private PessoaFisica preposto;

	public PessoaJuridica(String nome, long cnpj, PessoaFisica preposto, String email, long telefone)
			throws CampoNaoPreenchidoException, FormatoEmailInvalidoException, TelefoneInvalidoException,
			TelefoneNaoNumericoException, CNPJInvalidoException, PrepostoNaoPodeSerNulo {

		super(nome, email, telefone);

		Utils.validarCNPJ(cnpj);
		if (preposto == null) {
			throw new PrepostoNaoPodeSerNulo();
		}

		this.cnpj = cnpj;
		this.preposto = preposto;
	}

	@Override
	public long getCadastroRF() {
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
