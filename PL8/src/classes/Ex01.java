package classes;

/**
 *
 * @author bruno
 */
public class Ex01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[][] matriz = {{1, 4, 2, 1}, {9, 7, 2, 2}, {1, 7, 3, 5}, {2, 5, 0, 3}, {4, 7, 2, 1}};

        enigma(matriz);

        System.out.println(enigma(matriz));

        System.out.println("---- LISTAGEM MATRIZ ----");

        listarMatriz(matriz);

        mediaColunaEGlobal(matriz);

        int[][] transposta = matrizTransposta(matriz);

        System.out.println("---- LISTAGEM DA MATRIZ TRANSPOSTA ----");

        listarMatriz(transposta);
    }

    /**
     * Método que verifica qual o último valor encontrado nas colunas da matriz
     * recebida como parâmetro
     *
     * @param mat de valores inteiros
     * @return ultimo maior valor inteiro encontrado numa das colunas da matriz
     */
    static int enigma(int[][] mat) {

        int x = 0;

        for (int i = 0; i < mat.length; i++) {

            x = mat[i][0];

            for (int j = 1; j < mat[i].length; j++) {

                if (mat[i][j] > x) {

                    x = mat[i][j];
                }
            }
        }

        return x;
    }

    /**
     * Método que permite fazer a listagem de uma matriz de inteiros que recebe
     * como parâmetro
     *
     * @param mat de inteiros
     */
    static void listarMatriz(int[][] mat) {

        for (int i = 0; i < mat.length; i++) {
            System.out.print("|");
            for (int j = 0; j < mat[0].length; j++) {

                System.out.printf("%d\t", mat[i][j]);
            }
            System.out.print("|");
            System.out.println();
        }
    }

    /**
     * Método que calcula a média de cada coluna da matriz e a média global da
     * matriz
     *
     * @param mat de inteiros
     */
    static void mediaColunaEGlobal(int[][] mat) {

        float mediaColuna;

        float mediaGlobal;

        int contElemColuna = 0;

        for (int coluna = 0; coluna < mat[coluna].length; coluna++) {

            int somaColuna = 0;

            for (int linha = 0; linha < mat.length; linha++) {

                somaColuna += mat[linha][coluna];
            }

            mediaColuna = (float) somaColuna / mat.length;
            System.out.printf("Média da coluna %d: %.2f", coluna, mediaColuna);
            System.out.println("");
        }

        double somaGlobal = 0;

        for (int linha = 0; linha < mat.length; linha++) {
            for (int coluna = 0; coluna < mat[linha].length; coluna++) {
                somaGlobal += mat[linha][coluna];
            }
        }

        mediaGlobal = (float) (somaGlobal / (mat.length * mat[0].length));

        System.out.printf("Média global da matriz %.2f", mediaGlobal);
        System.out.println("");
    }

    /**
     * Método que faz a matriz transposta da que é recebida como parâmetro
     *
     * @param mat de inteiros recebidos como parâmetro
     * @return matriz transposta de valores inteiros
     */
    static int[][] matrizTransposta(int[][] mat) {

        int transposta[][] = new int[mat[0].length][mat.length];

        for (int linhas = 0; linhas < transposta.length; linhas++) {
            for (int colunas = 0; colunas < transposta[0].length; colunas++) {

                transposta[linhas][colunas] = mat[colunas][linhas];
            }
        }

        return transposta;
    }
}
