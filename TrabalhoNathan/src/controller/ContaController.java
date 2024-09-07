package controller;

import java.io.Serializable;
import java.util.Date;

import exception.AtributoNuloException;
import exception.ValorInvalidoException;
import model.IConta;

public class ContaController implements Serializable{

	private static final long serialVersionUID = 1064188945696242647L;

	public ContaController(){};
	
	public void addDespesa(IConta conta, Date data, String descricao, double valor) throws AtributoNuloException, ValorInvalidoException {
		conta.addDespesa(data, descricao, valor);
		MainController.save();
	}
}
