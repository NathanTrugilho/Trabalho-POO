package controller;

import java.io.Serializable;

import persistence.Serializer;

public class MainController implements Serializable {

	private static final long serialVersionUID = 6341528978400871936L;

	private static MainController instance;

	
	private CadastroPessoaController cadastroPessoaController;
	private CadastroTribunalController cadastrotribunalController;
	
	// declarar os demais controladores

	
	private MainController() {
		
		//catalogoController = new CatalogoController();
		cadastroPessoaController = new CadastroPessoaController();
		cadastrotribunalController = new CadastroTribunalController();
		// instanciar os demais controladores
		
	}

	public static MainController getInstance() {
		return instance;
	}

	
	/*public static CatalogoController getCatalogoController() {
		return instance.catalogoController;
	}*/

	public static CadastroPessoaController getCadastroPessoaController() {
		return instance.cadastroPessoaController;
	}
	
	public static CadastroTribunalController getCadastroTribunalController() {
		return instance.cadastrotribunalController;
	}
	
	// implementar metodos acessadores estaticos para os demais controladores
	
	
	public static void load() {

		instance = Serializer.readFile();

		if (instance == null) {
			instance = new MainController();
		}
	}

	public static void save() {
		Serializer.writeFile(instance);
	}
}
