package exception;

public class DataFormatoErradoException extends Exception{

	private static final long serialVersionUID = 4865337805395333987L;

	public DataFormatoErradoException() {
		super("insira uma data no formato dd/MM/yyyy!");
	}
}
