package exception;

public class CPFNaoNumericoException extends Exception {
    private static final long serialVersionUID = 3062650248244691388L;

	public CPFNaoNumericoException(String mensagem) {
        super(mensagem);
    }
}