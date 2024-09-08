package exception;

public class NomeContemNumerosException extends Exception{

	private static final long serialVersionUID = -2303543432444246293L;

	public NomeContemNumerosException() {
		super("Um nome não pode conter números!");
	}

}
