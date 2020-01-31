package classes;

import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class ServicosListagem {

    private final static Scanner in = new Scanner(System.in);

    private final static int MAX_LINHAS_POR_PAGINA = 3;

    /**
     * Método que faz a listagem do vetor de String's recebido como parâmetro
     *
     * @param jogos vetor de String's
     */
    public static void visualizarInfoJogos(String[] jogos) {

        System.out.println("--- Jogos do Evento ---");

        System.out.printf("%15s%15s%15s%n",
                "ID do Jogo", "Tipo de Jogo", "Max. de pontos");

        for (int i = 0; i < jogos.length; i++) {

            String[] temp = jogos[i].split("-");

            System.out.printf("%15s%15s%15s%n",
                    temp[0], temp[1], temp[2]);
        }
    }

    /**
     * Método que faz a representação textual do cabeçalho das páginas listadas
     */
    private static void cabecalho() {

        System.out.printf("%50s%n", "PARTICIPANTES");
        System.out.printf("%75s%n",
                "=====================================================================");
    }

    /**
     * Método que suspende a listagem, para que seja feita de 3 em 3 linhas a
     * pedido do utilizador
     */
    private static void pausa() {

        System.out.println("\n\nPara continuar digite ENTER\n");
        in.nextLine();
    }

    /**
     * Método que permite visualizar toda a informação (paginada) dos
     * participantes existentes em memória
     *
     * @param participantes - matriz com a informação a listar
     * @param nElem - nº de linhas com informação
     */
    public static void listagemPaginada(String[][] participantes, int nElem) {

        int contPaginas = 0;

        for (int i = 0; i < nElem; i++) {

            if (i % MAX_LINHAS_POR_PAGINA == 0) {

                if (contPaginas > 0) {

                    pausa();
                }
                contPaginas++;

                System.out.println("\nPágina: " + contPaginas);
                cabecalho();
            }

            for (int j = 0; j < participantes[0].length; j++) {
                if (j == 1) {
                    System.out.printf("%30s", participantes[i][j]);
                } else {
                    System.out.printf("%10s", participantes[i][j]);
                }
            }
            System.out.println();
        }
        pausa();
    }

//    public static void listarMatriz(String[][] matriz, int nElem) {
//
//        for (int linha = 0; linha < nElem; linha++) {
//            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
//
//                System.out.printf("%s\t", matriz[linha][coluna]);
//
//            }
//            System.out.println();
//        }
//    }
}
