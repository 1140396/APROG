package classes;

import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class Ex02 {

    static Scanner ler = new Scanner(System.in);

    static Formatter out = new Formatter(System.out);

    static final int VALOR_POR_OMISSAO = 20;

    public static void main(String[] args) {

        String[] nomes = new String[VALOR_POR_OMISSAO];

        float[] vencimentos = new float[VALOR_POR_OMISSAO];

        int nElem = 0;

        System.out.println("Introduza o nome do trabalhador: (para terminar digite tt)");

        String nome = ler.nextLine();

        if (nome.trim().toLowerCase().equalsIgnoreCase("tt")) {

            System.out.println("sem dados");
        } else {

            while (!nome.equalsIgnoreCase("tt") && nElem < nomes.length) {

                nomes[nElem] = nome;

                System.out.println("Qual o vencimento do trabalhador " + nomes[nElem]);

                vencimentos[nElem] = ler.nextFloat();
                ler.nextLine();

                System.out.println("Introduza o nome do trabalhador: (para terminar digite tt");

                nome = ler.nextLine();

                nElem++;
            }

            float mediaVencimentos = calcularMedia(vencimentos, nElem);

            listarVencMenorMedia(nomes, vencimentos, mediaVencimentos, nElem);

            mostrarVencimentoFunc(vencimentos, nElem);
        }
    }

    /**
     * Método que faz o cálculo da média dos vencimentos inseridos no vetor
     *
     * @param vencimentos valor do tipo float não negativo e diferente de 0
     * @param nElem valor inteiro de elementos adicionados no vetor
     * @return média dos vencimentos dos funcionários inseridos no vetor
     */
    static float calcularMedia(float[] vencimentos, int nElem) {

        float media;

        float somaElem = 0;

        int cont = 0;

        for (int i = 0; i < nElem; i++) {

            somaElem += vencimentos[i];

            cont++;
        }

        media = (somaElem / cont);

        return media;
    }

    /**
     * Método que lista os nomes dos funcionários com vencimento inferior à
     * média
     *
     * @param nomes vetor que contem a String de nomes dos funcionários
     * @param vencimentos vetor que contem os vencimentos de cada um dos
     * funcionários
     * @param media valor da média dos vencimentos dos funcionários introduzidos
     * no vetor nomes
     * @param nElem valor inteiro positivo de elementos adicionados no vetor
     */
    static void listarVencMenorMedia(String[] nomes, float[] vencimentos, float media, int nElem) {

        System.out.println("Listagem dos funcionários com vencimento inferior à média: ");

        for (int i = 0; i < nElem; i++) {

            if (vencimentos[i] < media) {

                out.format("%s%n", nomes[i]);
            }
        }
    }

    /**
     * Método que mostra os funcionários que obtenham um rendimento inferior a n
     *
     * @param vencimentos número decimal positivo diferente de 0
     * @param nElem valor inteiro positivo de elementos adicionados no vetor
     */
    static void mostrarVencimentoFunc(float[] vencimentos, int nElem) {

        int cont = 0;

        System.out.println("Insira o valor do vencimento que quer verificar");

        float venc = ler.nextFloat();

        for (int i = 0; i < nElem; i++) {

            if (vencimentos[i] < venc) {

                cont++;
            }
        }

        double calcPercentagem = (double) (((double) cont / (double) nElem) * 100);

        if (cont != 0) {
            out.format("%.2f%%", calcPercentagem);
        } else {
            System.out.println("sem dados");
        }
        System.out.println("");
    }
}
