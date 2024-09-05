package exception;

public class TribunalJaExistenteException extends Exception {
	
	private static final long serialVersionUID = 160683976610211867L;

	public TribunalJaExistenteException() {
        super("Já existe um tribunal com esta sigla!");
    }
}