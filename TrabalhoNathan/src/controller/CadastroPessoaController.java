package controller;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

import exception.AdvogadoJaExistenteException;
import exception.PessoaFisicaJaExistenteException;
import exception.PessoaJuridicaJaExistenteException;
import exception.PrepostoNaoCadastradoException;
import model.Advogado;
import model.Pessoa;
import model.PessoaFisica;
import model.PessoaJuridica;

public class CadastroPessoaController implements Serializable {

	private static final long serialVersionUID = 2931953718446081990L;

	private Map<Long, PessoaFisica> pessoasFisicas;
	private Map<Long, PessoaJuridica> pessoasJuridicas;
	private Map<Long, Advogado> advogados;

	public CadastroPessoaController() {

		pessoasFisicas = new TreeMap<>();
		pessoasJuridicas = new TreeMap<>();
		advogados = new TreeMap<>();
	}

	// A chave no meu map de Pessoas físicas será o CPF

	public void addPessoasFisicas(String nome, String cpf, String email, String telefone)
			throws PessoaFisicaJaExistenteException {

		if (pessoasFisicas.containsKey(Long.parseLong(cpf))) {
			throw new PessoaFisicaJaExistenteException("CPF já cadastrado no sistema");
		}
		
		for (Advogado advogado : advogados.values()) {
			if (advogado.getCadastroRF() == Long.parseLong(cpf)) {
				throw new PessoaFisicaJaExistenteException("CPF já cadastrado no sistema");
			}
		}
		
		if (email.isBlank()) {
			pessoasFisicas.put(Long.parseLong(cpf),
					new PessoaFisica(nome, Long.parseLong(cpf), Long.parseLong(telefone)));
			MainController.save();
			return;
		}

		if (telefone.isBlank()) {
			pessoasFisicas.put(Long.parseLong(cpf), new PessoaFisica(nome, Long.parseLong(cpf), email));
			MainController.save();
			return;
		}

		pessoasFisicas.put(Long.parseLong(cpf),
				new PessoaFisica(nome, Long.parseLong(cpf), email, Long.parseLong(telefone)));
		MainController.save();
	}

	// A chave no meu map de Pessoas Jurídicas será o CNPJ

	public void addPessoaJuridica(String nome, String cnpj, String preposto, String email, String telefone)
			throws PessoaJuridicaJaExistenteException, PrepostoNaoCadastradoException {

		if (pessoasJuridicas.containsKey(Long.parseLong(cnpj))) {
			throw new PessoaJuridicaJaExistenteException("CNPJ já cadastrado no sistema!");
		}

		if (!pessoasFisicas.containsKey(Long.parseLong(preposto))) {
			throw new PrepostoNaoCadastradoException("Preposto não cadastrado no sistema!");
		}

		if (email.isBlank()) {
			pessoasJuridicas.put(Long.parseLong(cnpj), new PessoaJuridica(nome, Long.parseLong(cnpj),
					pessoasFisicas.get(Long.parseLong(preposto)), Long.parseLong(telefone)));
			MainController.save();
			return;
		}

		if (telefone.isBlank()) {
			pessoasJuridicas.put(Long.parseLong(cnpj), new PessoaJuridica(nome, Long.parseLong(cnpj),
					pessoasFisicas.get(Long.parseLong(preposto)), email));
			MainController.save();
			return;
		}

		pessoasJuridicas.put(Long.parseLong(cnpj), new PessoaJuridica(nome, Long.parseLong(cnpj),
				pessoasFisicas.get(Long.parseLong(preposto)), email, Long.parseLong(telefone)));
		MainController.save();
	}

	// A chave no meu map de Advogados será o registro

	public void addAdvogados(String nome, String cpf, String registro, String email, String telefone)
			throws PessoaFisicaJaExistenteException, AdvogadoJaExistenteException {

		if (pessoasFisicas.containsKey(Long.parseLong(cpf))) {
			throw new PessoaFisicaJaExistenteException("CPF já cadastrado no sistema!");
		}
		
		if (advogados.containsKey(Long.parseLong(registro))) {
			throw new AdvogadoJaExistenteException("Registro já cadastrado no sistema!");
		}
		
		if (email.isBlank()) {
			pessoasFisicas.put(Long.parseLong(cpf),
					new PessoaFisica(nome, Long.parseLong(cpf), Long.parseLong(telefone)));
			MainController.save();
			return;
		}

		if (telefone.isBlank()) {
			pessoasFisicas.put(Long.parseLong(cpf), new PessoaFisica(nome, Long.parseLong(cpf), email));
			MainController.save();
			return;
		}

		advogados.put(Long.parseLong(registro),
				new Advogado(nome, Long.parseLong(cpf), Long.parseLong(registro), email, Long.parseLong(telefone)));
		MainController.save();
	}

	public StringBuilder listaPessoas() {

		StringBuilder sb = new StringBuilder();

		for (Pessoa pessoa : pessoasFisicas.values()) {
			sb.append(pessoa.toString());
		}

		for (Pessoa pessoa : pessoasJuridicas.values()) {
			sb.append(pessoa.toString());
		}

		for (Pessoa pessoa : advogados.values()) {
			sb.append(pessoa.toString());
		}

		return sb;
	}

}
