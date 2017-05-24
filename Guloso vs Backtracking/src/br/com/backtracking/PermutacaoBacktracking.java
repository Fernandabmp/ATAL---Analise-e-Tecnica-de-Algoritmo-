package br.com.backtracking;

	import javax.swing.JOptionPane;
	
	public class PermutacaoBacktracking {
	
		// numero a ser listado
		private static int numero;
	
		// Vetor auxiliar que armazena as permutaçoes
		private static int[] vetorAuxiliar;
	
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
		 * metodo principal: recebe o vetor cujos elementos que serao permutados
		 * 
		 * @param vet
		 */
		public static void permuta(int[] vet) {
	
			vetorAuxiliar = new int[vet.length];
			gerarPermutacao(vet, 0);
		}
	
		/**
		 * Método que é chamado recursivamente para gerar as diferentes permutações.
		 * 
		 * @param vet
		 * @param posicao do numero na árvore
		 *            
		 */
		private static void gerarPermutacao(int[] vet, int posicao) {
	
			if (posicao == vet.length) {
				imprime();
	
			} else {
	
				for (int i = 0; i < vet.length; i++) {
	
					// Flag de parada, que indica se o elemento base foi encontrado
					// no vetor auxiliar
					boolean encontrou = false;
	
					for (int j = 0; j < posicao; j++) {
	
						// Condicao que verifica se o elemento base foi encontrado
						// no vetor auxiliar
						if (vetorAuxiliar[j] == vet[i])
							encontrou = true;
					}
	
					// Condicao que verifica a flag encontrou, para poder inserir o
					// elemento no vetor Auxiliar
					if (!encontrou) {
	
						vetorAuxiliar[posicao] = vet[i];
						gerarPermutacao(vet, posicao + 1);
					}
	
				}
	
			}
	
		}
	
		/** Imprime a permutacao */
		private static void imprime() {
	
			System.out.println();
			for (int i = 0; i < vetorAuxiliar.length; i++) {
				System.out.print(vetorAuxiliar[i] + " ");
	
			}
	
		}
	
		/** metodo principal para teste da classe */
		public static void main(String[] args) {
	
			numero = Integer.valueOf(JOptionPane.showInputDialog("Digite o Numero?"));
			PermutacaoBacktracking.permuta(vetorNumero(numero));
		}
	
	}
