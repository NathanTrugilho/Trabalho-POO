package exception;

public class RegistroNuloException extends Exception{

	private static final long serialVersionUID = -9004500955141485586L;

	public RegistroNuloException() {
		super("O registro não pode ser nulo!");
	}

}
