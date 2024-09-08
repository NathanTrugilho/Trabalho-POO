package model;

import java.io.Serializable;

import exception.CampoNaoPreenchidoException;
import exception.FormatoEmailInvalidoException;
import exception.NomeContemNumerosException;
import exception.TelefoneInvalidoException;
import exception.TelefoneNaoNumericoException;
import util.Utils;

public abstract class Pessoa implements Serializable {

	private static final long serialVersionUID = 1395106238440220596L;

	private String nome;
	private String email;
	private long telefone;

	public Pessoa(String nome, String email, long telefone)
			throws CampoNaoPreenchidoException, FormatoEmailInvalidoException, TelefoneInvalidoException,
			TelefoneNaoNumericoException, NomeContemNumerosException {

		if (nome.isBlank()) {
			throw new CampoNaoPreenchidoException("Insira um nome!");
		}

		Utils.validaNome(nome);
		Utils.validarEmail(email);
		Utils.validarTelefone(telefone);

		this.nome = nome;
		this.email = email;
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

	public abstract String getCadastroRF();

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

		sb.append("\n");
		return sb.toString();
	}

}
