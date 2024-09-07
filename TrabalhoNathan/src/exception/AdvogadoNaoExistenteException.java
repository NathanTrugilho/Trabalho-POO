package exception;

public class AdvogadoNaoExistenteException extends Exception{

	private static final long serialVersionUID = -5905971106771372151L;

	public AdvogadoNaoExistenteException() {
		super("Este advogado não existe no sistema!");
	}
}
