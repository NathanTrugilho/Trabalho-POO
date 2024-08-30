package exception;

public class TribunalJaExisteException extends Exception {
	
	private static final long serialVersionUID = 160683976610211867L;

	public TribunalJaExisteException(String message) {
        super(message);
    }
}