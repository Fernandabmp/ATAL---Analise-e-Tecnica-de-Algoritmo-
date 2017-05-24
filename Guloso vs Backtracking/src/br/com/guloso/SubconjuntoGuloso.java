package br.com.guloso;

import javax.swing.JOptionPane;

public class SubconjuntoGuloso {
	
	// numero inserido para gerar conjuntos
	private static int numero;
	
	// vetor que armazena os subconjuntos
	private static int vetor[];
	

	/**
	 * @param elemento base 
	 * @param numero do conjunto
	 */
	public static void subconjunto(int elemento, int numero) {

		
		if (elemento > numero) {
			System.out.printf("{");

			for (int posicao = 1; posicao <= numero; posicao++)
				if (vetor[posicao] == 1) {
					System.out.printf(" %d ", posicao);
				}

			System.out.printf("} \n");

		} else {
			
			vetor[elemento] = 1;
			subconjunto(elemento + 1, numero);
			vetor[elemento] = 0;
			subconjunto(elemento + 1, numero);
		}
	}

	public static void main(String[] args) {

		numero = Integer.valueOf(JOptionPane.showInputDialog("Digite o Numero?"));
		vetor = new int[numero+ 1];
		subconjunto(1, numero);
	}
}
