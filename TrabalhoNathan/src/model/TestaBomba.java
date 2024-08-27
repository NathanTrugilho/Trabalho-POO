package model;

public class TestaBomba {

	public static void main(String[] args) {
		PessoaFisica p1 = new PessoaFisica("Rodney", 159, 129837);
		PessoaJuridica p2 = new PessoaJuridica("TransportesRC", 91287, p1, "marquinhos", 91284);
		Advogado a1 = new Advogado("Serginho", 159, 42, "sergindopneu@hotmail.com", 97235);
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(a1.toString());
	}

}
