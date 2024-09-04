package exception;

public class RegistroInvalidoException extends Exception{

	private static final long serialVersionUID = -9004500955141485586L;

	public RegistroInvalidoException() {
		super("Insira um registro válido!");
	}

}
