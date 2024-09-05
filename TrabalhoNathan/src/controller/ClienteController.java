package controller;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

import exception.ClienteNaoExisteException;
import model.Cliente;

public class ClienteController implements Serializable {

	private static final long serialVersionUID = 3788235120261465931L;

	private Map<Long, Cliente> clientesPF;
	private Map<Long, Cliente> clientesPJ;

	public ClienteController() {
		clientesPF = new TreeMap<>();
		clientesPJ = new TreeMap<>();
	}
	
	public void addClientePF(long cadastroRF) {

	}

	public Cliente getClientePF(long cpf) throws ClienteNaoExisteException {
		if (clientesPF.containsKey(cpf)) {
			System.out.println("bananadepijama");
			return clientesPF.get(cpf);
		} else {
			System.out.println("peganapemga");
			throw new ClienteNaoExisteException();
		}
	}

	public Cliente getClientePJ(long cnpj) throws ClienteNaoExisteException {

		if (clientesPJ.containsKey(cnpj)) {
			return clientesPJ.get(cnpj);
		} else {
			throw new ClienteNaoExisteException();
		}
	}
}
