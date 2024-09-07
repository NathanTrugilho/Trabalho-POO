package controller;

import java.io.Serializable;

import persistence.Serializer;

public class MainController implements Serializable {

	private static final long serialVersionUID = 6341528978400871936L;

	private static MainController instance;
	private PessoaController pessoaController;
	private TribunalController tribunalController;
	private ClienteController clienteController;
	private ProcessoController processoController;
	private ContaController contaController;
	
	// declarar os demais controladores

	private MainController() {
		
		pessoaController = new PessoaController();
		tribunalController = new TribunalController();
		clienteController = new ClienteController();
		processoController = new ProcessoController();
		contaController = new ContaController();
		
		// instanciar os demais controladores
	}

	public static MainController getInstance() {
		return instance;
	}

	public static PessoaController getPessoaController() {
		return instance.pessoaController;
	}
	
	public static TribunalController getTribunalController() {
		return instance.tribunalController;
	}
	
	public static ClienteController getClienteController() {
		return instance.clienteController;
	}
	
	public static ProcessoController getProcessoController() {
		return instance.processoController;
	}
	
	public static ContaController getContaController() {
		return instance.contaController;
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
