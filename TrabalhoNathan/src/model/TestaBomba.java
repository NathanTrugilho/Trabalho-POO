package model;

public class TestaBomba {

	public static void main(String[] args) {
		PessoaFisica p1 = new PessoaFisica("Rodney", "reidostransportes@rodney.com", 71, 777777777777L);
		PessoaJuridica p2 = new PessoaJuridica("TransportesRC", "reidostransportes@patlick.com", 24, 2222222222222L, p1);
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
	}

}
