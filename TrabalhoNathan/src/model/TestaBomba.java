package model;

import java.util.Date;

public class TestaBomba {

	public static void main(String[] args) {
		PessoaFisica p1 = new PessoaFisica("Rodney", 159, 129837);
		PessoaJuridica p2 = new PessoaJuridica("TransportesRC", 91287, p1, "marquinhos", 91284);
		Advogado a1 = new Advogado("Serginho", 159, 42, "serginhoDaAdvocacia@hotmail.com", 97235);

		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(a1.toString());

		Audiencia aud1 = new Audiencia(a1, new Date(), "Seja formal");

		System.out.println(aud1.toString());

		Cliente c1 = new Cliente(p1);

		Tribunal t1 = new Tribunal("TVA", "SC09", "Tribunal da lagoinha");
		System.out.println(t1.toString());

		Processo pr1 = new Processo(1, new Date(), c1, a1, t1);

		pr1.addDespesa(new Date(), "Honorarios", 400);
		pr1.addDespesa(new Date(), "Xerox", 50);
		pr1.addDespesa(new Date(), "Uber", 752);

		pr1.addPagamento(EFormaPagamento.DINHEIRO, new Date(), 300);
		pr1.addPagamento(EFormaPagamento.PIX, new Date(), 285);

		System.out.println(pr1.getTotalCustas());
		
		System.out.println(pr1.getConta().getTotalPagamentos());
		
		System.out.println(pr1.getConta().getSaldoConta());
		
		System.out.println(c1.getPessoa().toString());

		pr1.encerraProcesso();
		System.out.println(pr1.toString());
	}

}
