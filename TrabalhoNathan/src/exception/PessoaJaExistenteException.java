package exception;

public class PessoaJaExistenteException extends Exception {

	private static final long serialVersionUID = -6831280139760270884L;

	public PessoaJaExistenteException(String message) {
		super(message);
	}
}
