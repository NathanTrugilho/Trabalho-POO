package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import exception.AtributoNuloException;
import exception.DataInvalidaException;
import exception.DataNulaException;
import exception.NumeroProcessoInvalidoException;
import exception.ValorInvalidoException;

public class Processo implements Serializable {

	private static final long serialVersionUID = -4886434207815843672L;

	private final long numero;
	private final Date dataAbertura;
	private EFaseProcesso fase;
	private final Cliente cliente;
	private final Pessoa parteContraria;
	private final Tribunal tribunal;
	private final IConta conta;
	private List<Audiencia> audiencias = new ArrayList<>();

	public Processo(long numero, Date dataAbertura, Cliente cliente, Pessoa parteContraria, Tribunal tribunal)
			throws DataNulaException, DataInvalidaException, AtributoNuloException, NumeroProcessoInvalidoException {
		
		if(numero <= 0) {
			throw new NumeroProcessoInvalidoException();
		}
		
		if (dataAbertura == null) {
			throw new AtributoNuloException("Data não pode ser nula na criação de um processo!");
		}
		
		if (cliente == null) {
			throw new AtributoNuloException("cliente não pode ser nulo na criação de um processo!");
		}
		
		if (parteContraria == null) {
			throw new AtributoNuloException("parteContraria não pode ser nulo na criação de um processo!");
		}
		
		if (tribunal == null) {
			throw new AtributoNuloException("tribunal não pode ser nulo na criação de um processo!");
		}
				
		this.fase = EFaseProcesso.INICIAL;
		this.numero = numero;
		this.dataAbertura = dataAbertura;
		this.cliente = cliente;
		this.parteContraria = parteContraria;
		this.tribunal = tribunal;
		this.conta = new Conta();
	}

	public void addPagamento(EFormaPagamento forma, Date data, double valor) throws AtributoNuloException, ValorInvalidoException {
		conta.addPagamento(forma, data, valor);
	}

	public void addDespesa(Date data, String descricao, double valor) throws AtributoNuloException, ValorInvalidoException {
		conta.addDespesa(data, descricao, valor);
	}

	public EFaseProcesso getFase() {
		return fase;
	}

	public void setFase(EFaseProcesso fase) {
		this.fase = fase;
	}

	public Tribunal getTribunal() {
		return tribunal;
	}

	public StringBuilder getAudiencias() {

		StringBuilder sb = new StringBuilder();

		for (Audiencia audiencia : audiencias) {
			sb.append(audiencia.toString());
		}

		return sb;
	}

	public void addAudiencia(Advogado advogado, Date data, String recomendacao) throws AtributoNuloException {
		Audiencia audiencia = new Audiencia(advogado, data, recomendacao);
		audiencias.add(audiencia);
	}

	public long getNumero() {
		return numero;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Pessoa getParteContraria() {
		return parteContraria;
	}

	public IConta getConta() {
		return conta;
	}

	public StringBuilder getExtratoContas() {
		return this.conta.getExtrato();
	}

	public double getTotalCustas() {
		return this.conta.getTotalDespesas();
	}

	@Override
	public String toString() {
		return "Numero do Processo: " + this.getNumero();
	}
}
