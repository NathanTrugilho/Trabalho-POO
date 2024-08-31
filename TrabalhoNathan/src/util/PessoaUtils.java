package util;

import exception.CPFInvalidoException;
import exception.CPFNaoNumericoException;
import exception.CampoNaoPreenchidoException;
import exception.FormatoEmailInvalidoException;
import exception.NecessarioAlgumMeioComunicacao;
import exception.TelefoneNaoNumerico;

public class PessoaUtils {

	public static void validarCPF(String cpf) throws CPFInvalidoException {

		// Verifica se o CPF contém 11 dígitos
		if (cpf.length() != 11) {
			throw new CPFInvalidoException("CPF deve conter 11 dígitos!");
		}

		// Verifica se o CPF é uma sequência repetida (ex: 111.111.111-11)
		if (cpf.matches("(\\d)\\1{10}")) {
			throw new CPFInvalidoException("CPF inválido!");
		}

		// Verificação dos dígitos verificadores
		if (!isCPFValid(cpf)) {
			throw new CPFInvalidoException("CPF inválido!");
		}
	}

	private static boolean isCPFValid(String cpf) {
		
		// Cálculo do primeiro dígito verificador
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			sum += (cpf.charAt(i) - '0') * (10 - i);
		}
		int firstDigit = 11 - (sum % 11);
		if (firstDigit >= 10) {
			firstDigit = 0;
		}

		// Cálculo do segundo dígito verificador
		sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += (cpf.charAt(i) - '0') * (11 - i);
		}
		int secondDigit = 11 - (sum % 11);
		if (secondDigit >= 10) {
			secondDigit = 0;
		}

		// Comparação com os dígitos verificadores do CPF
		return (firstDigit == cpf.charAt(9) - '0') && (secondDigit == cpf.charAt(10) - '0');
	}


	public static void validarCadastroPessoaFisica(String nome, String cpf, String email, String telefone) 
			throws CampoNaoPreenchidoException, NecessarioAlgumMeioComunicacao, CPFNaoNumericoException, 
			TelefoneNaoNumerico, CPFInvalidoException, FormatoEmailInvalidoException{
		
		if (nome.isBlank()) {
			throw new CampoNaoPreenchidoException("Insira um nome!");
		}
		
		if (cpf.isBlank()) {
			throw new CampoNaoPreenchidoException("Insira um CPF!");
		}
		
		if (!cpf.matches("\\d+")) {
			throw new CPFNaoNumericoException("CPF deve conter apenas números!");
		}
		
		PessoaUtils.validarCPF(cpf);
		
		if (!telefone.matches("\\d+") && !telefone.isBlank()) {
			throw new TelefoneNaoNumerico("telefone deve conter apenas números!");
		}
		
		if(!email.contains("@") && !email.isBlank()) {
			throw new FormatoEmailInvalidoException("Formato de email inválido!");
		}
		
		if (telefone.isBlank() && email.isBlank()) {
			throw new NecessarioAlgumMeioComunicacao("Insira ao menos um meio de comunicação!");
		}
		
	}
	
	
}