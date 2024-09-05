package exception;

public class ClienteNecessitaPessoa extends Exception{

	private static final long serialVersionUID = -4508921557377586568L;

	public ClienteNecessitaPessoa() {
		super("Cliente não pode ser instanciado sem uma Pessoa associada a ele!");
	}

}
