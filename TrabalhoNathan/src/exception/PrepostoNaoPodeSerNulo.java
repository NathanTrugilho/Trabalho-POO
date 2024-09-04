package exception;

public class PrepostoNaoPodeSerNulo extends Exception{

	private static final long serialVersionUID = 8477677051599173705L;

	public PrepostoNaoPodeSerNulo() {
		super("O preposto não pode ser nulo!");
	}

}
