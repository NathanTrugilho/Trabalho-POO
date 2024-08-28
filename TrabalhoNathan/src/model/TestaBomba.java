package model;

import java.util.Date;

public class TestaBomba {

	public static void main(String[] args) {
		PessoaFisica p1 = new PessoaFisica("Rodney", 159, 129837);
		PessoaJuridica p2 = new PessoaJuridica("TransportesRC", 91287, p1, "marquinhos", 91284);
		Advogado a1 = new Advogado("Serginho", 159, 42, "sergindopneu@hotmail.com", 97235);
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(a1.toString());
		
		Audiencia aud1 = new Audiencia(a1, new Date(), "Matar polícia");
		
		System.out.println(aud1);
		
		Conta c1 = new Conta();
		c1.addDespesa(new Date(), "Honorarios", 400);
		c1.addDespesa(new Date(), "Xerox", 50);
		c1.addDespesa(new Date(), "Uber", 752);
		c1.addPagamento(EFormaPagamento.DINHEIRO, new Date(), 300);
		c1.addPagamento(EFormaPagamento.PIX, new Date(), 285);
		
		System.out.println(c1.getTotalDespesas());
		System.out.println(c1.getTotalPagamentos());
		System.out.println(c1.getSaldoConta());
		
		System.out.println(c1.getExtrato().toString());
		
	}
	
	
}
