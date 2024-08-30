package controller;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

import exception.TribunalJaExisteException;
import model.Tribunal;

public class CadastroTribunalController implements Serializable {

	private static final long serialVersionUID = 7635655547230415940L;

	private Map<String, Tribunal> tribunais;

	public CadastroTribunalController() {
		tribunais = new TreeMap<>();
	}

	public void addTribunal(String sigla, String secao, String descricao) throws TribunalJaExisteException {

		if (MainController.getCadastroTribunalController().procuraTribunal(sigla)) {
			throw new TribunalJaExisteException("Já existe um tribunal com a sigla: " + sigla);
		}
		
		tribunais.put(sigla, new Tribunal(sigla, secao, descricao));
		MainController.save();
		
		System.out.println(MainController.getCadastroTribunalController().tribunais.get(sigla));
	}

	private boolean procuraTribunal(String sigla) {
		return tribunais.containsKey(sigla);
	}
}
