package exception;

public class TelefoneNaoNumerico extends Exception {

	private static final long serialVersionUID = -3468672052764344031L;

	public TelefoneNaoNumerico(String message){
		super(message);
	}
}
