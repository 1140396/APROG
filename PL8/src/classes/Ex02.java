package classes;

import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class Ex02 {

    public static Scanner in = new Scanner(System.in);

    public static Formatter out = new Formatter(System.out);

    public static void main(String[] args) {

        int n = tamanhoMatriz();

        int[][] matriz = criarMatriz(n);

        preencherMatriz(matriz);

        //listarMatriz(matriz);
        System.out.println(verificaQuadradoMagico(matriz));
    }

    /**
     * Método que permite ao utilizador definir o tamanho da matriz quadrada que
     * quer preencher
     *
     * @return número inteiro de elementos que a matriz vai possuir nas linhas e
     * colunas
     */
    private static int tamanhoMatriz() {

        int n;

        do {

            System.out.println("Qual o tamanho que quer introduzir na matriz quadrada?");

            n = in.nextInt();
            in.nextLine();

        } while (n <= 0);

        return n;
    }

    /**
     * Método que cria a matriz quadrada com o número de elementos recebido como
     * parâmetro
     *
     * @param nElem inteiro positivo
     * @return matriz quadrada de tamanho número de elementos
     */
    private static int[][] criarMatriz(int nElem) {

        int[][] matriz = new int[nElem][nElem];

        return matriz;
    }

    /**
     * Método que permite ao utilizador preencher a matriz com números inteiros
     *
     * @param matriz de inteiros positivos e negativos
     */
    private static void preencherMatriz(int[][] matriz) {

        int elem;

        for (int linhas = 0; linhas < matriz.length; linhas++) {
            for (int colunas = 0; colunas < matriz[0].length; colunas++) {

                out.format("Introduza o número da posição %d,%d da matriz", linhas, colunas);
                System.out.println();

                elem = in.nextInt();
                in.nextLine();

                matriz[linhas][colunas] = elem;
            }
        }
    }

//    /**
//     * Método que permite fazer a listagem de uma matriz
//     *
//     * @param matriz de inteiros positivos e negativos
//     */
//    private static void listarMatriz(int[][] matriz) {
//
//        System.out.println("---- LISTAGEM MATRIZ ----");
//
//        for (int linha = 0; linha < matriz.length; linha++) {
//            for (int colunas = 0; colunas < matriz[0].length; colunas++) {
//
//                out.format("%d\t", matriz[linha][colunas]);
//            }
//            System.out.println("");
//        }
//    }
    /**
     * Método que permite verificar se a matriz introduzida é um quadrado
     * perfeito ou não
     *
     * @param matriz de inteiros positivos e negativos
     * @return boolean true no caso de ser quadrado perfeito ou false no caso de
     * não ser quadrado perfeito
     */
    public static boolean verificaQuadradoMagico(int[][] matriz) {

        boolean quadradoMagico = true;

        int primeiraLinha = 0, primeiraColuna = 0;

        for (int linhas = 0; linhas < matriz.length; linhas++) {

            int totalLinhas = 0;

            int totalColunas = 0;

            for (int colunas = 0; colunas < matriz[0].length; colunas++) {

                if (linhas == 0) {

                    primeiraLinha += matriz[linhas][colunas];

                    primeiraColuna += matriz[colunas][linhas];
                }

                totalLinhas += matriz[linhas][colunas];

                totalColunas += matriz[colunas][linhas];
            }

            if (totalLinhas != primeiraLinha || totalLinhas != totalColunas || totalColunas != primeiraColuna || primeiraColuna != primeiraLinha) {

                quadradoMagico = false;
            }
        }

        return quadradoMagico;
    }
}
