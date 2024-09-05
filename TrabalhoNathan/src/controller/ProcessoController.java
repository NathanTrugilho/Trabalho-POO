package controller;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import model.Cliente;
import model.Pessoa;
import model.Processo;
import model.Tribunal;

public class ProcessoController implements Serializable{

	private static final long serialVersionUID = 4271118252351646738L;

	private Map<Long, Processo> processosSistema;
	
	public ProcessoController() {
		processosSistema = new TreeMap<>();
	}
	
	public void addProcesso(long numero, Date dataAbertura, Cliente cliente, Pessoa parteContraria, Tribunal tribunal) {
		
		//processosSistema.put(numero, new Processo(numero, dataAbertura, cliente, parteContraria, tribunal));
		
	}
	
}
