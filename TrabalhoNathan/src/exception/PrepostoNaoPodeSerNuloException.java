package exception;

public class PrepostoNaoPodeSerNuloException extends Exception{

	private static final long serialVersionUID = 8477677051599173705L;

	public PrepostoNaoPodeSerNuloException() {
		super("O preposto não pode ser nulo!");
	}

}
