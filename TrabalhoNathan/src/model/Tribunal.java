package model;

public class Tribunal {
	private final String sigla;
	private final String secao;
	private final String descricao;

	public Tribunal(String sigla, String secao, String descricao) {
		this.sigla = sigla;
		this.descricao = descricao;
		this.secao = secao;
	}

	public String getSigla() {
		return sigla;
	}

	public String getSecao() {
		return secao;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Sigla: " + this.getSigla() + "\tSeção: " + this.getSecao() + "\n");
		
		sb.append("Descricao: " + this.getDescricao() + "\n\n");
		
		return sb.toString();
	}
}
