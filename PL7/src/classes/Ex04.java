package classes;

import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class Ex04 {

    static Scanner ler = new Scanner(System.in);

    static Formatter out = new Formatter(System.out);

    public static void main(String[] args) {

        int n = criarVetor().length;

        int[] inteiros = new int[n];

        preencherVetor(inteiros);

        int[] vecInvertido = vetorInvertido(inteiros);

        System.out.println("---- LISTAGEM VETOR INVERTIDO ----");
        listarVetor(vecInvertido);

        int[] vecRodado = vetorRodado(vecInvertido);

        System.out.println("---- LISTAGEM VETOR RODADO ----");
        listarVetor(vecRodado);
    }

    /**
     * Método que cria um vetor com n posições dado pelo utilizador
     *
     * @return o vetor com as n posições inseridas pelo utilizador
     */
    static int[] criarVetor() {

        int n;

        int[] vec;

        do {
            System.out.println("Qual o tamanho do vetor?");

            n = ler.nextInt();

            vec = new int[n];

        } while (n <= 0);

        return vec;
    }

    /**
     * Método que faz o preenchimento do vetor com n posições determinadas pelo
     * utilizador
     *
     * @param vec números inteiros que contem n posições
     * @return vetor preenchido com números inteiros definidos pelo utilizador
     */
    static int[] preencherVetor(int[] vec) {

        int num;

        for (int i = 0; i < vec.length; i++) {

            System.out.println("Insira um número no vetor");

            num = ler.nextInt();

            vec[i] = num;
        }

        return vec;
    }

    /**
     * Método que faz a inversão do vetor de inteiros definido pelo utilizador
     *
     * @param vec números inteiros que contem n posições
     * @return vetor de números inteiros invertido
     */
    static int[] vetorInvertido(int[] vec) {

        int aux = vec.length - 1;

        int tmp;

        for (int i = 0; i < aux; i++) {

            tmp = vec[i];
            vec[i] = vec[aux];
            vec[aux] = tmp;

            aux--;
        }

        return vec;
    }

    /**
     * Método que faz a listagem de qualquer vetor recebido como parâmetro
     *
     * @param vec de números inteiros definido com n posições pelo utilizador
     */
    static void listarVetor(int[] vec) {

        for (int i = 0; i < vec.length; i++) {

            out.format("%d\t", vec[i]);
        }
        out.format("\n");
    }

    /**
     * Método que faz a rotação do vetor uma casa para a direita,
     *
     * @param vec vetor de números inteiros definido pelo utilizador
     * @return vetor rodado
     */
    static int[] vetorRodado(int[] vec) {

        int[] vecRodado = new int[vec.length];

        vecRodado[0] = vec[vec.length - 1];

        for (int i = 1; i < vec.length; i++) {

            vecRodado[i] = vec[i - 1];
        }

        return vecRodado;
    }
}
