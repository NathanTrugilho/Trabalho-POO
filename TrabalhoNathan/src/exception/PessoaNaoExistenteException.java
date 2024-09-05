package exception;

public class PessoaNaoExistenteException extends Exception{

	private static final long serialVersionUID = -8379140813665293356L;

	public PessoaNaoExistenteException() {
		super("Esta pessoa não existe!");
	}
	
}
