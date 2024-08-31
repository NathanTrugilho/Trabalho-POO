package util;

import exception.CNPJInvalidoException;
import exception.CNPJNaoNumericoException;
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

	public static void validarCNPJ(String cnpj) throws CNPJInvalidoException {

		// Verifica se o CNPJ tem 14 dígitos
		if (cnpj.length() != 14) {
			throw new CNPJInvalidoException("CNPJ deve conter 14 dígitos");
		}

		// Verifica se todos os dígitos são iguais (ex: 11.111.111/1111-11)
		if (cnpj.matches("(\\d)\\1{13}")) {
			throw new CNPJInvalidoException("CNPJ inválido!");
		}

		// Cálculo do primeiro dígito verificador
		int soma = 0;
		int[] multiplicadores1 = { 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
		for (int i = 0; i < 12; i++) {
			soma += Character.getNumericValue(cnpj.charAt(i)) * multiplicadores1[i];
		}
		int primeiroDigitoVerificador = 11 - (soma % 11);
		if (primeiroDigitoVerificador >= 10) {
			primeiroDigitoVerificador = 0;
		}

		// Cálculo do segundo dígito verificador
		soma = 0;
		int[] multiplicadores2 = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
		for (int i = 0; i < 13; i++) {
			soma += Character.getNumericValue(cnpj.charAt(i)) * multiplicadores2[i];
		}
		int segundoDigitoVerificador = 11 - (soma % 11);
		if (segundoDigitoVerificador >= 10) {
			segundoDigitoVerificador = 0;
		}

		// Verifica se os dígitos calculados coincidem com os dígitos do CNPJ
		if (!(cnpj.charAt(12) == Character.forDigit(primeiroDigitoVerificador, 10)
				&& cnpj.charAt(13) == Character.forDigit(segundoDigitoVerificador, 10))) {
			throw new CNPJInvalidoException("CNPJ inválido!");
		}
	}

	public static void validarCadastroPessoaFisica(String nome, String cpf, String email, String telefone)
			throws CampoNaoPreenchidoException, NecessarioAlgumMeioComunicacao, CPFNaoNumericoException,
			TelefoneNaoNumerico, CPFInvalidoException, FormatoEmailInvalidoException {

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

		if (!email.contains("@") && !email.isBlank()) {
			throw new FormatoEmailInvalidoException("Formato de email inválido!");
		}

		if (telefone.isBlank() && email.isBlank()) {
			throw new NecessarioAlgumMeioComunicacao("Insira ao menos um meio de comunicação!");
		}

	}

	public static void validarCadastroPessoaJuridica(String nome, String cnpj, String preposto, String email,
			String telefone) throws CampoNaoPreenchidoException, NecessarioAlgumMeioComunicacao, TelefoneNaoNumerico,
			FormatoEmailInvalidoException, CNPJNaoNumericoException, CNPJInvalidoException, CPFInvalidoException, CPFNaoNumericoException {

		if (nome.isBlank()) {
			throw new CampoNaoPreenchidoException("Insira um nome!");
		}

		if (cnpj.isBlank()) {
			throw new CampoNaoPreenchidoException("Insira um CNPJ!");
		}

		if (!cnpj.matches("\\d+")) {
			throw new CNPJNaoNumericoException("CNPJ deve conter apenas números!");
		}

		PessoaUtils.validarCNPJ(cnpj);
		
		if (preposto.isBlank()) {
			throw new CampoNaoPreenchidoException("Insira um Preposto!");
		}

		if (!preposto.matches("\\d+")) {
			throw new CPFNaoNumericoException("Preposto deve conter apenas números!");
		}

		PessoaUtils.validarCPF(preposto);
		
		if (!telefone.matches("\\d+") && !telefone.isBlank()) {
			throw new TelefoneNaoNumerico("telefone deve conter apenas números!");
		}

		if (!email.contains("@") && !email.isBlank()) {
			throw new FormatoEmailInvalidoException("Formato de email inválido!");
		}

		if (telefone.isBlank() && email.isBlank()) {
			throw new NecessarioAlgumMeioComunicacao("Insira ao menos um meio de comunicação!");
		}

	}

}