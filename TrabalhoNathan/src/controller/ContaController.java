package controller;

import java.io.Serializable;
import java.util.Date;

import exception.AtributoNuloException;
import exception.ValorInvalidoException;
import exception.ValorPagamentoInvalidoException;
import model.EFormaPagamento;
import model.IConta;

public class ContaController implements Serializable {

	private static final long serialVersionUID = 1064188945696242647L;

	public ContaController() {
	};

	public void addDespesa(IConta conta, Date data, String descricao, double valor)
			throws AtributoNuloException, ValorInvalidoException {
		conta.addDespesa(data, descricao, valor);
		MainController.save();
	}

	public void addPagamento(IConta conta, EFormaPagamento formaPagamento, Date data, double valor)
			throws AtributoNuloException, ValorInvalidoException, ValorPagamentoInvalidoException {

		if (valor > conta.getSaldoConta()) {
			throw new ValorPagamentoInvalidoException(
					"O valor do pagamento não pode ser maior que os débitos pendentes!");
		}

		conta.addPagamento(formaPagamento, data, valor);
		MainController.save();
	}
}
