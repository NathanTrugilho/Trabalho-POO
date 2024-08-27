package model;

public class Tribunal {
	private final String sigla;
	private final String descricao;
	private final String secao;

	public Tribunal(String sigla, String descricao, String secao) {
		this.sigla = sigla;
		this.descricao = descricao;
		this.secao = secao;
	}

	public String getSigla() {
		return sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getSecao() {
		return secao;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
