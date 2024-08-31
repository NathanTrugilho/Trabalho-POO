package controller;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

import exception.PessoaFisicaJaExistenteException;
import exception.PessoaJuridicaJaExistenteException;
import exception.PrepostoNaoCadastradoException;
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

	public void addPessoasFisicas(String nome, String cpf, String email, String telefone) throws PessoaFisicaJaExistenteException{
		
		if (pessoasFisicas.containsKey(Long.parseLong(cpf))) {
			throw new PessoaFisicaJaExistenteException("CPF já cadastrado!");
		}
				
		if(email.isBlank()) {
			pessoasFisicas.put(Long.parseLong(cpf), new PessoaFisica(nome, Long.parseLong(cpf), Long.parseLong(telefone)));
			MainController.save();
			return;
		}
		
		if(telefone.isBlank()) {
			pessoasFisicas.put(Long.parseLong(cpf), new PessoaFisica(nome, Long.parseLong(cpf), email));
			MainController.save();
			return;
		}
		
		pessoasFisicas.put(Long.parseLong(cpf), new PessoaFisica(nome, Long.parseLong(cpf), email, Long.parseLong(telefone)));
		MainController.save();		
	}

	// A chave no meu map de Pessoas Jurídicas será o CNPJ ==============================================

	public void addPessoaJuridica(String nome, String cnpj, String preposto, String email, String telefone) throws PessoaJuridicaJaExistenteException, PrepostoNaoCadastradoException {
		
		if (pessoasJuridicas.containsKey(Long.parseLong(cnpj))) {
			throw new PessoaJuridicaJaExistenteException("CNPJ já cadastrado!");
		}
		
		if (!pessoasFisicas.containsKey(Long.parseLong(preposto))) {
			throw new PrepostoNaoCadastradoException("Preposto não cadastrado!");
		}
		
		if(email.isBlank()) {
			pessoasJuridicas.put(Long.parseLong(cnpj), new PessoaJuridica(nome, Long.parseLong(cnpj), pessoasFisicas.get(Long.parseLong(preposto)), Long.parseLong(telefone)));
			MainController.save();
			return;
		}
		
		if(telefone.isBlank()) {
			pessoasJuridicas.put(Long.parseLong(cnpj), new PessoaJuridica(nome, Long.parseLong(cnpj), pessoasFisicas.get(Long.parseLong(preposto)), email));
			MainController.save();
			return;
		}
		
		pessoasJuridicas.put(Long.parseLong(cnpj), new PessoaJuridica(nome, Long.parseLong(cnpj), pessoasFisicas.get(Long.parseLong(preposto)), email, Long.parseLong(telefone)));
		MainController.save();
	}

	// A chave no meu map de Advogados será o registro ==============================================

	public void addAdvogado(String nome, long cpf, long registro, String email, long telefone) {
		advogados.put(registro, new Advogado(nome, cpf, registro, email, telefone));
		MainController.save();
	}

}
