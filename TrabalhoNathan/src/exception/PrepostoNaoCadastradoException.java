package exception;

public class PrepostoNaoCadastradoException extends Exception {

	private static final long serialVersionUID = 8425895567332073642L;

	public PrepostoNaoCadastradoException() {
		super("Preposto não cadastrado no sistema!");
	}
}
