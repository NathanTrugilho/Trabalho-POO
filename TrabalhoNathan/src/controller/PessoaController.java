package controller;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

import exception.AdvogadoJaExistenteException;
import exception.CNPJInvalidoException;
import exception.CNPJNaoNumericoException;
import exception.CPFInvalidoException;
import exception.CPFNaoNumericoException;
import exception.CampoNaoPreenchidoException;
import exception.FormatoEmailInvalidoException;
import exception.PessoaJaExistenteException;
import exception.PessoaNaoExistenteException;
import exception.PrepostoNaoCadastradoException;
import exception.PrepostoNaoPodeSerNuloException;
import exception.RegistroInvalidoException;
import exception.TelefoneInvalidoException;
import exception.TelefoneNaoNumericoException;
import model.Advogado;
import model.Pessoa;
import model.PessoaFisica;
import model.PessoaJuridica;

public class PessoaController implements Serializable {

	private static final long serialVersionUID = 2931953718446081990L;

	private Map<Long, PessoaFisica> pessoasFisicas;
	private Map<Long, PessoaJuridica> pessoasJuridicas;
	private Map<Long, Advogado> advogados;

	public PessoaController() {

		pessoasFisicas = new TreeMap<>();
		pessoasJuridicas = new TreeMap<>();
		advogados = new TreeMap<>();
	}

	// A chave no meu map de Pessoas físicas será o CPF

	public void addPessoasFisicas(String nome, long cpf, String email, long telefone) throws NumberFormatException,
			CampoNaoPreenchidoException, CPFNaoNumericoException, TelefoneNaoNumericoException, CPFInvalidoException,
			FormatoEmailInvalidoException, TelefoneInvalidoException, PessoaJaExistenteException {

		if (pessoasFisicas.containsKey(cpf)) {
			throw new PessoaJaExistenteException("CPF já cadastrado no sistema!");
		}

		for (Advogado advogado : advogados.values()) {
			if (advogado.getCadastroRF() == cpf) {
				throw new PessoaJaExistenteException("CPF já cadastrado no sistema!");
			}
		}

		pessoasFisicas.put(cpf, new PessoaFisica(nome, cpf, email, telefone));
		MainController.save();
	}

	// A chave no meu map de Pessoas Jurídicas será o CNPJ

	public void addPessoaJuridica(String nome, long cnpj, long preposto, String email, long telefone)
			throws PessoaJaExistenteException, PrepostoNaoCadastradoException, CampoNaoPreenchidoException,
			CNPJNaoNumericoException, NumberFormatException, CNPJInvalidoException, CPFInvalidoException,
			CPFNaoNumericoException, FormatoEmailInvalidoException, TelefoneInvalidoException,
			TelefoneNaoNumericoException, PrepostoNaoPodeSerNuloException {

		if (pessoasJuridicas.containsKey(cnpj)) {
			throw new PessoaJaExistenteException("CNPJ já cadastrado no sistema!");
		}

		if (!pessoasFisicas.containsKey(preposto)) {
			throw new PrepostoNaoCadastradoException();
		}

		pessoasJuridicas.put(cnpj, new PessoaJuridica(nome, cnpj, pessoasFisicas.get(preposto), email, telefone));
		MainController.save();
	}

	// A chave no meu map de Advogados será o registro

	public void addAdvogados(String nome, long cpf, long registro, String email, long telefone)
			throws AdvogadoJaExistenteException, NumberFormatException, CampoNaoPreenchidoException,
			CPFNaoNumericoException, TelefoneNaoNumericoException, CPFInvalidoException, FormatoEmailInvalidoException,
			TelefoneInvalidoException, RegistroInvalidoException, PessoaJaExistenteException {

		if (pessoasFisicas.containsKey(cpf)) {
			throw new PessoaJaExistenteException("CPF já cadastrado no sistema!");
		}

		for (Advogado advogado : advogados.values()) {
			if (advogado.getCadastroRF() == cpf) {
				throw new PessoaJaExistenteException("CPF já cadastrado no sistema!");
			}
		}

		if (advogados.containsKey(registro)) {
			throw new AdvogadoJaExistenteException();
		}

		advogados.put(registro, new Advogado(nome, cpf, registro, email, telefone));
		MainController.save();
	}

	public Pessoa getPessoa(long cadastroRF) throws PessoaNaoExistenteException {
		
		if (pessoasFisicas.containsKey(cadastroRF)) {
			return pessoasFisicas.get(cadastroRF);

		} else if (pessoasJuridicas.containsKey(cadastroRF)) {
			return pessoasFisicas.get(cadastroRF);

		} else if (advogados.containsKey(cadastroRF)) {
			return advogados.get(cadastroRF);

		} else {
			throw new PessoaNaoExistenteException();
		}
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
