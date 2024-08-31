package exception;

public class TelefoneInvalidoException extends Exception {
 
	private static final long serialVersionUID = 8168473121343215427L;

	public TelefoneInvalidoException(String mensagem) {
        super(mensagem);
    }
}