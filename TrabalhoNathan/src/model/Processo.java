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
	private final Tribunal tribunal;
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

	public void addPagamento(EFormaPagamento forma, Date data, double valor) {
		conta.addPagamento(forma, data, valor);
	}

	public void addDespesa(Date data, String descricao, double valor) {
		conta.addDespesa(data, descricao, valor);
	}

	public Date getDataConclusao() {
		return dataConclusao;
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

	public void addAudiencia(Advogado advogado, Date data, String recomendacao) {
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

	public void encerraProcesso(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
		this.fase = EFaseProcesso.CONCLUSAO;
	}

	public void encerraProcesso() {
		this.dataConclusao = new Date();
		this.fase = EFaseProcesso.CONCLUSAO;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Numero: " + this.getNumero() + "\n");
		sb.append("Data abertura: " + this.getDataAbertura() + "\n");
		if (this.getFase() == EFaseProcesso.CONCLUSAO) {
			sb.append("Data conclusao: " + this.getDataConclusao() + "\n");
			sb.append("Fase: " + this.getFase() + "\n");
		}
		sb.append("Cliente: " + this.getCliente().getPessoa().getNome() + "\n");
		sb.append("Parte contraria: " + this.getParteContraria() + "\n");
		sb.append("Tribunal: " + this.getTribunal().toString() + "\n");
		sb.append("===== Conta ===== " + this.getConta().getExtrato() + "\n");
		
		return sb.toString();
	}
}
