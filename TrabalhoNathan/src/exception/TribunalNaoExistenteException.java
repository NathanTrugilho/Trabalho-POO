package exception;

public class TribunalNaoExistenteException extends Exception {

	private static final long serialVersionUID = 6175388636060928386L;

	public TribunalNaoExistenteException() {
        super("Não existe um tribunal com esta sigla!");
    }
}