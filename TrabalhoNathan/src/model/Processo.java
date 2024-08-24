package model;

import java.util.ArrayList;
import java.util.List;

public class Processo {

	private List<Audiencia> audiencias = new ArrayList<>();
	private Tribunal tribunal;
	private IConta conta;
	private Cliente cliente;
	
	public Processo() {
	}

}
