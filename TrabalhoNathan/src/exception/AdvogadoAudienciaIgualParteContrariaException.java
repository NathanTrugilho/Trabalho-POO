package exception;

public class AdvogadoAudienciaIgualParteContrariaException extends Exception{

	private static final long serialVersionUID = 5397635513690975653L;

	public AdvogadoAudienciaIgualParteContrariaException() {
		super("O advogado da audiência não pode ser a parte contrária do processo!");
	}

}
