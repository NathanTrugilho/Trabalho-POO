package exception;

public class PessoaJaExistenteException extends Exception{
 
	private static final long serialVersionUID = 5039678994566545981L;

	public PessoaJaExistenteException(String message) {
		super(message);
	}

}
