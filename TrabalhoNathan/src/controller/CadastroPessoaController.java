package controller;

import java.io.Serializable;
import java.util.Map;

import model.Pessoa;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.Advogado;

public class CadastroPessoaController implements Serializable{

	private static final long serialVersionUID = 2931953718446081990L;

	private Map<Long, Pessoa> pessoasFisicas;
	private Map<Long, Pessoa> pessoasJuridicas;
	private Map<Long, Pessoa> advogados;
	
	
}
