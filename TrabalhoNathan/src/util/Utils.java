package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exception.CNPJInvalidoException;
import exception.CPFInvalidoException;
import exception.CampoNaoPreenchidoException;
import exception.DataFormatoErradoException;
import exception.FormatoEmailInvalidoException;
import exception.TelefoneInvalidoException;
import exception.TelefoneNaoNumericoException;

public class Utils {

	public static void validarEmail(String email) throws FormatoEmailInvalidoException, CampoNaoPreenchidoException {

		if (email.isBlank()) {
			throw new CampoNaoPreenchidoException("Insira um email!");
		}

		// Expressão regular para validar o email
		String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

		Pattern pattern = Pattern.compile(emailRegex);

		Matcher matcher = pattern.matcher(email);

		if (!matcher.matches()) {
			throw new FormatoEmailInvalidoException();
		}

	}

	public static void validarCPF(long cpfLong) throws CPFInvalidoException {

		String cpf = Long.toString(cpfLong);

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

	public static void validarCNPJ(long cnpjLong) throws CNPJInvalidoException {

		String cnpj = Long.toString(cnpjLong);

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

	public static Date stringToDate(String dateStr) throws DataFormatoErradoException {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return formatter.parse(dateStr);
		} catch (ParseException e) {
			throw new DataFormatoErradoException();
		}
	}

	public static void validarTelefone(long telefoneLong)
			throws TelefoneInvalidoException, TelefoneNaoNumericoException, CampoNaoPreenchidoException {

		String telefone = Long.toString(telefoneLong);

		// Remove espaços, traços, parênteses, etc.
		String telefoneLimpo = telefone.replaceAll("[^\\d]", "");

		if (telefone.isBlank()) {
			throw new CampoNaoPreenchidoException("Insira um telefone!");
		}

		// Verifica se o telefone contém apenas números
		if (!telefone.matches("\\d+")) {
			throw new TelefoneNaoNumericoException("O telefone deve conter apenas números.");
		}

		// Verifica se o telefone tem 10 ou 11 dígitos
		if (telefoneLimpo.length() != 10 && telefoneLimpo.length() != 11) {
			throw new TelefoneInvalidoException("O telefone deve ter 10 ou 11 dígitos.");
		}

		// Verifica se o código de área está entre 11 e 99
		String ddd = telefoneLimpo.substring(0, 2);
		int codigoArea = Integer.parseInt(ddd);
		if (codigoArea < 11 || codigoArea > 99) {
			throw new TelefoneInvalidoException("O código de área deve estar entre 11 e 99.");
		}

		// Verifica se o número não começa com 0 (além do código de área)
		String numero = telefoneLimpo.substring(2);
		if (numero.startsWith("0")) {
			throw new TelefoneInvalidoException("O número não pode começar com 0.");
		}
	}
}