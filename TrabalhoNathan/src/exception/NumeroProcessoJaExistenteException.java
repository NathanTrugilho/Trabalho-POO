package exception;

public class NumeroProcessoJaExistenteException extends Exception{

	private static final long serialVersionUID = 2651328741821440534L;

	public NumeroProcessoJaExistenteException() {
		super("Já existe um processo com este número!");
	}
}
