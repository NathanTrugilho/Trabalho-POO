package exception;

public class NumeroProcessoInvalidoException extends Exception{

	private static final long serialVersionUID = -7975870415674363911L;
	
	public NumeroProcessoInvalidoException() {
		super("Insira um número de processo válido!");
	}

}
