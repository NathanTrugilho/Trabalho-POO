package exception;

public class CPFInvalidoException extends Exception {
	private static final long serialVersionUID = 1448161098138266372L;

	public CPFInvalidoException(String mensagem) {
		super(mensagem);
	}
}
