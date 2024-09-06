package controller;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

import exception.ClienteNaoExisteException;
import exception.ClienteNecessitaPessoa;
import exception.PessoaNaoExistenteException;
import model.Cliente;

public class ClienteController implements Serializable {

	private static final long serialVersionUID = 3788235120261465931L;
	
	//CadastroRF como identificador
	private Map<Long, Cliente> clientes;

	public ClienteController() {
		clientes = new TreeMap<>();
	}

	public void addCliente(long cadastroRF) throws PessoaNaoExistenteException, ClienteNecessitaPessoa {
		clientes.put(cadastroRF, new Cliente(MainController.getPessoaController().getPessoa(cadastroRF)));
		MainController.save();
	}

	public Cliente getCliente(long cadastroRF) throws ClienteNaoExisteException {
		if (clientes.containsKey(cadastroRF)) {
			return clientes.get(cadastroRF);
		} else {
			throw new ClienteNaoExisteException();
		}
	}
}