package exception;

public class DataInvalidaException extends Exception{

	private static final long serialVersionUID = 4865337805395333987L;

	public DataInvalidaException() {
		super("insira uma data válida!");
	}
}
