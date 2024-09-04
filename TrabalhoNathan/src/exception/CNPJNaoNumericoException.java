package exception;

public class CNPJNaoNumericoException extends Exception {

	private static final long serialVersionUID = -3867456908042918987L;

	public CNPJNaoNumericoException() {
		super("CNPJ deve conter apenas números!");
	}

}
