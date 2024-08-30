package controller;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

import model.Pessoa;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.Advogado;

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

	// A chave no meu map de Pessoas físicas será o CPF ==============================================

	public void addPessoasFisicas(String nome, long cpf, String email, long telefone) {
		pessoasFisicas.put(cpf, new PessoaFisica(nome, cpf, email, telefone));
		MainController.save();
	}

	public void addPessoasFisicas(String nome, long cpf, String email) {
		pessoasFisicas.put(cpf, new PessoaFisica(nome, cpf, email));

	}

	public void addPessoasFisicas(String nome, long cpf, long telefone) {
		pessoasFisicas.put(cpf, new PessoaFisica(nome, cpf, telefone));

	}

	// A chave no meu map de Pessoas Jurídicas será o CNPJ ==============================================

	public void addPessoaJuridica(String nome, long cnpj, PessoaFisica preposto, String email, long telefone) {
		pessoasJuridicas.put(cnpj, new PessoaJuridica(nome, cnpj, preposto, email, telefone));

	}

	public void addPessoaJuridica(String nome, long cnpj, PessoaFisica preposto, String email) {
		pessoasJuridicas.put(cnpj, new PessoaJuridica(nome, cnpj, preposto, email));

	}

	public void addPessoaJuridica(String nome, long cnpj, PessoaFisica preposto, long telefone) {
		pessoasJuridicas.put(cnpj, new PessoaJuridica(nome, cnpj, preposto, telefone));

	}

	// A chave no meu map de Advogados será o registro ==============================================

	public void addAdvogado(String nome, long cpf, long registro, String email, long telefone) {
		advogados.put(registro, new Advogado(nome, cpf, registro, email, telefone));

	}

	public void addAdvogado(String nome, long cpf, long registro, String email) {
		advogados.put(registro, new Advogado(nome, cpf, registro, email));

	}

	public void addAdvogado(String nome, long cpf, long registro, long telefone) {
		advogados.put(registro, new Advogado(nome, cpf, registro, telefone));

	}
}
