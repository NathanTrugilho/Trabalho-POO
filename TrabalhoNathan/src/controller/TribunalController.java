package controller;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

import exception.CampoNaoPreenchidoException;
import exception.TribunalJaExistenteException;
import exception.TribunalNaoExistenteException;
import model.Tribunal;

public class TribunalController implements Serializable {

	private static final long serialVersionUID = 7635655547230415940L;

	private Map<String, Tribunal> tribunais;

	public TribunalController() {
		tribunais = new TreeMap<>();
	}

	public void addTribunal(String sigla, String secao, String descricao) throws TribunalJaExistenteException, CampoNaoPreenchidoException {
		
		if (tribunais.containsKey(sigla)) {
			throw new TribunalJaExistenteException();
		}
		
		tribunais.put(sigla, new Tribunal(sigla, secao, descricao));
		MainController.save();
	}

	public Tribunal getTribunal(String sigla) throws TribunalNaoExistenteException  {
		if (tribunais.containsKey(sigla)) {
			return tribunais.get(sigla);
		} else {
			throw new TribunalNaoExistenteException();
		}
	}
	
	public StringBuilder listaTribunais() {
		StringBuilder sb = new StringBuilder();
		
		for (Tribunal tribunal : tribunais.values()) {
			sb.append(tribunal.toString());
		}
		
		return sb;
	}
}
