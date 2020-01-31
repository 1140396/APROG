package classes;

import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author bruno 
 */
public class Ex03 {

    static Scanner in = new Scanner(System.in);

    static Formatter out = new Formatter(System.out);

    private static final int N_LINHAS_MATRIZ = 4;

    private static final int N_COLUNAS_MATRIZ = 3;

    public static void main(String[] args) {

        int[][] matrizTeste = {{8, -5, 3, 8}, {6, 3, 10, 1}, {10, 8, -5, 2}};

        int tamanhoMax = (N_LINHAS_MATRIZ * N_COLUNAS_MATRIZ);

        int[][] matriz = new int[N_LINHAS_MATRIZ][N_COLUNAS_MATRIZ];

        int[] vetorValores = new int[tamanhoMax];

        preencherMatriz(matriz);

        copiaMatrizToVetor(matrizTeste, vetorValores);

        int tamanhoVecSemRepetidos = removeRepetidos(vetorValores);

        int[] vecOcorrencias = verificaOcorrencias(matrizTeste, vetorValores, tamanhoVecSemRepetidos);

        int[][] matrizOcorrencias = new int[2][tamanhoVecSemRepetidos];

        vetoresToMatriz(matrizOcorrencias, vecOcorrencias, vetorValores, tamanhoVecSemRepetidos);

        listarMatriz(matrizOcorrencias);

    }

    /**
     * Método que permite ao utilizador preencher uma matriz de números inteiros
     * recebida como parâmetro
     *
     * @param m de inteiros preenchida pelo utilizador
     */
    private static void preencherMatriz(int[][] m) {

        for (int linhas = 0; linhas < m.length; linhas++) {
            for (int colunas = 0; colunas < m[0].length; colunas++) {

                out.format("Introduza o elemento na posição %d,%d", linhas, colunas);
                System.out.println();

                m[linhas][colunas] = in.nextInt();
            }
        }
    }

    /**
     * Método que permite fazer a cópia dos elementos inteiros de uma matriz
     * para um vetor
     *
     * @param matriz - de números inteiros definidos pelo utilizador
     * @param vetorCopia - vetor que armazena todos os elementos da matriz
     */
    private static void copiaMatrizToVetor(int[][] matriz, int[] vetorCopia) {

        int nElem = 0;

        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {

                vetorCopia[nElem] = matriz[linha][coluna];

                nElem++;
            }
        }
    }

    /**
     * Método que permite remover os elementos inteiros repetidos de um vetor
     * recebido com parâmetro
     *
     * @param vec - de inteiros
     * @return novo número de elementos depois de retirar os repetidos
     */
    private static int removeRepetidos(int[] vec) {

        int nElem = vec.length;

        int[] vecSemRepetidos = new int[nElem];

        for (int i = 0; i < nElem - 1; i++) {

            for (int j = i + 1; j < nElem; j++) {

                if (vec[i] == vec[j]) {
                    for (int k = j; k < nElem - 1; k++) {

                        vec[k] = vec[k + 1];

                    }

                    j--;
                    nElem--;
                }

            }

        }
        return nElem;
    }

    /**
     * Método que verifica as ocorrências de um determinado elemento numa matriz
     *
     * @param matriz - de todos os elementos inteiros introduzidos pelo
     * utilizador
     * @param vecValores - vetor de elementos inteiros não repetidos
     * @param nElem - existentes no vetor de não repetidos
     * @return vetor com o valor de cada ocorrência de um determinado valor na
     * matriz
     */
    private static int[] verificaOcorrencias(int[][] matriz, int[] vecValores, int nElem) {

        int[] ocorrencias = new int[nElem];

        for (int i = 0; i < nElem; i++) {

            int contOcorrencias = 0;

            for (int linha = 0; linha < matriz.length; linha++) {
                for (int coluna = 0; coluna < matriz[0].length; coluna++) {

                    if (vecValores[i] == matriz[linha][coluna]) {

                        contOcorrencias++;

                        ocorrencias[i] = contOcorrencias;
                    }

                }
            }
        }

        return ocorrencias;
    }

    /**
     * Método que faz a conversão de 2 vetores para uma matriz
     *
     * @param matrizOcorrencias - matriz de valores inteiros que vai receber os
     * 2 vetores
     * @param ocorrencias - vetor de ocorrências
     * @param valores - vetor de valores
     * @param nElem - número de elementos existentes nos vetores
     */
    private static void vetoresToMatriz(int[][] matrizOcorrencias, int[] ocorrencias, int[] valores, int nElem) {

        for (int i = 0; i < nElem; i++) {

            matrizOcorrencias[0][i] = valores[i];

            matrizOcorrencias[1][i] = ocorrencias[i];
        }
    }

    private static void ordenarCrescenteOcorrencias(int[][] matrizOcorrencias) {

    }

    /**
     * Método que faz uma representação textual formatada de uma matriz recebida
     * como parâmetro
     *
     * @param matriz - de números inteiros
     */
    private static void listarMatriz(int[][] matriz) {

        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {

                System.out.printf("%4d", matriz[linha][coluna]);
            }
            System.out.println();
        }
    }
}
