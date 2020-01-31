package classes;

import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class Ex01Complementar {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Quantos números vai introduzir?");

        int n = in.nextInt();
        in.nextLine();

        int nElem = 0;

        int[] numInt = new int[n];

        while (nElem < n) {

            System.out.println("Introduza um número inteiro no vetor");

            numInt[nElem] = in.nextInt();
            in.nextLine();

            nElem++;
        }

        double m = calcularMedia(numInt, nElem);
        
        System.out.println("---- LISTAGEM DE NÚMEROS SUPERIORES À MÉDIA ----");
        
        mostrarNumMaiorMedia(m, numInt, nElem);
    }

    static double calcularMedia(int[] vec, int nElem) {

        double media;

        int soma = 0;

        for (int i = 0; i < nElem; i++) {

            soma += vec[i];
        }

        media = (double) (soma / nElem);

        return media;
    }

    static void mostrarNumMaiorMedia(double media, int[] vec, int nElem) {

        String aux = "";

        for (int i = 0; i < nElem; i++) {
            if (vec[i] > media) {

                aux += vec[i] + " ";
            }
        }

        System.out.println(aux);
    }
}
