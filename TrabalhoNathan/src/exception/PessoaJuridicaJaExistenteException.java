package exception;

public class PessoaJuridicaJaExistenteException extends Exception{
 
	private static final long serialVersionUID = 5039678994566545981L;

	public PessoaJuridicaJaExistenteException(String message) {
		super(message);
	}

}
