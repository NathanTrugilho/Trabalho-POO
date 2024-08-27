package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Processo {

	private final long numero;
	private final Date dataAbertura;
	private Date dataConclusao;
	private EFaseProcesso fase;
	private final Cliente cliente;
	private final Pessoa parteContraria;
	private Tribunal tribunal;
	private final IConta conta;
	private List<Audiencia> audiencias = new ArrayList<>();

	public Processo(long numero, Date dataAbertura, Cliente cliente, Pessoa parteContraria, Tribunal tribunal) {
		this.fase = EFaseProcesso.INICIAL;
		this.dataConclusao = null;
		this.numero = numero;
		this.dataAbertura = dataAbertura;
		this.cliente = cliente;
		this.parteContraria = parteContraria;
		this.tribunal = tribunal;
		this.conta = new Conta();
	}

	public Date getDataConclusao() {
		return dataConclusao;
	}

	private void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
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

	public void setTribunal(Tribunal tribunal) {
		this.tribunal = tribunal;
	}

	public StringBuilder getAudiencias() {
		return ;
	}

	public void addAudiencia(Audiencia audiencia) {
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
		
	}
	
	public double getTotalCustas() {
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
