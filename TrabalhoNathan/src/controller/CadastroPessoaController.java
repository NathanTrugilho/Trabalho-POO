package controller;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

import exception.CPFInvalidoException;
import exception.CPFNaoNumericoException;
import exception.CampoNaoPreenchidoException;
import exception.PessoaJaExistenteException;
import model.Advogado;
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

	// A chave no meu map de Pessoas físicas será o CPF ==============================================

	public void addPessoasFisicas(String nome, String cpf, String email, String telefone) throws PessoaJaExistenteException{
		
		if (pessoasFisicas.containsKey(Long.parseLong(cpf))) {
			throw new PessoaJaExistenteException("CPF já cadastrado!");
		}
				
		if(email.isBlank()) {
			pessoasFisicas.put(Long.parseLong(cpf), new PessoaFisica(nome, Long.parseLong(cpf), Long.parseLong(telefone)));
			MainController.save();
			return;
		};
		
		if(telefone.isBlank()) {
			pessoasFisicas.put(Long.parseLong(cpf), new PessoaFisica(nome, Long.parseLong(cpf), email));
			MainController.save();
			return;
		};
		
		pessoasFisicas.put(Long.parseLong(cpf), new PessoaFisica(nome, Long.parseLong(cpf), email, Long.parseLong(telefone)));
		MainController.save();		
	}

	// A chave no meu map de Pessoas Jurídicas será o CNPJ ==============================================

	public void addPessoaJuridica(String nome, long cnpj, PessoaFisica preposto, String email, long telefone) {
		pessoasJuridicas.put(cnpj, new PessoaJuridica(nome, cnpj, preposto, email, telefone));
		MainController.save();
	}

	// A chave no meu map de Advogados será o registro ==============================================

	public void addAdvogado(String nome, long cpf, long registro, String email, long telefone) {
		advogados.put(registro, new Advogado(nome, cpf, registro, email, telefone));
		MainController.save();
	}

}
