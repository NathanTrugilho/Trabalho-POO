package util;

import exception.CPFInvalidoException;
import exception.CPFNaoNumericoException;

public class VerificaCPF {

    public static void validarCPF(String cpf) throws CPFInvalidoException, CPFNaoNumericoException {
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("[^\\d]", "");

        // Verifica se o CPF contém 11 dígitos
        if (cpf.length() != 11) {
            throw new CPFInvalidoException("CPF deve conter 11 dígitos.");
        }

        // Verifica se todos os caracteres são números
        if (!cpf.matches("\\d+")) {
            throw new CPFNaoNumericoException("CPF deve conter apenas números.");
        }

        // Verifica se o CPF é uma sequência repetida (ex: 111.111.111-11)
        if (cpf.matches("(\\d)\\1{10}")) {
            throw new CPFInvalidoException("CPF inválido.");
        }

        // Verificação dos dígitos verificadores
        if (!isCPFValid(cpf)) {
            throw new CPFInvalidoException("CPF inválido.");
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
}
