package controller;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

import exception.TribunalJaExistenteException;
import model.Tribunal;

public class CadastroTribunalController implements Serializable {

	private static final long serialVersionUID = 7635655547230415940L;

	private Map<String, Tribunal> tribunais;

	public CadastroTribunalController() {
		tribunais = new TreeMap<>();
	}

	public void addTribunal(String sigla, String secao, String descricao) throws TribunalJaExistenteException {

		if (tribunais.containsKey(sigla)) {
			throw new TribunalJaExistenteException("Já existe um tribunal com a sigla: " + sigla);
		}
		
		tribunais.put(sigla, new Tribunal(sigla, secao, descricao));
		MainController.save();
	}

	public StringBuilder listaTribunais() {
		StringBuilder sb = new StringBuilder();
		
		for (Tribunal tribunal : tribunais.values()) {
			sb.append(tribunal.toString());
		}
		
		return sb;
	}
}
