package exception;

public class AdvogadoJaExistenteException extends Exception{
 
	private static final long serialVersionUID = -5439273811152806825L;

	public AdvogadoJaExistenteException() {
		super("Registro já cadastrado no sistema!");
	}
}