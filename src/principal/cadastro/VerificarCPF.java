/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.cadastro;

import java.util.InputMismatchException;

/**
 *
 * @author Emerson_Araujo <- INTEGRANTE QUE PRODUZIU A FUNÇÃO
 */
public class VerificarCPF {
    public static boolean validarCPF(String cpf) {
        if (cpf == null) return false;


        cpf = cpf.replaceAll("[^\\d]", "");

        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) return false;


        try {
            int soma1 = 0, soma2 = 0;
            for (int i = 0; i < 9; i++) {
                int digito = Character.getNumericValue(cpf.charAt(i));
                soma1 += digito * (10 - i);
                soma2 += digito * (11 - i);
            }

            int digito1 = soma1 % 11;
            digito1 = (digito1 < 2) ? 0 : 11 - digito1;
            soma2 += digito1 * 2;

            int digito2 = soma2 % 11;
            digito2 = (digito2 < 2) ? 0 : 11 - digito2;

            return digito1 == Character.getNumericValue(cpf.charAt(9)) &&
                    digito2 == Character.getNumericValue(cpf.charAt(10));
        } catch (Exception e) {
            return false;
        }
    }
}
