package exception;

public class PessoaFisicaJaExistenteException extends Exception {

	private static final long serialVersionUID = -6831280139760270884L;

	public PessoaFisicaJaExistenteException(String message) {
		super(message);
	}
}
