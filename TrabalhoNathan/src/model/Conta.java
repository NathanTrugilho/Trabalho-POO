package model;

import java.util.ArrayList;
import java.util.List;

public class Conta implements IConta{
	
	private List<Despesas> despesas = new ArrayList<>();
	private List<Despesas> pagamentos = new ArrayList<>();
	
	public Conta() {
	}

}
