package exception;

public class FormatoEmailInvalidoException extends Exception{

	private static final long serialVersionUID = -7346402772509660565L;

	public FormatoEmailInvalidoException(String message) {
		super(message);
	}
}