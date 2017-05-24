package br.com.guloso;

import javax.swing.JOptionPane;

import br.com.backtracking.PermutacaoBacktracking;

/**
 * @author leyds
 *
 */
public class PermutacaoGuloso {
	
	// Vetor auxiliar que armazena as permutaçoes
	private static int[] vetorAuxiliar;
	private static int tamanhoVetor;
	private static int[] entrada;
	private static int tamanhoPermut;	
	private static int numero;



	/**
	 * @param numero
	 * @return vetor com numeros entre 1 e o número
	 */
	private static int[] vetorNumero(int numero) {

		int[] vetor = new int[numero];
		for (int i = 1, posicao = 0; i < numero + 1; i++, posicao++) {
			vetor[posicao] = i;
		}
		return vetor;
	}

	
	/**
	 * @param O vetor de elementos
	 * @param tamanho do vetor
	 */
	public static void permuta(int[] ent, int tamanho) {
		tamanhoPermut = tamanho;
		tamanhoVetor = tamanho;
		vetorAuxiliar = new int[tamanhoPermut + 1];
		entrada = ent;
	}

	/**
	 * @return se existe proximo elemneto no vetor
	 */
	public static boolean isProximo() {
		
		return vetorAuxiliar[tamanhoPermut] == 0;
		
	}

	/**
	 * @return Verifica proximo elemento no vetor
	 */
	public static int[] proximoElemento() {
		int[] saida = new int[tamanhoPermut];
		int i, j;

		for (i = 0, j = tamanhoPermut - 1; i < tamanhoPermut; i++) {
			saida[j] = entrada[vetorAuxiliar[i]];
			j -= 1;
		}

		vetorAuxiliar[0] += 1;

		for (i = 0; i < tamanhoPermut; i++) {
			if (vetorAuxiliar[i] == tamanhoVetor) {
				vetorAuxiliar[i] = 0;
				vetorAuxiliar[i + 1] += 1;
			}
		}
		return saida;
	}

	/** Imprime a permutacao */
	private static void imprime() {
		int[] saida;

		while (isProximo()) {
			saida = proximoElemento();

			for (int e : saida) {
				System.out.print(e + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {	
		
		numero = Integer.valueOf(JOptionPane.showInputDialog("Digite o Numero?"));
		PermutacaoGuloso.permuta(vetorNumero(numero),numero );imprime();
		
	}

}
