package controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import exception.AdvogadoAudienciaIgualParteContrariaException;
import exception.AtributoNuloException;
import exception.ClienteNaoExisteException;
import exception.DataInvalidaException;
import exception.DataNulaException;
import exception.NumeroProcessoInvalidoException;
import exception.NumeroProcessoJaExistenteException;
import exception.PessoaNaoExistenteException;
import model.Advogado;
import model.Cliente;
import model.Pessoa;
import model.Processo;
import model.Tribunal;

public class ProcessoController implements Serializable {

	private static final long serialVersionUID = 4271118252351646738L;

	private Map<Long, Processo> processosSistema;

	public ProcessoController() {
		processosSistema = new TreeMap<>();
	}

	public void addProcesso(long numero, Date dataAbertura, Cliente cliente, Pessoa parteContraria, Tribunal tribunal)
			throws DataNulaException, DataInvalidaException, AtributoNuloException, NumeroProcessoJaExistenteException,
			NumeroProcessoInvalidoException {

		if (processosSistema.containsKey(numero)) {
			throw new NumeroProcessoJaExistenteException();
		}

		Processo novoProcesso = new Processo(numero, dataAbertura, cliente, parteContraria, tribunal);

		processosSistema.put(numero, novoProcesso);

		cliente.addProcesso(novoProcesso);
		MainController.save();
	}

	public List<Processo> getProcessos(String cadastroRF) throws ClienteNaoExisteException {
		return MainController.getClienteController().getProcessos(cadastroRF);
	}

	public void addAudiencia(Processo processo, Advogado advogado, Date data, String recomendação)
			throws AtributoNuloException, PessoaNaoExistenteException, AdvogadoAudienciaIgualParteContrariaException {

		if (processo.getParteContraria() == MainController.getPessoaController().getPessoa(advogado.getCadastroRF())) {
			throw new AdvogadoAudienciaIgualParteContrariaException();
		}

		processo.addAudiencia(advogado, data, recomendação);
		MainController.save();
	}

	public StringBuilder listaProcessos() {

		StringBuilder sb = new StringBuilder();

		for (Processo processo : processosSistema.values()) {
			sb.append(processo.toString());
		}

		return sb;
	}

}
