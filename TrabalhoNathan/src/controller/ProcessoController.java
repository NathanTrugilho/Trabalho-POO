package controller;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import exception.AtributoNuloException;
import exception.DataInvalidaException;
import exception.DataNulaException;
import exception.NumeroProcessoJaExistenteException;
import model.Cliente;
import model.Pessoa;
import model.Processo;
import model.Tribunal;

public class ProcessoController implements Serializable {

	private static final long serialVersionUID = 4271118252351646738L;

	private Map<Long, Processo> processosSistema;

	public ProcessoController() {
		processosSistema = new TreeMap<>();
	}

	public void addProcesso(long numero, Date dataAbertura, Cliente cliente, Pessoa parteContraria, Tribunal tribunal)
			throws DataNulaException, DataInvalidaException, AtributoNuloException, NumeroProcessoJaExistenteException {
		
		if(processosSistema.containsKey(numero)) {
			throw new NumeroProcessoJaExistenteException();
		}
		
		Processo novoProcesso = new Processo(numero, dataAbertura, cliente, parteContraria, tribunal);
		
		processosSistema.put(numero, novoProcesso);
		
		cliente.addProcesso(novoProcesso);
		
		MainController.save();
	}
	
	public StringBuilder listaProcessos() {

		StringBuilder sb = new StringBuilder();

		for (Processo processo : processosSistema.values()) {
			sb.append(processo.toString());
		}
		
		return sb;
	}

}
