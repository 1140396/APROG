package classes;

import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class Ex01 {

    static Scanner ler = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int i, s = 0, c = 0;

        int[] v = new int[10];

        for (i = 0; i < v.length; i++) {

            System.out.println("Número ?");

            v[i] = ler.nextInt();
        }
        for (i = 0; i < v.length; i++) {

            if (v[i] % 2 == 0) {
                s = s + v[i];
                c++;
            }
        }
        if (c != 0) {
            System.out.println(((double) s) / c);
        } else {
            System.out.println("Operação impossível de realizar");
        }

        int menorValorVetor = valorMenor(v);

        System.out.println("O menor valor armazenado no vetor lido é, " + menorValorVetor + " que está localizado no indíce: " + indiceMenorValor(menorValorVetor, v));
        //System.out.println("O menor valor armazenado no vetor lido é, " + menorValorVetor + " que está localizado no indíce: " + indiceMenorValor + " do vetor");
    }

    /**
     * Método que retorna o menor valor encontrado no vetor v
     *
     * @param vec vetor de números inteiros positivos ou negativos
     * @return o menor valor inserido no vetor
     */
    private static int valorMenor(int[] vec) {

        int valor;

        int guardaMenorVal = vec[0];

        for (int i = 0; i < vec.length; i++) {

            valor = vec[i];

            if (valor < guardaMenorVal) {

                guardaMenorVal = valor;
            }
        }

        return guardaMenorVal;
    }

    /**
     * Método que retorna os indices dos menores valores lidos no array
     *
     * @param menorValor menor valor inteiro que o array contem
     * @param vec vetor de números inteiros
     * @return representação textual dos indices onde existem os menores valores
     * do array
     */
    private static String indiceMenorValor(int menorValor, int[] vec) {

        int cont = 0;

        String aux = "";

        while (cont < vec.length) {

            if (menorValor == vec[cont]) {

                aux += cont + ",";
            }

            cont++;
        }
        return aux;
    }
}
