package classes;

import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class Ex9 {

    public static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {

        int cont = 0;

        int somaBin = 0;

        System.out.println("Introduza um númeor binário para converter em decimal");
        int bin = ler.nextInt();

        int guardaBin = bin;

        while (bin > 0) {

            int aux = bin % 10;

            bin /= 10;

            somaBin += Math.pow(2, cont);

            cont++;

        }

        System.out.printf("O número binário %d = %d em décimal \n", guardaBin, somaBin);
    }
}
