package br.com.guloso;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Fernanda Mendonca
 *
 */
public class DivisorGuloso {
	
	private static final int VALOR_INICIAL = 1000;
	private static final int VALOR_FINAL = 99999;
	

	private static void calcula(int valor) {
		boolean possui = false;
		for (double i = VALOR_INICIAL; i < VALOR_FINAL; i++) {
			for (double j = VALOR_INICIAL; j < VALOR_FINAL; j++) {
				if (i / j == (double) valor && !PossuiRepetidos(i, j, valor)) {
					possui = true;
				}
			}
		}

		if (!possui) {
			System.out.println("There are no solutions for " + valor);
		}

	}

	private static boolean PossuiRepetidos(double nmr1, double nmr2, long valor) {
		Set<Character> conjunto1 = new HashSet<Character>();
		Set<Character> conjunto2 = new HashSet<Character>();
		Set<Character> conjunto3 = new HashSet<Character>();

		long numero1 = (long) nmr1;
		long numero2 = (long) nmr2;
		String string1 = numero1 + "";
		String string2 = numero2 + "";

		if (string1.length() == 4) {
			string1 = "0" + string1;
		}

		if (string2.length() == 4) {
			string2 = "0" + string2;
		}

		for (int i = 0; i < string1.length(); i++) {
			conjunto1.add(string1.charAt(i));
		}
		for (int i = 0; i < string2.length(); i++) {
			conjunto2.add(string2.charAt(i));
		}

		if (conjunto1.size() != 5 || conjunto2.size() != 5) {
			return true;
		}

		conjunto3.addAll(conjunto1);
		conjunto3.addAll(conjunto2);

		if (conjunto3.size() == conjunto1.size() + conjunto2.size()) {

			System.out.println(string1 + " / " + string2 + " = " + valor);
			return false;
		}
		return true;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int valor = sc.nextInt();

		while (valor != 0) {
			calcula(valor);
			valor = sc.nextInt();
		}
	}
}
