package classes;

import java.util.Formatter;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class Ex06Complementar {

    static Scanner in = new Scanner(System.in);

    Formatter out = new Formatter(System.out);

    static final int MIN_POR_DEFEITO = 1;

    static final int MAX_POR_DEFEITO = 9;

    public static void main(String[] args) {

        String sux = "Be";

        System.out.println(sux.length());

        String b = Character.toString(sux.charAt(sux.length() - 1));

        System.out.println(b);

    }

    static int gerarNum() {

        Random numero = new Random();

        int randomNum = numero.nextInt((MAX_POR_DEFEITO - MIN_POR_DEFEITO) + 1) + MIN_POR_DEFEITO;

        return randomNum;
    }

    static boolean verificaDig(int numero, int randomNum) {

        int auxDig, auxDigRandom;

        boolean flag = false;

        int cont = 0;

        int contIguais = 0;

        int auxIguais = 0;

        int auxDiferentes = 0;

        while (numero != 0 || randomNum != 0) {

            auxDig = numero / 10;

            numero /= 10;

            auxDigRandom = randomNum / 10;

            randomNum /= 10;

            cont++;

            if (auxDig == auxDigRandom) {

                contIguais++;

                auxIguais += contIguais;

            } else {

                auxDiferentes = cont - contIguais;
            }

            System.out.printf("Certo: %d", auxIguais);
            System.out.println("");
            System.out.printf("Deslocados: %d", auxDiferentes);
            System.out.println("");
        }
        return flag;

    }
}
