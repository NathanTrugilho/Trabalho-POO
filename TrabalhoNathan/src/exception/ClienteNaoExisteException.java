package exception;

public class ClienteNaoExisteException extends Exception{

	private static final long serialVersionUID = -4380143714685282142L;

	public ClienteNaoExisteException() {
		super("Não existe um cliente cadastrado com este cadastroRF!");
	}
}
